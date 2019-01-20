package yc.xuezhifan.schoolbackstage.schoolbean.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yc.xuezhifan.schoolbackstage.constants.YcSchoolBeanConstants;
import yc.xuezhifan.schoolbackstage.schoolbean.bean.YcSchoolBean;
import yc.xuezhifan.schoolbackstage.schoolbean.bean.YcSchoolBeanRecord;
import yc.xuezhifan.schoolbackstage.schoolbean.mapper.YcSchoolBeanMapper;
import yc.xuezhifan.schoolbackstage.schoolbean.service.YcSchoolBeanRecordService;
import yc.xuezhifan.schoolbackstage.schoolbean.service.YcSchoolBeanService;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;



/**
 * 

* <p>Title: YcScboolBeanServiceImpl.java </p> 

* <p>Description:学校智慧豆 </p> 

* <p>Copyright: Copyright (c) 2018年12月21日</p>
 
* @email xiaoke@xuezhifan.com

* @author xiaoke 

* @date 2018年12月21日  

* @version 1.0
 */
@Service
public class YcSchoolBeanServiceImpl implements YcSchoolBeanService {
	@Autowired
	private YcSchoolBeanMapper ycScboolBeanMapper;
	@Autowired
	private YcSchoolBeanService ycScboolBeanService;
	@Autowired
	private YcSchoolBeanRecordService YcSchoolBeanRecordService;

	@Override
	public YcSchoolBean findBeanBySchoolId(String id) {
	
		return ycScboolBeanMapper.findBeanBySchoolId(id);
	}
	/**
	 * 
	
	 * <p>Title: modifyBeans</p>  
	
	 * <p>Description: </p>  
	
	 * @param id
	 * @param yc_payment_amount
	 * @param type
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	 * @throws Exception 
	
	 * @date 2018年12月21日
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
	public String modifyBeans(String id, Double yc_payment_amount, String yc_order_id) throws Exception {
		int result=0;
		YcSchoolBean ycScboolBean=ycScboolBeanService.findBeanBySchoolId(id);
		if (RegexUtil.isNull(ycScboolBean)) {
			return YcSchoolBeanConstants.NODATA;
		}else if(RegexUtil.isNull(ycScboolBean.getYc_wisdom_beans())) {
			return YcSchoolBeanConstants.NO_BEAN;
		}else if (ycScboolBean.getYc_wisdom_beans().compareTo(yc_payment_amount)<0) {
			return YcSchoolBeanConstants.LESS_BEAN;
		}else {
		 ycScboolBean
			.setYc_wisdom_beans(ycScboolBean.getYc_wisdom_beans()-yc_payment_amount);
		}
		// 保存用户智慧豆交易记录
				YcSchoolBeanRecord wisdomBeanRecord = new YcSchoolBeanRecord();
				int transaction_type=6;
				char type='-';
				result=YcSchoolBeanRecordService.saveYcWisdomBeanRecord(transaction_type,yc_payment_amount,type,ycScboolBean.getYc_wisdom_beans(),yc_order_id,id);
			if (result>0) {
				ycScboolBeanMapper.modify(ycScboolBean);
			}else {
				throw new Exception();
			}	
			return YcSchoolBeanConstants.FAILURE;
	}
	@Override
	public Integer saveBeans(YcSchoolBean ycWisdomBeans) {
		if (RegexUtil.isNotNull(ycWisdomBeans)) {
			ycWisdomBeans.setYc_wisdom_beans_id(UUIDFactory.random());
			return ycScboolBeanMapper.save(ycWisdomBeans);
		}
		return null;
	}
	@Override
	public Integer modifyBeans(YcSchoolBean ycWisdomBeans) {
		if (RegexUtil.isNotNull(ycWisdomBeans)) {
			if (RegexUtil.isNotNull(ycWisdomBeans.getYc_wisdom_beans_id())) {
				return ycScboolBeanMapper.modify(ycWisdomBeans);
			}
		}
		return 0;
	}
	@Override
	public YcSchoolBean findBeanById(String yc_school_id) {
		return ycScboolBeanMapper.findBeanBySchoolId(yc_school_id);
	}
	

}
