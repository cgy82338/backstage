package yc.xuezhifan.schoolbackstage.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.TokenConstants;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 用户退出
     * @param request
     * @return
     */
    @RequestMapping("/quit")
    @ResponseBody
    public JacksonData quit(HttpServletRequest request) {
        request.getSession().removeAttribute(TokenConstants.ACCESS_TOKEN);
        return ResultUtil.success();
    }
}
