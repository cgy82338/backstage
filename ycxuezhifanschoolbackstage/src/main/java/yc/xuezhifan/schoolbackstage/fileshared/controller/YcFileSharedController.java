package yc.xuezhifan.schoolbackstage.fileshared.controller;

import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import yc.xuezhifan.schoolbackstage.annotation.CurrentSchool;
import yc.xuezhifan.schoolbackstage.annotation.SchoolLogin;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.FileSharedConstants;
import yc.xuezhifan.schoolbackstage.fileshared.bean.YcFileShared;
import yc.xuezhifan.schoolbackstage.fileshared.mapper.YcFileSharedMapper;
import yc.xuezhifan.schoolbackstage.fileshared.service.YcFileSharedService;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.utils.Page;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;
import yc.xuezhifan.schoolbackstage.ycClass.service.YcClassService;

import javax.servlet.http.HttpServletResponse;
import java.io.*;


/**
 * <p>Title: YcFileSharedController.java </p>
 *
 * <p>Description: 共享文件controller</p>
 *
 * <p>Copyright: Copyright (c) 2018年10月19日</p>
 *
 * @author zhuangzhuang
 * @version 1.0
 * @email zhuangzhuang@xuezhifan.com
 * @date 2018年10月19日
 */
@Controller
@RequestMapping("/fileShared")
public class YcFileSharedController {
    public static final Logger logger = LoggerFactory.getLogger(YcFileSharedController.class);

    @Autowired
    private YcFileSharedService ycFileSharedService;

    @Autowired
    private YcClassService ycClassService;

    /**
     * <p>Title: insetFileShared</p>
     *
     * <p>Description: 创建文件共享</p>
     *
     * @param ycUser
     * @param ycFileShared
     * @param result
     * @return
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年10月19日
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/insetFileShared", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    @SchoolLogin
    public JacksonData<YcFileShared> insetFileShared(@CurrentSchool YcSchool ycSchool, String yc_file_shared_name,
                                                     String yc_file_shared_type, String yc_file_shared_size, String yc_file_shared_url) {
        System.out.println("接收到消息");
        //判断用户是否为登录状态
        if (null != ycSchool) {
            YcFileShared ycFileShared = new YcFileShared();

            ycFileShared.setYc_file_shared_name(yc_file_shared_name);
            ycFileShared.setYc_file_shared_size(yc_file_shared_size);
            String[] filetypes = yc_file_shared_type.split("\\.");
            String filetype = filetypes[filetypes.length - 1];
            ycFileShared.setYc_file_shared_type(filetype);
            ycFileShared.setYc_file_shared_url(yc_file_shared_url);

            ycFileShared.setYc_file_shared_school(ycSchool.getId());
            //设置创建人
            ycFileShared.setYc_user_id(ycSchool.getId());
            //保存信息
            String rs = ycFileSharedService.insert(ycFileShared);
            //创建结果 处理
            if (RegexUtil.isNotNull(rs) && rs.equals(FileSharedConstants.SUCCESS)) {
                return ResultUtil.success();
            } else {
                return ResultUtil.error(204, rs);
            }
        }
        return ResultUtil.error(203, FileSharedConstants.NOlOGIN);
    }


    /**
     * <p>Title: findAll</p>
     *
     * <p>Description: 学校获取共享文件</p>
     *
     * @return
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年10月19日
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findAllBySchool", method = RequestMethod.POST)
    @ResponseBody
    @SchoolLogin
    public Page findAllBySchool(@CurrentSchool YcSchool ycSchool, @RequestParam(defaultValue = "1") Integer currentPage,
                                @RequestParam(defaultValue = "10") Integer pageSize) {
        System.out.println(currentPage);
        System.out.println(pageSize);
        return ycFileSharedService.findAllBySchool(ycSchool.getId(), currentPage, pageSize);

    }

    @RequestMapping("/delFile")
    @ResponseBody
    public JacksonData delFile(String fileId) {
        return ycFileSharedService.delFile(fileId);
    }


//	@RequestMapping(value="/download",method = RequestMethod.POST)
//	@ResponseBody
//	public HttpServletResponse download(String path, HttpServletResponse response) {
//		try {
//			// path是指欲下载的文件的路径。
//			File file = new File(path);
//			// 取得文件名。
//			String filename = file.getName();
//			// 取得文件的后缀名。
//			String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();
//
//			// 以流的形式下载文件。
//			InputStream fis = new BufferedInputStream(new FileInputStream(path));
//			byte[] buffer = new byte[fis.available()];
//			fis.read(buffer);
//			fis.close();
//			// 清空response
//			response.reset();
//			// 设置response的Header
//			response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
//			response.addHeader("Content-Length", "" + file.length());
//			OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
//			response.setContentType("application/octet-stream");
//			toClient.write(buffer);
//			toClient.flush();
//			toClient.close();
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}
//		return response;
//	}


}
