package yc.xuezhifan.schoolbackstage.uploadcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.fileshared.bean.YcFileUploadResult;
import yc.xuezhifan.schoolbackstage.schooldynamics.updateImage.UpdateImage;
import yc.xuezhifan.schoolbackstage.utils.AliyunOSSUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.text.NumberFormat;


/**
 * 
 * <p>
 * Title: AliyunUploadController.java
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018年11月19日
 * </p>
 * 
 * @email xiaobai@xuezhifan.com
 * 
 * @author xiaobai
 * 
 * @date 2018年11月19日
 * 
 * @version 1.0
 * 
 */
@Controller
@RequestMapping("/aliyunUpload")
public class AliyunUploadController {

	/**
	 * 上传通知公告图片
	 * @param file
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	@ResponseBody
	public JacksonData<String> uploadNotice(@RequestParam MultipartFile file, HttpServletRequest request) {
		String fileUrl = file.getOriginalFilename();
		try {
			String[] filetypes = fileUrl.split("\\.");
			String filetype = filetypes[filetypes.length-1];
			InputStream fileContent = file.getInputStream();
			String url = AliyunOSSUtil.uploadImage(fileContent, fileUrl, filetype, request.getSession());
			return ResultUtil.success(url);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error(204, null);
		}
	}

	/**
	 * 上传头像
	 * @param file
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/uploadAvator", method = RequestMethod.POST)
	@ResponseBody
	public JacksonData<String> uploadAvator(@RequestParam MultipartFile file, HttpServletRequest request) {
		String fileUrl = file.getOriginalFilename();
		try {
			String[] filetypes = fileUrl.split("\\.");
			String filetype = filetypes[filetypes.length-1];
			InputStream fileContent = file.getInputStream();
			String url = AliyunOSSUtil.uploadAvator(fileContent, fileUrl, filetype, request.getSession());
			return ResultUtil.success(url);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error(204, null);
		}
	}

	/**
	 * 上传音频
	 * @param file
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/uploadAudio", method = RequestMethod.POST)
	@ResponseBody
	public JacksonData<String> uploadAudio(@RequestParam MultipartFile file, HttpServletRequest request) {
		String fileUrl = file.getOriginalFilename();
		try {
			String[] filetypes = fileUrl.split("\\.");
			String filetype = filetypes[filetypes.length-1];
			InputStream fileContent = file.getInputStream();
			String url = AliyunOSSUtil.uploadAudio(fileContent, fileUrl, filetype, request.getSession());
			return ResultUtil.success(url);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error(204, null);
		}
	}

	/**
	 * 上传通知公告图片
	 * @param file
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/editorUploadImage", method = RequestMethod.POST)
	@ResponseBody
	public JacksonData<String> editorUploadImage(@RequestParam MultipartFile file, HttpServletRequest request) {
		String fileUrl = file.getOriginalFilename();
		try {
			String[] filetypes = fileUrl.split("\\.");
			String filetype = filetypes[filetypes.length-1];
			InputStream fileContent = file.getInputStream();
			String url = AliyunOSSUtil.uploadImage(fileContent, fileUrl, filetype, request.getSession());
			return new JacksonData(0,"上传成功",new UpdateImage(url,"学校动态图片"));
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error(204, null);
		}
	}

	/**
	 * 文件共享上传
	 *
	 * @param file
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/fileShared", method = RequestMethod.POST)
	@ResponseBody
	public JacksonData<String> fileShared(@RequestParam() MultipartFile file, HttpServletRequest request) {

		String fileUrl = file.getOriginalFilename();
		try {
			String[] filetypes = fileUrl.split("\\.");
			String filetype = filetypes[filetypes.length - 1];
			InputStream fileContent = file.getInputStream();
			String url = AliyunOSSUtil.fileShared(fileContent, fileUrl, filetype, request.getSession());
			YcFileUploadResult ycFileUploadResult = new YcFileUploadResult();
			double x= (double)file.getSize() / 1048576 ;
			NumberFormat ddf1=NumberFormat.getNumberInstance() ;
			ddf1.setMaximumFractionDigits(2);
			String s= ddf1.format(x) ;
			ycFileUploadResult.setYc_file_shared_size(s+ "MB");
//			System.out.println("精确"+s);

			ycFileUploadResult.setYc_file_shared_type(filetype);
			ycFileUploadResult.setYc_file_shared_url(url);
			return ResultUtil.success(ycFileUploadResult);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error(204, null);
		}
	}


}
