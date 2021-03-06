layui.config({
    base: '/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'form'], function(){
    var $ = layui.$
        ,form = layui.form;

    /* 自定义验证规则 */
    form.verify({
        classname: function(value){
            if(value.length<2 || value.length > 30){
                return '班级名称必须在2~15个字符之间';
            }
            if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
                return '班级名称不能有特殊字符';
            }
            if (/(^\_)|(\__)|(\_+$)/.test(value)) {
                return '班级名称首尾不能出现下划线\'_\'';
            }
            if (/^\d+\d+\d$/.test(value)) {
                return '班级名称不能全为数字';
            }
        }
    });

    $("#addbtn").click(function () {
        $("#leftSelect").append($("#rightSelect option:selected"));
        return false;
    });
    $("#delbtn").click(function () {
        $("#rightSelect").append($("#leftSelect option:selected"));
        return false;
    });

    // 表单提交
    form.on('submit(component-form-demo1)', function(data){
        // 班级名称
        var yc_class_name = $("#yc_class_name").val();
        //班主任id
        var yc_class_head_teacher_id = $("#yc_class_head_teacher_id option:selected").val();
        //任课教师id
        var yc_teacherIds = "";
        var  length = $("#leftSelect option").length;
        $("#leftSelect option").each(function () {
            yc_teacherIds += $(this).val();
            if ( length > 1){
                yc_teacherIds += ",";
            }
            length --;
        });
        $.ajax({
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/class/saveClass",//url
            data: {yc_class_name:yc_class_name,yc_class_head_teacher_id:yc_class_head_teacher_id,yc_teacherIds:yc_teacherIds},
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