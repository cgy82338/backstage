layui.config({
    base: '/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index'], function () {
    var $ = layui.$
        , layer = layui.layer;

    $("#reg").click(function () {//如何注册用户
        layer.open({
            type: 2,
            title: '如何注册用户',
            area: ['900px', '800px'],
            fixed: false,
            btnAlign: 'c',
            maxmin: true,
            content: '/help/show?name=如何注册用户'
        });
    });
    $("#money").click(function () {//充值流程
        layer.open({
            type: 2,
            title: '充值流程',
            area: ['900px', '800px'],
            fixed: false,
            btnAlign: 'c',
            maxmin: true,
            content: '/help/show?name=充值流程'
        });
    });
    $("#course").click(function () {//如何观看课程
        layer.open({
            type: 2,
            title: '如何观看课程',
            area: ['900px', '800px'],
            fixed: false,
            btnAlign: 'c',
            maxmin: true,
            content: '/help/show?name=如何观看课程'
        });
    })
});