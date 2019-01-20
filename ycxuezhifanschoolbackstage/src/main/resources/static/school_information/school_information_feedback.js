layui.config({
    base: '/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'upload', 'form'], function () {
    var $ = layui.$
        , upload = layui.upload
        , form = layui.form;


    /* 自定义验证规则 */
    form.verify({
        detail: function(value){
            if(value.length > 200){
                return '教师姓名不得超过200个字符';
            }
        }
    });



    //多图片上传
    upload.render({
        elem: '#test-upload-more'
        , url: '/aliyunUpload/uploadImage'
        , multiple: true
        , before: function (obj) {
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#test-upload-more-list').append('<img src="' + result + '" alt="' + file.name + '" class="layui-upload-img">')
            });
        }
        , done: function (res) {
            // 如果上传成功
            if (res.code == 200) {
                var img = $("#yc_notice_image").val();
                if (img == "" || img == null) {
                    $("#yc_notice_image").val(res.data);
                } else {
                    $("#yc_notice_image").val(res.data + "," + img);
                }
            } else {
                return layer.msg('上传失败',{icon:5});
            }
        }
        , error: function () {
            //演示失败状态，并实现重传
            var demoText = $('#test-upload-demoText');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function () {
                uploadInst.upload();
            });
        }
    });

    //发布
    form.on('submit(LAY-user-feedback-submit)', function(data){
        $.ajax({
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/feedback/insertfeedback",//url
            data: data.field,
            success: function (result) {
                if (result.code == 200){
                    layer.msg(result.msg, {
                        offset: '15px'
                        ,icon: 1
                        ,time: 1000
                    }, function(){
                        location.reload();
                    });
                } else {
                    layer.msg(result.msg,{icon:5});
                }
            }
        });
        return false;
    });

});