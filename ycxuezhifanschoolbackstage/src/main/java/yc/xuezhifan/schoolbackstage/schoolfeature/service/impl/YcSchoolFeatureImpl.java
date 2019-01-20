package yc.xuezhifan.schoolbackstage.schoolfeature.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.schoolfeature.bean.YcSchoolFeature;
import yc.xuezhifan.schoolbackstage.schoolfeature.mapper.YcSchoolFeatureMapper;
import yc.xuezhifan.schoolbackstage.schoolfeature.service.IYcSchoolFeatureService;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;


/**  

* <p>Title: YcSchoolFeatureImpl.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月2日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年10月2日  

* @version 1.0  

*/
@Service
public class YcSchoolFeatureImpl implements IYcSchoolFeatureService{

	@Autowired
	private YcSchoolFeatureMapper ycSchoolFeatureMapper;

	@Override
	public PageInfo<YcSchoolFeature> findAll(Integer currentPage, Integer pageSize) {
		List<YcSchoolFeature> ycSchoolFeatures = ycSchoolFeatureMapper.findAll();
		if (RegexUtil.isNotNull(ycSchoolFeatures)) {
			PageHelper.startPage(currentPage, pageSize);
			return new PageInfo<>(ycSchoolFeatures);
		}
		return null;
	}

}
