 layui.config({
    base: '/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'table', 'form'], function(){
    var admin = layui.admin
    ,table = layui.table
    ,form = layui.form
    ,$ = layui.$;
    
    table.render({
    	elem: '#test-table-toolbar'
    	,request: {
    		    pageName: 'currentPage', //页码的参数名称，默认：page
    		    limitName: 'pageSize' //每页数据量的参数名，默认：limit
    	}
      ,url: '/ycActivity/toActivity_list/findAllActivity'
      ,toolbar: '#test-table-toolbar-toolbarDemo'
      ,title: '用户数据表'
      ,cols: [[
        {type: 'numbers', fixed: 'left'}
        ,{field:'yc_activity_title', title:'活动标题', width:150, fixed: 'left', unresize: true, sort: true}
        ,{field:'yc_activity_sponsor', title:'活动发起人', width:150, edit: 'text'}
        ,{field:'yc_activity_location', title:'活动地点', width:225, edit: 'text'}
        ,{field:'yc_activity_phone', title:'联系电话', width:200, sort: true}
        ,{field:'yc_activity_people_number', title:'活动名额', width:200, edit: 'text'}
        ,{field:'yc_activity_single_fee', title:'单人费用(元/人)', width:200, edit: 'text'}
        ,{field:'yc_activity_time', title:'活动时间', width:200, sort: true}
        ,{field:'yc_activity_registration_time', title:'报名时间', width:150, sort: true}
        ,{field:'yc_activity_deadline_time', title:'截止时间', width:200, sort: true}
        ,{fixed: 'right',field:'yc_activity_type', title:'状态', width:100, sort: true, templet: '#flag_table_switchTpl', unresize: true}
        ,{fixed: 'right', title:'操作', toolbar: '#test-table-toolbar-barDemo', width:230}
      ]]
      ,page: true
    });
    
    //监听行工具事件
    table.on('tool(test-table-toolbar)', function(obj){
      var data = obj.data;
      if(obj.event === 'del'){
        layer.confirm('真的删除行么', function(index){
        	
          $.post('/ycActivity/toActivity_list/deleteActivity',{id:data.id},function(obj){
        	  if(obj.code == 200){
        		  layer.msg(obj.msg);
                  location.reload();
        	  }else{
        		  layer.alert(obj.msg);
        	  }
          });
        });
      } else if(obj.event === 'edit'){
    	  /* 触发弹层 */
    	  layer.open({
	          type: 2
	          ,content: '/ycActivity/toActivity_list/selectById?id='+data.id
	          ,shadeClose: true
	          ,area: admin.screen() < 2 ? ['100%', '80%'] : ['1300px', '800px']
	          ,maxmin: true
	        });   		
      }else if(obj.event === 'examine'){
    	  
    	  layer.open({
	          type: 2
	          ,content: '/activityPage/toActivityApplicant_list?id='+data.id
	          ,shadeClose: true
	          ,area: admin.screen() < 2 ? ['100%', '80%'] : ['1300px', '800px']
	          ,maxmin: true
	        }); 
      }
    });
    
    //监听状态操作
    form.on('switch(flag_table)', function(obj){
      var json = JSON.parse(decodeURIComponent($(this).data('json')));
      json = table.clearCacheKey(json);//当前行数据
      var yc_activity_type = json.yc_activity_type == 1? 2:1;
      $.post('/ycActivity/toActivity_list/modify',{'id':json.id,'yc_activity_type':yc_activity_type},function(obj){
      	  if (obj.code == 200) {
      		layer.msg('操作成功', {icon: 1});
            }else {
                layer.alert(obj.msg);
            }
        });
    });
  
  });