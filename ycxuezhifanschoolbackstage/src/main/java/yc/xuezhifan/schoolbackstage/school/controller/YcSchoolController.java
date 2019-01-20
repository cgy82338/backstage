package yc.xuezhifan.schoolbackstage.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import yc.xuezhifan.schoolbackstage.annotation.CurrentSchool;
import yc.xuezhifan.schoolbackstage.annotation.SchoolLogin;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.YcSchoolConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.school.service.YcSchoolService;
import yc.xuezhifan.schoolbackstage.school.vo.SchoolData;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;
import yc.xuezhifan.schoolbackstage.utils.TokenUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/school")
public class YcSchoolController {
//	private static final Logger logger = LoggerFactory.getLogger(YcSchoolController.class);

	@Autowired
	YcSchoolService ycSchoolService;

	/**
	 * 后台登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SuppressWarnings("unchecked")
	public JacksonData<YcSchool> login(String username, String password, HttpServletRequest request) {
		if (RegexUtil.isNull(username)) {
			return ResultUtil.error(204, "用户名不能为空");
		}
		if (RegexUtil.isNull(password)) {
			return ResultUtil.error(204, "密码不能为空");
		}
		YcSchool ycSchool = ycSchoolService.login(username, password);
		if (RegexUtil.isNotNull(ycSchool)) {
			String token = TokenUtils.createJwtToken(username);
			//			把token存入session
			request.getSession().setAttribute("accessToken",token);
			return ResultUtil.success(token);
		}
		return ResultUtil.error(204, "账号或密码错误");
	}

	/**
	 * 修改学校信息
	 * 
	 * @param ycSchool
	 * @param school
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateSchool", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcSchool> updateSchool(@CurrentSchool YcSchool ycSchool, YcSchool school) {
		// 判断是否登录
		if (RegexUtil.isNotNull(ycSchool)) {
			// 判断参数是否正确
			if (RegexUtil.isNotNull(school) && RegexUtil.isNotNull(school.getId())) {
				// 得到修改结果并处理
				String rs = ycSchoolService.updateSchool(ycSchool);
				if (RegexUtil.isNotNull(rs) && YcSchoolConstants.SUCCESS.equals(rs)) {
					return ResultUtil.success();
				}
				return ResultUtil.error(204, rs);
			}
			return ResultUtil.error(201, YcSchoolConstants.PARAMETER_ERROR);
		}
		return ResultUtil.error(202, YcSchoolConstants.NOLOGIN);
	}
	/**
	 * 修改管理后台密码
	 *
	 * @param ycSchool
	 * @param formerpass
	 * @param newqpass
	 * @return
	 */
	@RequestMapping(value = "/updatepassword",method = RequestMethod.POST)
	@ResponseBody
	@SchoolLogin
	public JacksonData updatepassword(@CurrentSchool YcSchool ycSchool,String formerpass, String newqpass){
		// 判断是否登录
		if (RegexUtil.isNull(ycSchool)) {
			return ResultUtil.error(204,YcSchoolConstants.NOLOGIN);
		}
		return ycSchoolService.updatepassword(formerpass, newqpass, ycSchool);
	}

	/**
	 * 账号资料信息修改
	 */
	@RequestMapping(value = "/updateData",method = RequestMethod.POST)
	@ResponseBody
	@SchoolLogin
	public JacksonData updateData(@CurrentSchool YcSchool ycSchool, SchoolData schoolData){
		return ycSchoolService.updateData(ycSchool,schoolData);
	}

	/**
	 * 账号所有人资料信息修改
	 */
	@RequestMapping(value = "/updateDataAll",method = RequestMethod.POST)
	@ResponseBody
	@SchoolLogin
	public JacksonData updateDataAll(@CurrentSchool YcSchool ycSchool, SchoolData schoolData){
		return ycSchoolService.updateDataAll(ycSchool,schoolData);
	}

}
