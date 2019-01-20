package yc.xuezhifan.schoolbackstage.ycClass.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yc.xuezhifan.schoolbackstage.constants.YcParentClassConstants;
import yc.xuezhifan.schoolbackstage.user.bean.YcUser;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;
import yc.xuezhifan.schoolbackstage.ycClass.bean.YcParentClass;
import yc.xuezhifan.schoolbackstage.ycClass.mapper.YcParentClassMapper;
import yc.xuezhifan.schoolbackstage.ycClass.service.YcParentClassService;


@Service
public class YcParentClassServiceImpl implements YcParentClassService {
	
	@Autowired
	private YcParentClassMapper ycParentClassMapper;
/**
 * 

 * <p>Title: findByParent</p>  

 * <p>Description:	根据家长关系信息查询家长是否已经和班级存在关系 </p>  

 * @param ycParentClass
 * @return 

 * @email xiaoke@xuezhifan.com

 * @author xiaoke

 * @date 2018年11月19日
 */
	@Override
	public YcParentClass findByParent(YcParentClass ycParentClass) {
		return ycParentClassMapper.findByParent(ycParentClass);
	}
	/**
	 * 
	
	 * <p>Title: findByClassId</p>  
	
	 * <p>Description:根据班级id 查询管理员 </p>  
	
	 * @param yc_class_id
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月19日
	 */
	@Override
	public List<YcParentClass> findByClassId(String yc_class_id) {
		// TODO Auto-generated method stub
		return ycParentClassMapper.findByClassId(yc_class_id);
	}
	/**
	 * 
	
	 * <p>Title: modify</p>  
	
	 * <p>Description:修改家长与班级的关系 </p>  
	
	 * @param parentClass 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月19日
	 */
	@Override
	public void modify(YcParentClass parentClass) {
		ycParentClassMapper.modify(parentClass);
	}

	
	@Override
	public YcParentClass selectById(String id) {
		// TODO Auto-generated method stub
		return ycParentClassMapper.selectById(id);
	}
	/**
	 * 
	
	 * <p>Title: findByClass</p>  
	
	 * <p>Description: 根据用户id 查询班级列表</p>  
	
	 * @param ycUser
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月20日
	 */
	@Override
	public List<YcParentClass> findByClass(YcUser ycUser) {
		// TODO Auto-generated method stub
		return ycParentClassMapper.findByClass(ycUser);
	}
	/**
	 * 
	
	 * <p>Title: delete</p>  
	
	 * <p>Description:家长退出班级群 </p>  
	
	 * @param ycParentClass  家长班级信息
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月20日
	 */
	@Override
	public void delete(String yc_parent_id,String yc_class_id) {
		ycParentClassMapper.deleteParentClass(yc_parent_id, yc_class_id);
		
	}
	
