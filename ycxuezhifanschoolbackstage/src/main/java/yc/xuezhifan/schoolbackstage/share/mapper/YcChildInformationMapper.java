package yc.xuezhifan.schoolbackstage.share.mapper;

import org.apache.ibatis.annotations.Mapper;
import yc.xuezhifan.schoolbackstage.share.bean.YcChildInformation;

import java.util.Date;
import java.util.List;

/**
 * @author xiaoyu
 * @version 创建时间：2019年1月2日
 *孩子信息表
 */
@Mapper
public interface YcChildInformationMapper {

	/**
	 * 根据id得到孩子信息 -->
	 * @param id
	 * @return
	 */
	YcChildInformation selectById(String id);


	
}
