package yc.xuezhifan.schoolbackstage.schoolbean.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yc.xuezhifan.schoolbackstage.schoolbean.bean.YcSchoolBean;
import yc.xuezhifan.schoolbackstage.schoolbean.bean.YcSchoolBeanRecord;
import yc.xuezhifan.schoolbackstage.schoolbean.mapper.YcSchoolBeanRecordMapper;
import yc.xuezhifan.schoolbackstage.schoolbean.service.YcSchoolBeanRecordService;
import yc.xuezhifan.schoolbackstage.schoolbean.service.YcSchoolBeanService;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;



@Service
public class YcSchoolBeanRecordServiceImpl implements YcSchoolBeanRecordService {
	@Autowired
	private YcSchoolBeanRecordMapper ycSchoolBeanRecordMapper;
	
	@Autowired
	private YcSchoolBeanService ycSchoolBeanService;
	@Override
	public int saveYcWisdomBeanRecord(int transaction_type, Double yc_payment_amount, char type,
			Double yc_wisdom_beans, String yc_order_id, String id) {
		YcSchoolBeanRecord ycSchoolBeanRecord=new YcSchoolBeanRecord();
		ycSchoolBeanRecord.setYc_record_id(UUIDFactory.random());//智慧豆记录表唯一标识 32位
		ycSchoolBeanRecord.setChange_type(type);//改变类型 +:增加 -：减少
		ycSchoolBeanRecord.setChange_value(yc_payment_amount);//改变值
		ycSchoolBeanRecord.setTransaction_type(transaction_type);//1：充值 2：提现 3：视频消费 4:提成 5：广告消费 6：推广功能  7：活动消费 8:在线缴费9：打赏
		ycSchoolBeanRecord.setYc_school_id(id);//学校id
		ycSchoolBeanRecord.setYc_order_id(yc_order_id);//改变的订单
		ycSchoolBeanRecord.setYc_lave_money(yc_wisdom_beans);//剩余智慧豆
		ycSchoolBeanRecord.setYc_create_time(new Date());//时间默认为当前时间

		return ycSchoolBeanRecordMapper.save(ycSchoolBeanRecord);
	}

	@Override
	public int saveYcWisdomBeanRecord(String yc_change_mode, Integer yc_change_bean, String yc_school_id,
			String yc_order_id) {
		YcSchoolBeanRecord wisdomBeanRecord = new YcSchoolBeanRecord();
		YcSchoolBean wisdomBeans = ycSchoolBeanService.findBeanBySchoolId(yc_school_id);
		wisdomBeanRecord.setYc_record_id(UUIDFactory.random());
		wisdomBeanRecord.setYc_create_time(new Date());
		if (yc_change_mode.equals("1")) {// 变化的方式（1：充值 2：提现）
			wisdomBeanRecord.setChange_type('+');
			wisdomBeanRecord.setTransaction_type(10);
			
			if (RegexUtil.isNull(wisdomBeans)) {
				wisdomBeanRecord.setYc_lave_money(new Double(yc_change_bean));	
				//用户首次充值时
				wisdomBeans=new YcSchoolBean();
				wisdomBeans.setYc_wisdom_beans(new Double(yc_change_bean));
				wisdomBeans.setYc_school_id(yc_school_id);
				ycSchoolBeanService.saveBeans(wisdomBeans);
			}else {
				wisdomBeanRecord.setYc_lave_money(wisdomBeans.getYc_wisdom_beans()+yc_change_bean);	
				wisdomBeans.setYc_wisdom_beans(wisdomBeans.getYc_wisdom_beans()+yc_change_bean);
				ycSchoolBeanService.modifyBeans(wisdomBeans);
			}
			
			

		} else {
			wisdomBeanRecord.setChange_type('-');
			wisdomBeanRecord.setTransaction_type(11);
			//用户首次提现
			if (RegexUtil.isNull(wisdomBeans)) {
				throw new RuntimeException();
			}else {
				wisdomBeanRecord
				.setYc_lave_money(wisdomBeans.getYc_wisdom_beans()+yc_change_bean);
				wisdomBeans.setYc_wisdom_beans(wisdomBeans.getYc_wisdom_beans()+yc_change_bean);
				ycSchoolBeanService.modifyBeans(wisdomBeans);
			}
			
			
		}
		wisdomBeanRecord.setChange_value(new Double(yc_change_bean));
		wisdomBeanRecord.setYc_school_id(yc_school_id);
		wisdomBeanRecord.setYc_order_id(yc_order_id);
		try {
			ycSchoolBeanRecordMapper.save(wisdomBeanRecord);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int selectRcount(String id, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int selectCcount(String id, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int selectIncome(String id, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int selectExpenditure(String id, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List selectSumByType(String id, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List selectIncomeByDate(String id, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List selectExpenditureByDate(String id, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}
	




	



	}
