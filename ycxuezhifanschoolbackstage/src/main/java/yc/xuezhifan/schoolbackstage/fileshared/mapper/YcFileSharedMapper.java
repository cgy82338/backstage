package yc.xuezhifan.schoolbackstage.fileshared.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import yc.xuezhifan.schoolbackstage.fileshared.bean.YcFileShared;

import java.util.List;


/**
 * 
* <p>Title: YcFileSharedMapper.java </p> 

* <p>Description: 文件共享</p> 

* <p>Copyright: Copyright (c) 2018年10月4日</p>
 
* @email xiaoxiao@xuezhifan.com

* @author xiaoxiao 

* @date 2018年10月4日  

* @version 1.0
 */
@Mapper
public interface YcFileSharedMapper {
	
	
	/**
	 * 
	
	 * <p>Title: findAllByTeacher</p>  
	
	 * <p>Description: 学校获取共享文件</p>  
	
	 * @param ycIntermediateTables
	 * @param schoolId
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年10月19日
	 */
	List<YcFileShared> findAllBySchool(String id);

	/**
	 * 
	
	 * <p>Title: insert</p>  
	
	 * <p>Description: 学校共享文件</p>  
	
	 * @param ycFileShared
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年10月19日
	 */
	Integer insert(YcFileShared ycFileShared);
	

	/**
	 * 学校获取共享文件条数
	 * @param ycIntermediateTables
	 * @param yc_founder
	 * @return
	 */
	Integer getAllFileSharedTotle(@Param("id") String id);

	/**
	 * 根据文件id删除文件
	 * @param fileId
	 */
	void delFile(String fileId);
	
}
