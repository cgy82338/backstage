layui.config({
    base: '/' // 静态资源所在路径
  }).extend({
    index: 'lib/index' // 主入口模块
  }).use(['index', 'form', 'laydate','upload'], function(){
    var $ = layui.$
    ,admin = layui.admin
    ,element = layui.element
    ,layer = layui.layer
    ,laydate = layui.laydate
    ,form = layui.form
    ,upload = layui.upload;
    
    form.render(null, 'component-form-group');

    laydate.render({
      elem: '#LAY-component-form-group-date'
    });
    
    /* 自定义验证规则 */
    form.verify({
      title: function(value){
        if(value.length < 5){
          return '标题至少得5个字符啊';
        }
      }
      ,pass: [/(.+){6,12}$/, '密码必须6到12位']
      ,content: function(value){
        layedit.sync(editIndex);
      }
    });
    
    /* 监听提交 */
    form.on('submit(fileShared_add)', function (data) {
//    	alert( $("input[name='yc_file_shared_url']").val());
    	if ( $("input[name='yc_file_shared_url']").val()=="" || $("input[name='yc_file_shared_url']").val()==null )
        {
            alert("文件地址获取失败");
            return false;
        }
        $.ajax({
            url: "/fileShared/insetFileShared"
                , data: data.field
                , type: "post"
                , dataType: "json"
                , success: function (data) {
                    if (data.code == 200) {
                        layer.msg("文件发布成功！", {
                            offset: '15px'
                            ,icon: 1
                            ,time: 1000
                        }, function(){
                            layer.close(layer.index);
                            window.location.reload();//窗口刷新
                        });
                    } else {
                        layer.msg(data.msg,{icon: 5});
                    }
                }
        });
        return false;
    });
  });



