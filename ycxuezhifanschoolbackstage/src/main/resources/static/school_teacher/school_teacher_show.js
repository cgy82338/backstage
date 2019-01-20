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
        ,$=layui.$;

    //点击搜索传送额外参数
    $("#search").click(function () {
        var username = $("#ycusernmae").val();
        tableIns.reload({
            where:{
            ycusername:username
        }
        });
    });

    var tableIns = table.render({
        elem: '#test-table-page'//表格id
        ,request:{
            pageName : 'currentPage', // 页码的参数名称，默认：page
            limitName : 'pageSize' // 每页数据量的参数名，默认：limit
        }
        ,url: '/teacher/getTeacherBySchoolid'
        ,method:'post'//请求方式
        ,cols: [[
            {field:'yc_id', title: '小帆号',sort:true}
            ,{field:'yc_phone', title: '手机号',sort:true}
            ,{field:'yc_username', title: '教师姓名',sort:true}
            ,{field:'yc_province',title: '地址',sort:true}
            ,{field:'yc_map_address', title: '地图地址',sort:true}
            ,{align:'center', fixed: 'right',title: '操作', toolbar: '#table-content-list'}
        ]]
        , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
            //,curr: 5 //设定初始在第 5 页
            ,groups: 5 //显示 5 个连续页码
            ,first: false //不显示首页
            ,last: false //不显示尾页
        }
    });

    //监听行工具事件
    table.on('tool(test-table-page)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
          layer.confirm('确认删除该教师吗', function(index){
            $.post('/teacher/deleteTeacherById',{teacherId:data.id},function(result){
                if (result.code == 200){
                    //登入成功的提示与跳转
                    layer.msg(result.msg, {
                        offset: '15px'
                        ,icon: 1
                        ,time: 1000
                    }, function(){
                        table.reload('test-table-page'); //重载表格
                    });
                } else {
                    layer.msg(result.msg,{icon:5});
                }

            });
          });
        } else if(obj.event === 'edit'){
            /* 触发弹层 */
            layer.open({
                type: 2
                ,title: '修改教师信息'
                ,content: '/teacher/schoolteacheropen?id='+data.id
                ,maxmin: true
                ,area: ['800px', '600px']
                ,btn: ['确定', '取消']
                ,btnAlign: 'c'
                ,yes: function(index, layero){
                    //点击确认触发 iframe 内容中的按钮提交
                    var submit = layero.find('iframe').contents().find("#layuiadmin-app-form-submit");
                    submit.click();
                }
        });
        }
    });

});