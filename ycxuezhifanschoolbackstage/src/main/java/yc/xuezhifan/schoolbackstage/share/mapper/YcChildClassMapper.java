package yc.xuezhifan.schoolbackstage.share.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import yc.xuezhifan.schoolbackstage.share.bean.YcChildClass;
import yc.xuezhifan.schoolbackstage.share.bean.YcChildParent;


/**
* @author linxiao
* @version 创建时间：2018年8月9日 上午8:09:10
* 孩子班级关系表
*/
@Mapper
public interface YcChildClassMapper {


	/**
	 * 
	
	 * <p>Title: selectByChildId</p>  
	
	 * <p>Description: 根据孩子id查询班级信息</p>  
	
	 * @param childId
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年10月9日
	 */
	List<YcChildClass> selectByChildId(String childId);

	
	 
}
