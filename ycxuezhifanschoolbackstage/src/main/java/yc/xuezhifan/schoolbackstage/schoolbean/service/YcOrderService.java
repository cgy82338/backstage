package yc.xuezhifan.schoolbackstage.schoolbean.service;


import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.schoolbean.bean.YcOrder;

public interface YcOrderService {

	PageInfo<YcOrder> findBySchoolId(String id, int curentPage, int pageSize, String startTime, String endTime) throws Exception;

	/**
	 * 开通推广生成订单
	 * @param ycSchool
	 * @return
	 */
	JacksonData save(YcSchool ycSchool);
}
