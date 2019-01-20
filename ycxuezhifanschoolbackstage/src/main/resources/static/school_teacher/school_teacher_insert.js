layui.config({
    base: '/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'form','upload'], function(){
    var $ = layui.$
        ,form = layui.form
        ,upload = layui.upload;

    /* 自定义验证规则 */
    form.verify({
        username: function(value){
            if(value.length < 2 || value.length > 15){
                return '教师姓名必须在2~15个字符之间';
            }
            if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
                return '教师姓名不能有特殊字符';
            }
            if (/(^\_)|(\__)|(\_+$)/.test(value)) {
                return '教师姓名首尾不能出现下划线\'_\'';
            }
            if (/^\d+\d+\d$/.test(value)) {
                return '教师姓名不能全为数字';
            }
        },
        nickname: function(value){
            if(value.length > 15){
                return '昵称不得超过15个字符';
            }
        }

    });

    //头像上传
    var uploadInst = upload.render({
        elem: '#test-upload-normal'
        , url: '/aliyunUpload/uploadAvator'
        , before: function (obj) {
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#test-upload-normal-img').attr('src', result); //图片链接（base64）
            });
        }
        , done: function (res) {
            // 如果上传成功
            if (res.code == 200) {
                var img = $("#yc_dynamic_image").val();
                if (img == "" || img == null) {
                    $("#yc_dynamic_image").val(res.data);
                } else {
                    $("#yc_dynamic_image").val(res.data + "," + img);
                }
            }else {
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

    //表单提交
    form.on('submit(component-form-demo1)', function(data){
        $.ajax({
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/teacher/saveTeacher",//url
            data: data.field,
            success: function (result) {
                if (result.code == 200){
                    //登入成功的提示与跳转
                    layer.msg(result.msg, {
                        offset: '15px'
                        ,icon: 1
                        ,time: 1000
                    }, function(){
                      location.reload();
                    });
                } else {
                    layer.msg(result.msg,{icon: 5});
                }
            }
        });
        return false;
    });
});