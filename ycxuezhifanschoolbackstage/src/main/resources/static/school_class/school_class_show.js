/**

 @Name：教师展示
 @Author：xiaoyu
 @Site：xiaoyu.xuezhifan.com
 @License：LPPL（layui付费产品协议）

 */
layui.config({
    base: '/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'table'], function () {
    var table = layui.table
        , $ = layui.$;

    //点击搜索传送额外参数
    $("#search").click(function () {
        var username = $("#ycusernmae").val();
        tableIns.reload({
            where: {
                ycusername: username
            }
        });
    });

    var tableIns = table.render({
        elem: '#test-table-page'//表格id
        , request: {
            pageName: 'currentPage', // 页码的参数名称，默认：page
            limitName: 'pageSize' // 每页数据量的参数名，默认：limit
        }
        , url: '/class/getClassByschoolid'
        , method: 'post'//请求方式
        , cols: [[
            {field: 'yc_class_number', title: '班级编号', sort: true}
            , {field: 'yc_class_name', title: '班级名称', sort: true}
            , {field: 'yc_class_head_teacher_name', title: '班主任', sort: true}
            , {field: 'yc_class_introduction', title: '任课教师', sort: true}
            , {align: 'center', fixed: 'right', title: '操作', toolbar: '#table-content-list'}
        ]]
        , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
            //,curr: 5 //设定初始在第 5 页
            , groups: 5 //显示 5 个连续页码
            , first: false //不显示首页
            , last: false //不显示尾页
        }
    });

    //监听行工具事件
    table.on('tool(test-table-page)', function (obj) {
        var data = obj.data;
            /* 触发弹层 */
            layer.open({
                type: 2
                , title: '修改教师信息'
                , content: '/class/schoolclassopen?id=' + data.yc_class_id
                , maxmin: true
                , area: ['800px', '600px']
                , btn: ['确定', '取消']
                , btnAlign: 'c'
                , yes: function (index, layero) {
                    //点击确认触发 iframe 内容中的按钮提交
                    var submit = layero.find('iframe').contents().find("#layuiadmin-app-form-submit");
                    submit.click();
                }
            });
    });

});