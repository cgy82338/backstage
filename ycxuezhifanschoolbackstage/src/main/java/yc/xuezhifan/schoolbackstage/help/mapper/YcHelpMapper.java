package yc.xuezhifan.schoolbackstage.help.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import yc.xuezhifan.schoolbackstage.help.bean.YcHelp;


/**
* @author xiaoyu
* @version 创建时间：2019年1月11日
* 使用帮助
*/
@Mapper
public interface YcHelpMapper {

	/**
	 * 查询所有帮助
	 * @return
	 */
	List<YcHelp> findAll();

	/**
	 * 根据名称查询使用帮助内容
	 * @param name
	 * @return
	 */
	YcHelp selectHelpByName(String name);
}
