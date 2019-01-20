layui.config({
    base: '/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'form'], function () {
    var $ = layui.$
        , form = layui.form;


    //自定义验证
    form.verify({
        pass: [
            /^[\S]{6,15}$/
            , '密码必须6到15位，且不能出现空格'
        ]
    });

    //发布
    form.on('submit(LAY-user-password-submit)', function (data) {
        var field = data.field;

        if (field.formerpass === field.newqpass) {
            layer.msg("原密码与新密码不能一致",{icon:5});
            return false;
        }
        if (field.newqpass !== field.rqnewqpass) {
            layer.msg("两次输入密码不一致",{icon:5});
            return false;
        }
        $.ajax({
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/school/updatepassword",//url
            data: data.field,
            success: function (result) {
                if(result.code == 200){
                    layer.msg(result.msg, {
                        offset: '15px'
                        , icon: 1
                        , time: 1000
                    }, function () {
                        location.reload();
                    });
                }else {
                    layer.msg(result.msg,{icon:5});
                }
            }
        });
        return false;
    });

});