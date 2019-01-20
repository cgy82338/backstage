layui.config({
    base: '/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'user'], function () {
    var $ = layui.$
        , setter = layui.setter
        , admin = layui.admin
        , form = layui.form
        , router = layui.router();
    form.render();
    //找回密码下一步
    form.on('submit(LAY-user-forget-submit)', function (obj) {
        var field = obj.field;
        var phone = field.yc_mobile;
        localStorage.phone = phone;//存手机号
        //请求接口
        $.ajax({
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/sms/checkUpPass",//url
            data: field,
            success: function (result) {
                if (result.code == 200) {
                    location.hash = '/type=resetpass';
                    location.reload();
                } else {
                    layer.msg('验证码错误',{icon:5});
                }
            }
        });
        return false;
    });

    //重置密码
    form.on('submit(LAY-user-forget-resetpass)', function (obj) {
        var field = obj.field;
        //确认密码
        if (field.password !== field.repass) {
            return layer.msg('两次密码输入不一致',{icon:5});
        }

        var phone = localStorage.phone;//取手机号
        //请求接口
        admin.req({
            url: '/sms/upPassword' //实际使用请改成服务端真实接口
            , type: "POST"
            , data: {
                password:field.password,
                phone: phone
            }
            , done: function (res) {
                layer.msg('密码已成功重置', {
                    offset: '15px'
                    , icon: 1
                    , time: 1000
                }, function () {
                    location.href = '/school/toLogin'; //跳转到登入页
                });
            }
        });
        return false;
    });

});