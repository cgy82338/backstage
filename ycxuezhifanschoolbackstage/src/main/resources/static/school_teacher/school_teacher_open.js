layui.config({
    base: '/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'form'], function(){
    var $ = layui.$
        ,form = layui.form;

    /* 自定义验证规则 */
    form.verify({
        username: function(value){
            if(value.length < 2 || value.length > 20){
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
            if(value.length > 20){
                return '昵称不得超过15个字符';
            }
        }

    });


    //监听提交
    form.on('submit(layuiadmin-app-form-submit)', function(data){
        var field = data.field; //获取提交的字段
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        //提交 Ajax 成功后，关闭当前弹层并重载表格
        $.ajax({
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/teacher/updateTeacherUser",//url
            data: field,
            success: function (result) {
                if (result.code == 200){
                    //登入成功的提示与跳转
                    layer.msg(result.msg, {
                        offset: '15px'
                        ,icon: 1
                        ,time: 1000
                    }, function(){
                        parent.layui.table.reload('test-table-page'); //重载表格
                        parent.layer.close(index); //再执行关闭
                    });

                } else {
                    layer.msg(result.msg,{icon:5});
                }
            }
        });
    });
});