package yc.xuezhifan.schoolbackstage.fileshared.service;

import com.github.pagehelper.PageInfo;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.fileshared.bean.YcFileShared;
import yc.xuezhifan.schoolbackstage.utils.Page;


/**
 * 

* <p>Title: YcFileSharedService.java </p> 

* <p>Description: 共享文件service</p> 

* <p>Copyright: Copyright (c) 2018年10月19日</p>
 
* @email zhuangzhuang@xuezhifan.com

* @author zhuangzhuang 

* @date 2018年10月19日  

* @version 1.0
 */
public interface YcFileSharedService {

	/**
	 * <p>Title: insert</p>  
	
	 * <p>Description: 添加共享文件</p>  
	
	 * @param ycFileShared
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年10月4日
	 */
	String insert(YcFileShared ycFileShared);
	
	/**
	 * 
	
	 * <p>Title: findAllBySchool</p>  
	
	 * <p>Description: 学校获取共享文件</p>  
	
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	 * @param pageSize2 
	
	 * @date 2018年10月19日
	 */
	Page findAllBySchool(String id, Integer currentPage, Integer pageSize);
	
	JacksonData delFile(String fileId);

	
	
	
}
