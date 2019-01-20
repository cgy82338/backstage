package yc.xuezhifan.schoolbackstage.schoolbean.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.schoolbean.bean.YcOrder;

@Mapper
public interface YcOrderMapper {
	
	/**
	 * 
	
	 * <p>Title: findBySchoolId</p>  
	
	 * <p>Description:根据学校id 查询学校订单表 </p>  
	
	 * @param id 学校id
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	 * @param endTime 
	 * @param startTime 
	
	 * @date 2018年11月5日
	 */
	List<YcOrder> findBySchoolId(String id, String startTime, String endTime);

	/**
	 * 生成订单
	 * @param ycOrder
	 * @return
	 */
	Integer insertYcOrder(YcOrder ycOrder);
}
