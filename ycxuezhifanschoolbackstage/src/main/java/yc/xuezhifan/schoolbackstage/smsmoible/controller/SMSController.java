package yc.xuezhifan.schoolbackstage.smsmoible.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.SMSConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.school.mapper.YcSchoolMapper;
import yc.xuezhifan.schoolbackstage.smsmoible.bean.YcVerificationCode;
import yc.xuezhifan.schoolbackstage.smsmoible.mapper.YcVerificationMapper;
import yc.xuezhifan.schoolbackstage.smsmoible.service.ISMSService;
import yc.xuezhifan.schoolbackstage.smsmoible.util.CodeUtil;
import yc.xuezhifan.schoolbackstage.user.bean.YcUser;
import yc.xuezhifan.schoolbackstage.user.mapper.YcUserMapper;
import yc.xuezhifan.schoolbackstage.utils.Constants;
import yc.xuezhifan.schoolbackstage.utils.MD5Util;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;


/**
 * @author zhaochuanjing
 * @data 2018年8月18日 上午11:31:56
 */
@Controller
@RequestMapping("/sms")
public class SMSController {

    @Autowired
    private ISMSService ismsService;

    @Autowired
    private YcUserMapper userMapper;

    @Autowired
    private YcSchoolMapper schoolMapper;

    /*
    发送修改密码验证码
     */
    @ResponseBody
    @RequestMapping(value = "/upPassSend", method = RequestMethod.POST)
    public JacksonData<Object> registerSend(String phone) {

        YcSchool school = schoolMapper.selectByUserName(phone);
        if (school != null) {//用户存在
            if (ismsService.modifyPasswordsend(phone, CodeUtil.createData(4))) {
                return ResultUtil.success();
            } else {
                return ResultUtil.success(SMSConstants.SENDFALSE);
            }
        } else {//用户不存在
            return ResultUtil.success(SMSConstants.REGFALSE);
        }
    }

    /*
    验证修改密码验证码
     */
    @RequestMapping(value = "/checkUpPass", method = RequestMethod.POST)
    @ResponseBody
    public JacksonData checkSendCode(YcVerificationCode verificationCode) {
        if (ismsService.checkPasswordCode(verificationCode.getYc_mobile(), verificationCode.getYc_code())) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error(204, SMSConstants.CHECKCODE);
        }
    }

    /*
    修改密码
     */
    @RequestMapping(value = "/upPassword", method = RequestMethod.POST)
    @ResponseBody
    public JacksonData upPassword(String password, String phone) {
        try {
            YcSchool school = schoolMapper.selectByUserName(phone);
            if (school != null) {
//                修改学校登录密码
                school.setYc_school_password(password);
                school.setYc_school_pw_encryption(new MD5Util().md5(password + Constants.SALT));
                schoolMapper.updateSchool(school);
//                修改校长用户密码
                YcUser user = userMapper.selectByPhone(phone);
                user.setYc_password(password);
                user.setYc_password_encryption(new MD5Util().md5(password + Constants.SALT));
                userMapper.updatePW(user);
                return ResultUtil.success();
            } else {
                return ResultUtil.error(204, SMSConstants.FAILURE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error(204, SMSConstants.FAILURE);
    }

    @ResponseBody
    @RequestMapping("/modifyPasswordSend")
    public JacksonData<Object> modifyPasswordSend(String phone) {
        int digit = 4;
        String code = CodeUtil.createData(digit);
        //验证手机号是否为空
        if (RegexUtil.isNull(phone)) {
            return ResultUtil.error(204, SMSConstants.MOBILENOEXISTED);
        }
        //验证用户是否已存在
		/*YcUser ycUser= ycUserService.findByUserName(phone);
		if (RegexUtil.isNull(ycUser)) {
			return ResultUtil.error(204,SMSConstants.NOTEXISTED);
		}
		if(ismsService.modifyPasswordsend(phone, code)) {
			return ResultUtil.success();
		}*/
        return ResultUtil.error(204, SMSConstants.FAILURE);
    }

    /**
     * <p>Title: bindingAlipay</p>
     *
     * <p>Description:绑定支付宝验证码 </p>
     *
     * @param phone
     * @return
     * @email xiaoke@xuezhifan.com
     * @author xiaoke
     * @date 2018年11月28日
     */
	/*@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping("/bindingAlipay")
	@LoginRequired*/
	/*public JacksonData<Object> bindingAlipay(@CurrentUser YcUser ycuser, String phone) {
		if(RegexUtil.isNull(ycuser)) {
			return ResultUtil.error(202, SMSConstants.NOlOGIN);
		}
		int digit=4;
		String code = CodeUtil.createData(digit);
		//验证手机号是否为空
		if (RegexUtil.isNull(phone)) {
			return ResultUtil.error(204,SMSConstants.MOBILENOEXISTED);
		}
		//验证用户是否已存在
		YcUser ycUser= ycUserService.findByUserName(phone);
		if (RegexUtil.isNull(ycUser)) {
			return ResultUtil.error(204,SMSConstants.NOTEXISTED);
		}
		if(ismsService.bindingAlipay(phone, code)) {
			return ResultUtil.success(code);
		}
		return ResultUtil.error(204, SMSConstants.FAILURE);
	}*/

    @Autowired
    YcVerificationMapper verificationMapper;

    @RequestMapping("/del")
    @ResponseBody
    public String del(String id) {
        verificationMapper.delete(id);
        return "ok";
    }
}