	@Override
	public List<YcParentClass> findGroupByClassId(String yc_class_id) {
		// TODO Auto-generated method stub
		return ycParentClassMapper.findGroupByClassId(yc_class_id);
	}
	/**
	 * 
	
	 * <p>Title: findParentClassBatch</p>  
	
	 * <p>Description:根据家长Id及班级Id 查询班级成员信息 </p>  
	
	 * @param yc_class_id 班级id
	 * @param parentId 家长Id 数组
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月22日
	 */
	@Override
	public List<YcParentClass> findParentClassBatch(String yc_class_id, String[] parentId) {
		// TODO Auto-generated method stub
		return ycParentClassMapper.findParentClassBatch(yc_class_id, parentId);
	}
	/**
	 * 
	
	 * <p>Title: findPatentClassByClassId</p>  
	
	 * <p>Description:根据班级id 查询班级成员信息 </p>  
	
	 * @param yc_class_id 班级id
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月27日
	 */
	@Override
	public List<YcParentClass> findPatentClassByClassId(String yc_class_id) {
		// TODO Auto-generated method stub
		return ycParentClassMapper.findPatentClassByClassId(yc_class_id);
	}
	/**
	 * 
	
	 * <p>Title: modify</p>  
	
	 * <p>Description:修改班级成员信息 </p>  
	
	 * @param ycUser
	 * @param ycParentClass
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月27日
	 */
	@Override
	public String modify(YcUser ycUser, YcParentClass ycParentClass) {
		if (RegexUtil.isNull(ycParentClass.getId())) {
			return YcParentClassConstants.PARAMETER_ERROR;
		}
		//
		//YcParentClass parentClass=ycParentClassMapper.selectById(ycParentClass);
		//判断是否为该群管理员
		YcParentClass parentClass=ycParentClassMapper.selectParentClass(ycUser.getId(), ycParentClass.getYc_class_id());
		if (RegexUtil.isNotNull(parentClass)) {
			if (RegexUtil.isNotNull(ycParentClass.getYc_permission_status())) {
				//判断是否为管理员
				if (parentClass.getYc_permission_status().equals(1) ) {
					ycParentClassMapper.modify(parentClass);
					return YcParentClassConstants.SUCCESS;
				}
				return YcParentClassConstants.NOISLORD;
			}else {
				//判断是否为管理员或者班主任
				//if (parentClass.getYc_permission_status().equals(2) || parentClass.getYc_permission_status().equals(1) ) {
					ycParentClassMapper.modify(parentClass);	
					return YcParentClassConstants.SUCCESS;
				/*}
				return YcParentClassConstants.NOISADMIN;*/
			}
			
		}
		 return YcParentClassConstants.FAILURE;
	
	}
	/**
	 * 
	
	 * <p>Title: save</p>  
	
	 * <p>Description: 创建班级与教师关系(群组成员关系)</p>  
	
	 * @param yc_parent_id 教师id
	 * @param yc_class_id 班级id
	 * @param yc_status 状态( 1:通过 2:拒绝 3:申请 4 退出)
	 * @param yc_permission_status 群组权限 1:班主任 2:教师 3: 家长 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年12月8日
	 */
	@Override
	public void save(String yc_parent_id, String yc_class_id, Integer yc_status, Integer yc_permission_status) {
		YcParentClass ycParentClass=new YcParentClass();
		ycParentClass.setId(UUIDFactory.random());
		ycParentClass.setYc_class_id(yc_class_id);
		ycParentClass.setYc_create_time(new Date());
		ycParentClass.setYc_parent_id(yc_parent_id);
		ycParentClass.setYc_permission_status(yc_permission_status);
		ycParentClass.setYc_status(yc_status);
		ycParentClass.setYc_message_avoidance("1");
		ycParentClassMapper.addParentClass(ycParentClass);
		
	}
	/**
	*
	 * <p>Title: deleteByClassId</p>  
	
	 * <p>Description:根据班级解散群成员 </p>  
	
	 * @param ClassId
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年12月8日
	 */
	@Override
	public Boolean deleteByClassId(String ClassId) {
		List<YcParentClass> parentClasses=ycParentClassMapper.findByClassId(ClassId);
		if (RegexUtil.isNotNull(parentClasses)) {
			

			for (int i = 0; i < parentClasses.size(); i++) {
				ycParentClassMapper.deleteParentClass(parentClasses.get(i).getYc_parent_id(), parentClasses.get(i).getYc_class_id());
			}
			return true;
		}
		return false;
	}
//	删除教师和教师换班级时修改用户表
	@Override
	public String  modifyTeacherStatus(String yc_tearcher_id, String yc_class_id, Integer yc_permission_status) {
		YcParentClass ycParentClass=ycParentClassMapper.selectParentClass(yc_tearcher_id, yc_class_id);
		if (RegexUtil.isNotNull(ycParentClass)) {
			if (ycParentClass.getYc_permission_status().equals(1)) {
			return  YcParentClassConstants.ISADMIN;
			}
			ycParentClass.setYc_permission_status(yc_permission_status);
			int result=ycParentClassMapper.modify(ycParentClass);
			if (result>0) {
				return YcParentClassConstants.SUCCESS;
			}
			return YcParentClassConstants.FAILURE;
		}
		return YcParentClassConstants.NOTEXISTED;
	}
	/**
	 * 
	
	 * <p>Title: modifyTearche</p>  
	
	 * <p>Description:更换班主任 </p>  
	
	 * @param yc_tearcher_id 原班主任id
	 * @param yc_targer_tearcher_id 现班主任id
	 * @param yc_class_id 班级id
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年12月20日
	 */
	@Override
	public String modifyTearche(String yc_tearcher_id, String yc_targer_tearcher_id, String yc_class_id) {
		YcParentClass ycParentClass=ycParentClassMapper.selectParentClass(yc_tearcher_id, yc_class_id);
		if (RegexUtil.isNotNull(ycParentClass)) {
			if (ycParentClass.getYc_permission_status().equals(1)) {
				ycParentClass.setYc_parent_id(yc_targer_tearcher_id);
				int result=ycParentClassMapper.modify(ycParentClass);
				if (result>0) {
					return YcParentClassConstants.SUCCESS;
				}
				return YcParentClassConstants.FAILURE;
			}
			return  YcParentClassConstants.ISADMIN;
			
		}
		return YcParentClassConstants.NOTEXISTED;
	}

}
