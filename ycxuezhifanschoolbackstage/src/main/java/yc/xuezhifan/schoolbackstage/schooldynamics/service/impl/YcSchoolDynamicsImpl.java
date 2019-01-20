package yc.xuezhifan.schoolbackstage.schooldynamics.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.YcSchoolConstants;
import yc.xuezhifan.schoolbackstage.schooldynamics.bean.YcSchoolDynamics;
import yc.xuezhifan.schoolbackstage.schooldynamics.mapper.YcSchoolDynamicsMapper;
import yc.xuezhifan.schoolbackstage.schooldynamics.service.IYcSchoolDynamicsService;
import yc.xuezhifan.schoolbackstage.schoolnotice.bean.YcNoticeSchool;
import yc.xuezhifan.schoolbackstage.utils.Page;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;

/**  

* <p>Title: YcSchoolDynamicsImpl.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年11月5日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年11月5日  

* @version 1.0  

*/
@Service
public class YcSchoolDynamicsImpl implements IYcSchoolDynamicsService{

	@Autowired
	private YcSchoolDynamicsMapper ycSchoolDynamicsMapper;

	@Override
	public JacksonData insert(YcSchoolDynamics ycSchoolDynamics) {
		System.out.println(ycSchoolDynamics.getYc_school_dynamics_title_image());
		System.out.println(ycSchoolDynamics.getYc_school_dynamics_detail());
		if (StringUtils.isBlank(ycSchoolDynamics.getYc_school_dynamics_title_image())){
			return ResultUtil.error(204,YcSchoolConstants.IMAGE);
		}else if (StringUtils.isBlank(ycSchoolDynamics.getYc_school_dynamics_detail())){
			return ResultUtil.error(204,YcSchoolConstants.CONTENT);
		}
		//设置唯一标示
		ycSchoolDynamics.setId(UUIDFactory.random());
		//设置发布时间
		ycSchoolDynamics.setYc_school_dynamics_time(new Date());
		//设置类型1.已读2.未读
		ycSchoolDynamics.setYc_school_dynamics_type(2);
		Integer rs = ycSchoolDynamicsMapper.insert(ycSchoolDynamics);
		if (RegexUtil.isNotNull(rs)) {
			return ResultUtil.success();
		}
		return ResultUtil.error(204,YcSchoolConstants.FAILURE);
	}

	@Override
	public Page findBySchool(String yc_school_dynamics_school, Integer currentPage,
							 Integer pageSize) {
		int size = ycSchoolDynamicsMapper.findBySchool(yc_school_dynamics_school).size();
		PageHelper.startPage(currentPage, pageSize);
		List<YcSchoolDynamics> ycSchoolDynamics = ycSchoolDynamicsMapper.findBySchool(yc_school_dynamics_school);
		PageInfo<YcSchoolDynamics> pageInfo = new PageInfo<>(ycSchoolDynamics);
		return new Page(0,"",size,pageInfo.getList());
	}

	@Override
	public YcSchoolDynamics selectById(String id, String yc_school_dynamics_school) {
		return ycSchoolDynamicsMapper.selectById(id, yc_school_dynamics_school);
	}

	@Override
	public String delete(String id, String yc_school_dynamics_school) {
		// 判断是否存在
		if (RegexUtil.isNull(selectById(id, yc_school_dynamics_school))) {
			return YcSchoolConstants.NOT_EXISTED;
		}
		Integer rs = ycSchoolDynamicsMapper.delete(id, yc_school_dynamics_school);
		if (RegexUtil.isNotNull(rs)) {
			return YcSchoolConstants.SUCCESS;
		}
		return YcSchoolConstants.FAILURE;
	}
}
