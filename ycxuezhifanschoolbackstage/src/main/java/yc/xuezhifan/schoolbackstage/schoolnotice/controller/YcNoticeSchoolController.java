package yc.xuezhifan.schoolbackstage.schoolnotice.controller;

import java.util.*;

import javax.validation.Valid;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;
import yc.xuezhifan.schoolbackstage.annotation.CurrentSchool;
import yc.xuezhifan.schoolbackstage.annotation.SchoolLogin;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.NoticeConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.schoolnotice.bean.YcNoticeSchool;
import yc.xuezhifan.schoolbackstage.schoolnotice.mapper.YcNoticeSchoolMapper;
import yc.xuezhifan.schoolbackstage.schoolnotice.service.YcNoticeSchoolService;
import yc.xuezhifan.schoolbackstage.utils.Page;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;

/**  
* <p>Title: YcNoticeSchoolController.java </p> 

* <p>Description: 学校通知公告</p> 

* <p>Copyright: Copyright (c) 2018年10月2日</p>
 
* @email xiaoxiao@xuezhifan.com

* @author xiaoxiao 

* @date 2018年10月2日  

* @version 1.0  

*/
@Controller
@RequestMapping("/ycNoticeSchool")
public class YcNoticeSchoolController {

	public static final Logger logger = LoggerFactory.getLogger(YcNoticeSchoolController.class);
	
	@Autowired
	YcNoticeSchoolService ycNoticeSchoolService;
	@Autowired
	YcNoticeSchoolMapper mapper;
	@RequestMapping("/del")
	@ResponseBody
	public String del(String id){
		mapper.del(id);
		return "ok";
	}
	/**
	 * 
	 * <p>Title: insertSchool</p>  
	
	 * <p>Description: 添加学校通知</p>  
	
	 * @param ycSchool
	 * @param ycNoticeSchool
	 * @param result
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年10月15日
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/insertSchool",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	@SchoolLogin
	public JacksonData<YcNoticeSchool> insertSchool(@CurrentSchool YcSchool ycSchool,@Valid YcNoticeSchool ycNoticeSchool,BindingResult result){
		//验证参数是否有误
		if (result.hasErrors()) {
			List<ObjectError> error = result.getAllErrors();
			for (ObjectError objectError : error) {
				//参数错误信息写入日志文件
				logger.debug("错误码：" + objectError.getCode() + "~~message:" + objectError.getDefaultMessage() + "~~~"
						+ objectError.getObjectName());
			}
			return ResultUtil.error(201, NoticeConstants.NODATA);
		}
		if (RegexUtil.isNotNull(ycSchool)) {
			String rs = ycNoticeSchoolService.insert(ycNoticeSchool,ycSchool);
			if (RegexUtil.isNotNull(rs) && NoticeConstants.SUCCESS.equals(rs)) {
				return ResultUtil.success();
			}
			return ResultUtil.error(204, rs);
		}

		return ResultUtil.error(204, "权限不足");
		
	}

	/**
	 * 
	 * <p>Title: noticeSchoolById</p>  
	
	 * <p>Description: 根据学校id查询</p>
	
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年10月3日
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/noticeSchoolById",method = RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	@SchoolLogin
	public Page noticeSchoolById(@CurrentSchool YcSchool ycSchool,@RequestParam(defaultValue="1") Integer currentPage, @RequestParam(defaultValue="10") Integer pageSize){
//		 分页
		return ycNoticeSchoolService.noticeSchoolById(ycSchool.getId(), currentPage, pageSize);
	}
	
	/**
	 * 
	 * <p>Title: noticeSchoolByUserId</p>  
	
	 * <p>Description: 根据发布人id查询</p>  
	
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年10月3日
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/noticeSchoolByUserId",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	@SchoolLogin
	public JacksonData<YcNoticeSchool> noticeSchoolByUserId(@CurrentSchool YcSchool ycSchool,String id){
		if (RegexUtil.isNotNull(ycSchool)) {
		List<YcNoticeSchool> byId = ycNoticeSchoolService.noticeSchoolByUserId(id);
		if (RegexUtil.isNotNull(byId)) {
			return ResultUtil.success(byId);
		}
		return ResultUtil.error(203, NoticeConstants.NODATA);
	}
		return ResultUtil.error(202, NoticeConstants.NOlOGIN);
	}
	
}
