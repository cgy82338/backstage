layui.config({
    base: '/' // 静态资源所在路径
  }).extend({
    index: 'lib/index' // 主入口模块
  }).use(['index', 'form', 'laydate','upload','layedit'], function(){
    var $ = layui.$
    ,admin = layui.admin
    ,element = layui.element
    ,layer = layui.layer
    ,laydate = layui.laydate
    ,form = layui.form
    , layedit = layui.layedit
    ,upload = layui.upload;
    		 //上传图片,必须放在 创建一个编辑器前面
               layedit.set({
                   uploadImage: {
                        url: '/aliyunUpload/uploadActivity' //接口url
                       ,type: 'post' //默认post
				    , success: function (data) {
				    	console.log(data.data.src);
				    }
                   }
               });
               //创建一个编辑器
               var editIndex = layedit.build('yc_activity_details',{
                       height:400
                   }
               );
    //调用地图
    $(document).on('click','#adress',function(){
    	
    	 layer.open({
             type: 2,
             title: '活动地点',
             shadeClose: true,
             shade: 0.8,
             anim:0,
             area: ['80%', '80%'],
             content: '/activityPage/toMap', //iframe的url
             scrollbar: false,
             btn: ['确定','关闭'],
             yes: function(index){
                 //当点击‘确定’按钮的时候，获取弹出层返回的值
                 var res = window["layui-layer-iframe" + index].callbackdata();
                 //打印返回的值，看是否有我们想返回的值。
                 console.log(res);
                 $("#yc_activity_map_location").val(res.lnglat);
                 $("#adress").val(res.address);
                 //最后关闭弹出层
                 layer.close(index);
             },
             cancel: function(){
                 //右上角关闭回调
             }
          });
    });
   
    var insStart = laydate.render({
        elem: '#yc_activity_time'
        ,format: 'yyyy/MM/dd HH:mm:ss' // 自动生成的时间格式
        ,min: 0
        ,done: function(value, date){
          // 更新结束日期的最小日期
          insEnd.config.min = lay.extend({}, date, {
            month: date.month - 1
          });
       
        }
      });
 // 开始日期
    var insStart = laydate.render({
      elem: '#yc_activity_registration_time'
      ,format: 'yyyy/MM/dd HH:mm:ss' // 自动生成的时间格式
      ,min: 0
      ,done: function(value, date){
        // 更新结束日期的最小日期
        insEnd.config.min = lay.extend({}, date, {
          month: date.month - 1
        });
        
        // 自动弹出结束日期的选择器
       insEnd.config.elem[0].focus();
      }
    });
    
    // 结束日期
    var insEnd = laydate.render({
      elem: '#yc_activity_deadline_time'
      ,format: 'yyyy/MM/dd HH:mm:ss' // 自动生成的时间格式
      ,min: 0
      ,done: function(value, date){
        // 更新开始日期的最大日期
        insStart.config.max = lay.extend({}, date, {
          month: date.month - 1
        });
      }
    });

    // 活动封面上传
    var uploadInst = upload.render({
      elem: '#activity_image'
      ,url: '/aliyunUpload/uploadActivityImage'
      ,before: function(obj){
    	  // 显示进度条
    	  document.querySelector("#progressbar").style.opacity = "2";
        // 预读本地文件示例，不支持ie8
        obj.preview(function(index, file, result){
        	avatorPercent(file.size);
          $('#activity_cover_img').attr('src', result); // 图片链接（base64）
        });
      }
      ,done: function(res){
        // 如果上传成功
        if(res.code == 200){
        	$("#yc_activity_cover_image").val(res.data);
        	// 隐藏进度条
        	document.querySelector("#progressbar").style.opacity = "0";
          return layer.msg('上传成功');
        }
        // 上传成功
      }
      ,error: function(){
        // 演示失败状态，并实现重传
        var demoText = $('#test-upload-demoText');
        demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
        demoText.find('.demo-reload').on('click', function(){
          uploadInst.upload();
        });
      }
    });
    /* 自定义验证规则 */
    form.verify({
      title: function(value){
        if(value.length < 5){
          return '标题至少得5个字符啊';
        }
      }
      ,pass: [/(.+){6,12}$/, '密码必须6到12位']
      ,yc_activity_details: function(value){
        layedit.sync(editIndex);
      }
    });
    
    /* 监听提交 */
    form.on('submit(activity_submit)', function (data) {
        $.ajax({
            url: "/ycActivity/toActivity_add/insertActivity"
                , data: data.field
                , type: "post"
                , dataType: "json"
                , success: function (data) {
                    if (data.code == 200) {
                        layer.msg(data.msg);
                       
                        location.reload();
                    }
                    else {
                        layer.alert(data.msg);
                    }
                }
        });
        return false;
    });
  });

/* 获取活动封面上传进度 */
function avatorPercent(avatorSize) { // 定时查询上传进度 0.1秒查一次
	var $ = layui.$;
	var intervalId = setInterval(function() {
		$.post("/aliyunUpload/item/percent", {}, function(obj) {
			var progress_width =  (parseInt(obj.data['percent']/avatorSize*10000)/100).toFixed(1);
			var bytes = obj.data['bytes'];
			if (progress_width < 100) {
				$("#progressbar .layui-progress-bar").css({
					'width' : progress_width + "%"
				});
				$("#progressbar .layui-progress-bar").html(progress_width + "%");
			}else{
				$("#progressbar .layui-progress-bar").css({
					'width' : "0%"
				});
				clearInterval(intervalId);
				reset();
				return;
			}
		}, "json");
	}, 100);
};

/* 重置进度 */
function reset(){
	var $ = layui.$;
	$.post("/aliyunUpload/percent/reset",{},function(obj){
	},null); 
}