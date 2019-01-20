package yc.xuezhifan.schoolbackstage.schoolbean.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

public interface YcSchoolBeanRecordService {

	int saveYcWisdomBeanRecord(int transaction_type, Double yc_payment_amount, char type,
                               Double yc_wisdom_beans, String id, String yc_order_id);

	int saveYcWisdomBeanRecord(String yc_change_mode, Integer yc_change_bean, String yc_school_id, String yc_order_id);

	int selectRcount(String id, Date startDate, Date endDate);

	int selectCcount(String id, Date startDate, Date endDate);

	int selectIncome(String id, Date startDate, Date endDate);

	int selectExpenditure(String id, Date startDate, Date endDate);

	List selectSumByType(String id, Date startDate, Date endDate);

	List selectIncomeByDate(String id, Date startDate, Date endDate);

	List selectExpenditureByDate(String id, Date startDate, Date endDate);

	

}
