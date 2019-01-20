layui.config({
    base: '/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index'], function () {
    var $ = layui.$
        , layer = layui.layer;

    $("#user").click(function () {//用户协议
        layer.open({
            type: 2,
            title: '用户协议',
            area: ['900px', '800px'],
            fixed: false,
            btnAlign: 'c',
            maxmin: true,
            content: '/procotol/show?type='+ 1
        });
    });
    $("#zhifu").click(function () {//支付协议
        layer.open({
            type: 2,
            title: '支付协议',
            area: ['900px', '800px'],
            fixed: false,
            btnAlign: 'c',
            maxmin: true,
            content: '/procotol/show?type='+ 2
        });
    });
    $("#tousu").click(function () {//投诉协议
        layer.open({
            type: 2,
            title: '投诉协议',
            area: ['900px', '800px'],
            fixed: false,
            btnAlign: 'c',
            maxmin: true,
            content: '/procotol/show?type='+ 3
        });
    })
});