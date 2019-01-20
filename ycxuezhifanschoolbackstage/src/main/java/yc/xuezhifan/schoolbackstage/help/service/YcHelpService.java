package yc.xuezhifan.schoolbackstage.help.service;

import yc.xuezhifan.schoolbackstage.help.bean.YcHelp;

import java.util.List;


/**
 * <p>
 * Title: YcHelpService.java
 * </p>
 *
 * <p>
 * Description: 使用帮助service
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2019年1月11日
 * </p>
 *
 * @email xiaoyu@xuezhifan.com
 *
 * @author xiaoyu
 *
 * @date 2019年1月11日
 *
 * @version 1.0
 */
public interface YcHelpService {

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
