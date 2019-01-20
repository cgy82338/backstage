package yc.xuezhifan.schoolbackstage.fileshared.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.FileSharedConstants;
import yc.xuezhifan.schoolbackstage.fileshared.bean.YcFileShared;
import yc.xuezhifan.schoolbackstage.fileshared.mapper.YcFileSharedMapper;
import yc.xuezhifan.schoolbackstage.fileshared.service.YcFileSharedService;
import yc.xuezhifan.schoolbackstage.oss.service.OssCacheService;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.school.mapper.YcSchoolMapper;
import yc.xuezhifan.schoolbackstage.schoolnotice.bean.YcNoticeSchool;
import yc.xuezhifan.schoolbackstage.user.bean.YcUser;
import yc.xuezhifan.schoolbackstage.user.mapper.YcUserMapper;
import yc.xuezhifan.schoolbackstage.utils.Page;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;

import java.util.Date;
import java.util.List;

/**  
* <p>Title: YcFileSharedServiceImpl.java </p> 

* <p>Description: 文件共享表</p> 

* <p>Copyright: Copyright (c) 2018年10月4日</p>
 
* @email xiaoxiao@xuezhifan.com

* @author xiaoxiao 

* @date 2018年10月4日  

* @version 1.0  

*/
@Service
public class YcFileSharedServiceImpl implements YcFileSharedService {

	@Autowired
	private YcFileSharedMapper ycFileSharedMapper;
	
	//@Autowired
	//private YcIntermediateTableService ycIntermediateTableService;
	
	@Autowired
	private YcUserMapper ycUserMapper;
	
	@Autowired
	private OssCacheService ossCacheService;

	@Autowired
	private YcSchoolMapper ycSchoolMapper;

	/**
	 * 添加共享文件
	 */
	@Override
	public String insert(YcFileShared ycFileShared) {
		
		ycFileShared.setYc_file_shared_id(UUIDFactory.random());
		ycFileShared.setYc_file_shared_time(new Date());
		ycFileShared.setYc_publisher_type(2);//2学校
		//清除上传缓存表
		if (RegexUtil.isNotNull(ycFileShared.getYc_file_shared_url())) {
			ossCacheService.deleteOssCache(ycFileShared.getYc_file_shared_url());
		}
		Integer fileShared = ycFileSharedMapper.insert(ycFileShared);
		if (RegexUtil.isNotNull(fileShared)) {
			return FileSharedConstants.SUCCESS;
		}
		return FileSharedConstants.FAILURE;
	}

	/**
	 * 获取共享文件
	 */
	@Override
	public Page findAllBySchool(String id, Integer currentPage,Integer pageSize) {
		//		计算总记录数
		int size = ycFileSharedMapper.findAllBySchool(id).size();
		//		分页
		PageHelper.startPage(currentPage, pageSize);
		List<YcFileShared> ycFileShareds = ycFileSharedMapper.findAllBySchool(id);
		for (int i = 0; i < ycFileShareds.size(); i++) {
			if (ycFileShareds.get(i).getYc_publisher_type() == 1){
				YcUser user = ycUserMapper.selectById(ycFileShareds.get(i).getYc_user_id());
				if (StringUtils.isNotBlank(user.getYc_username())){
					ycFileShareds.get(i).setYc_user_id(user.getYc_username());
				}else {
					ycFileShareds.get(i).setYc_user_id("");
				}
			}else{
				YcSchool school = ycSchoolMapper.selectById(ycFileShareds.get(i).getYc_user_id());
				if (StringUtils.isNotBlank(school.getYc_school_principal())){
					ycFileShareds.get(i).setYc_user_id(school.getYc_school_principal());
				}else {
					ycFileShareds.get(i).setYc_user_id("");
				}
			}
		}
		PageInfo<YcFileShared> pageInfo = new PageInfo<>(ycFileShareds);
		if (pageInfo != null){
			return new Page(0, "", size, pageInfo.getList());
		}else {
			return new Page(0, "", size, null);
		}
	}

	@Override
	public JacksonData delFile(String fileId) {
		try {
			ycFileSharedMapper.delFile(fileId);
			return ResultUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error(204,FileSharedConstants.FAILURE);
		}
	}
}
