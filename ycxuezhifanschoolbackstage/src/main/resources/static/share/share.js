layui.config({
    base: '/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'user','form'], function () {
    var $ = layui.$
        , form = layui.form;
});
