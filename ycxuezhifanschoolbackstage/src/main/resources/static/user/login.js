layui.config({
    base: '/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index'], function () {
    var $ = layui.$;
    /* 学校登录 */
    $('#btn_login').click(function() {

        var uname = $("#LAY-user-login-username").val();
        var pwd = $("#LAY-user-login-password").val();

        if (null == uname || "" == uname) {
            layer.msg("请输入用户名");
            return false;
        }
        if (null == pwd || "" == pwd) {
            layer.msg("请输入密码");
            return false;
        }
        $.ajax({
            'url' : '/school/login',
            'type' : 'post',
            'data' : {
                'username' : uname,
                'password' : pwd
            },
            'dataType' : 'json',
            'success' : function(obj) {

                if (200 == obj.code) {
                    //登入成功的提示与跳转
                    layer.msg('登入成功', {
                        offset: '15px'
                        ,icon: 1
                        ,time: 1000
                    }, function(){
                        location.href = '/school/index'; //后台主页
                    });
                } else {
                    layer.msg(obj.msg,{icon:5});
                }
            }
        });
    });

});