layui.config({
    base: '/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'upload'], function () {
    var $ = layui.jquery
        , upload = layui.upload;


    $("#btn").click(function () {
        location.href ='/class/exportClassExcel'
    });
    var success = null;
    //拖拽上传
    upload.render({
        elem: '#test-upload-drag'
        , url: '/class/importTeacherExcel'
        ,accept:'file'
        , done: function (res) {
            if (res.code == 200){
                layer.msg(res.data,{icon: 1});
            }else {
                layer.alert(res.data);
            }
            success = res.data;
        }
    });

    $("#upload-success").click(function () {
        layer.alert(success);
    });

});