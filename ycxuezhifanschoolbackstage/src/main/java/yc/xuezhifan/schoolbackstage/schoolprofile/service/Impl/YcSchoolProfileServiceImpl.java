package yc.xuezhifan.schoolbackstage.schoolprofile.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yc.xuezhifan.schoolbackstage.constants.YcSchoolConstants;
import yc.xuezhifan.schoolbackstage.schoolprofile.bean.YcSchoolProfile;
import yc.xuezhifan.schoolbackstage.schoolprofile.mapper.YcSchoolProfileMapper;
import yc.xuezhifan.schoolbackstage.schoolprofile.service.YcSchoolProfileService;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;

/**  
* <p>Title: YcChargesServiceImpl.java </p> 

* <p>Description: 学校概况</p> 

* <p>Copyright: Copyright (c) 2018年12月18日</p>
 
* @email xiaoxiao@xuezhifan.com

* @author xiaoxiao 

* @date 2018年12月18日  

* @version 1.0  

*/
@Service
public class YcSchoolProfileServiceImpl implements YcSchoolProfileService {

	@Autowired
	private YcSchoolProfileMapper ycSchoolProfileMapper;

	/**
	 * 
	 * <p>Title: selectById</p>  
	
	 * <p>Description: 查看学校简介</p>  
	
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年12月18日
	 */
	@Override
	public YcSchoolProfile selectByAll(String id) {
		YcSchoolProfile byAll = ycSchoolProfileMapper.selectByAll(id);
		return byAll;
	}

	/**
	 * 
	 * <p>Title: insert</p>  
	
	 * <p>Description:添加学校概况  </p>  
	
	 * @param ycSchoolProfile
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年12月19日
	 */
	@Override
	public String insert(YcSchoolProfile ycSchoolProfile) {
		ycSchoolProfile.setYc_id(UUIDFactory.random());
		Integer insert = ycSchoolProfileMapper.insert(ycSchoolProfile);
		if (RegexUtil.isNotNull(insert)) {
			return YcSchoolConstants.SUCCESS;
		}
		return YcSchoolConstants.FAILURE;
	}

	
}
