package yc.xuezhifan.schoolbackstage.schoolbean.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.afterturn.easypoi.exception.excel.ExcelExportException;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.YcSchoolBeanConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.schoolbean.bean.YcOrder;
import yc.xuezhifan.schoolbackstage.schoolbean.bean.YcSchoolBean;
import yc.xuezhifan.schoolbackstage.schoolbean.mapper.YcOrderMapper;
import yc.xuezhifan.schoolbackstage.schoolbean.service.YcOrderService;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;

@Service
public class YcOrderServiceImpl implements YcOrderService {
	@Autowired
	private YcOrderMapper ycOrderMapper;
	/**
	 * 
	
	 * <p>Title: findBySchoolId</p>  
	
	 * <p>Description:根据条件查询学校订单明细</p>  
	
	 * @param id
	 * @param curentPage
	 * @param pageSize
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月5日
	 */
	@Override
	public PageInfo<YcOrder> findBySchoolId(String id, int curentPage, int pageSize, String startTime, String endTime) throws Exception {
		if (RegexUtil.isNull(id)) {
			throw new ExcelExportException();
		}
		List<YcOrder> ycOrders = ycOrderMapper.findBySchoolId(id,startTime,endTime);
		PageHelper.startPage(curentPage, pageSize);
		if (RegexUtil.isNotNull(ycOrders)) {
			PageInfo<YcOrder> pageInfo = new PageInfo<>(ycOrders);
			return pageInfo;
		}
		return null;
	}

	/**
	 * 开通推广生成订单
	 * @param ycSchool
	 * @return
	 */
	@Override
	public JacksonData save(YcSchool ycSchool) {
		try {
			YcOrder ycOrder = new YcOrder();
			ycOrder.setYc_order_id(UUIDFactory.random());
			ycOrder.setYc_order_type(6);
			ycOrder.setYc_order_transaction_type(1);
			ycOrder.setYc_order_payment_method(1);
			ycOrder.setYc_order_user_type(3);
			ycOrder.setYc_payment_amount(new BigDecimal(1000));
			ycOrder.setYc_order_detail_id("");
			ycOrder.setYc_school_id(ycSchool.getId());
			ycOrder.setYc_create_time(new Date());
			ycOrder.setYc_complete_time(new Date());
			ycOrder.setYc_order_status(4);
			ycOrderMapper.insertYcOrder(ycOrder);
			return ResultUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultUtil.error(204, YcSchoolBeanConstants.FAILURE);
	}

}
