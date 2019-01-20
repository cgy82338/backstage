package yc.xuezhifan.schoolbackstage.help.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yc.xuezhifan.schoolbackstage.help.bean.YcHelp;
import yc.xuezhifan.schoolbackstage.help.mapper.YcHelpMapper;
import yc.xuezhifan.schoolbackstage.help.service.YcHelpService;


/**
 * <p>
 * Title: YcHelpService.java
 * </p>
 *
 * <p>
 * Description: 使用帮助service实现类
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

@Service
public class YcHelpServiceImpl implements YcHelpService {

	@Autowired
	YcHelpMapper ycHelpMapper;

	@Override
	public List<YcHelp> findAll() {
		List<YcHelp> findAll = ycHelpMapper.findAll();
		return findAll;
	}

	@Override
	public YcHelp selectHelpByName(String name) {
		return ycHelpMapper.selectHelpByName(name);
	}
}
