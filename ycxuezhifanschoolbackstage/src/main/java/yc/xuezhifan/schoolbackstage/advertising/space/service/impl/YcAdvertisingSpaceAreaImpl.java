package yc.xuezhifan.schoolbackstage.advertising.space.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.advertising.space.bean.YcAdvertisingSpaceArea;
import yc.xuezhifan.schoolbackstage.advertising.space.mapper.YcAdvertisingSpaceAreaMapper;
import yc.xuezhifan.schoolbackstage.advertising.space.service.IYcAdvertisingSpaceAreaService;
import yc.xuezhifan.schoolbackstage.constants.YcAdvertisingSpaceConstants;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;

/**  

* <p>Title: YcAdvertisingSpaceAreaImpl.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月13日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年10月13日  

* @version 1.0  

*/
@Service
public class YcAdvertisingSpaceAreaImpl implements IYcAdvertisingSpaceAreaService{

	@Autowired
	private YcAdvertisingSpaceAreaMapper ycAdvertisingSpaceAreaMapper;

	@Override
	public PageInfo<YcAdvertisingSpaceArea> selectByArea(String yc_school_district, Integer currentPage, Integer pageSize, Integer type) {
		List<YcAdvertisingSpaceArea> ycAdvertisingSpaceAreas = ycAdvertisingSpaceAreaMapper.selectByArea(yc_school_district, type);
		if (RegexUtil.isNotNull(ycAdvertisingSpaceAreas)) {
			PageHelper.startPage(currentPage, pageSize);
			return new PageInfo<>(ycAdvertisingSpaceAreas);
		}
		return null;
	}
	
	@Override
	public YcAdvertisingSpaceArea selectById(String id) {
		return ycAdvertisingSpaceAreaMapper.selectById(id);
	}

	@Override
	public boolean selectStatus(String yc_advertising_space) {
		YcAdvertisingSpaceArea ycAdvertisingSpaceArea = selectById(yc_advertising_space);
		if (RegexUtil.isNull(ycAdvertisingSpaceArea)) {
			return true;
		}
		return false;
	}

	@Override
	public String updateStatus(String yc_advertising_space, int i) {
		YcAdvertisingSpaceArea ycAdvertisingSpaceArea = new YcAdvertisingSpaceArea();
		ycAdvertisingSpaceArea.setId(yc_advertising_space);
		ycAdvertisingSpaceArea.setYc_advertising_status(i);
		Integer rs = ycAdvertisingSpaceAreaMapper.update(ycAdvertisingSpaceArea);
		if (RegexUtil.isNotNull(rs)) {
			return YcAdvertisingSpaceConstants.SUCCESS;
		}
		return YcAdvertisingSpaceConstants.FAILURE;
	}
}
