package yc.xuezhifan.schoolbackstage.share.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import yc.xuezhifan.schoolbackstage.share.bean.YcChildParent;


/**
* @author linxiao
* @version 创建时间：2018年8月8日 下午3:17:26
* 孩子家长关系表
*/
@Mapper
public interface YcChildParentMapper {

	/**
	 * 添加孩子家长关系 -->
	 * @param ycChildParent
	 * @return 
	 */
	Integer insertYcChildParent(YcChildParent ycChildParent);

	/**
	 * 根据家长和孩子Id查询关系 -->
	 * @param yc_child_id
	 * @param yc_parent_id
	 * @return
	 */
	YcChildParent selectByChildAndParent(@Param("yc_child_id") String yc_child_id, @Param("yc_parent_id") String yc_parent_id);

}
