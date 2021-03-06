package yc.xuezhifan.schoolbackstage.schoolfeature.service;

import yc.xuezhifan.schoolbackstage.schoolfeature.bean.YcCertification;

/**  

* <p>Title: IYcCertificationService.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月2日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年10月2日  

* @version 1.0  

*/
public interface IYcCertificationService {

	/**
	 *  添加功能
	 * @param ycCertification
	 */
	String insert(YcCertification ycCertification, String yc_school_id, String yc_feature_id);
	
	/**
	 * 根据id查询功能状态
	 * @param yc_certification_id 主键id
	 * @return 1为开通,2为未开通
	 */
	YcCertification selectById(String yc_certification_id);
	
	/**
	 * 修改认证信息
	 * @param ycCertification
	 * @return
	 */
	String update(YcCertification ycCertification);
}
