 layui.config({
    base: '/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'table', 'form','upload'], function(){
    var admin = layui.admin
    ,table = layui.table
    ,form = layui.form
    ,$ = layui.$
    ,laypage = layui.laypage
    ,upload = layui.upload;
    
    table.render({
      elem: '#test-table-toolbar'
	  ,request : {
		pageName : 'currentPage', // 页码的参数名称，默认：page
		limitName : 'pageSize' // 每页数据量的参数名，默认：limit
  	  }
      ,url: '/fileShared/findAllBySchool'
      ,toolbar: '#test-table-toolbar-toolbarDemo'
      , method: 'post'//请求方式
      ,cols: [[
         {type: 'numbers', fixed: 'left',title:'序号'}
        ,{field:'yc_file_shared_name', title:'文件名', sort: true}
        ,{field:'yc_file_shared_time', title:'共享时间',sort: true}
        ,{field:'yc_file_shared_size', title:'文件大小',sort: true}
        ,{field:'yc_user_id', title:'上传人', sort: true}
        ,{fixed: 'right', title:'操作', toolbar: '#test-table-toolbar-barDemo', width:210}
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
   table.on('tool(test-table-toolbar)', function(obj){
      var data = obj.data;
      if(obj.event === 'edit'){
    	  window.open( data.yc_file_shared_url );
      }else if(obj.event === 'del'){
          layer.confirm('确认删除该文件吗', function(index){
              $.post('/fileShared/delFile',{fileId:data.yc_file_shared_id},function(result){
                  if (result.code == 200){
                      //登入成功的提示与跳转
                      layer.msg(result.msg, {
                          offset: '15px'
                          ,icon: 1
                          ,time: 1000
                      }, function(){
                          table.reload('test-table-toolbar'); //重载表格
                      });
                  } else {
                      layer.msg(result.msg,{icon:5});
                  }

              });
          });
      }
    });


   
  
  });