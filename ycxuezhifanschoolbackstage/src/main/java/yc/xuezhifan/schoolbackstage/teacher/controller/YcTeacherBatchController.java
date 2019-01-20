package yc.xuezhifan.schoolbackstage.teacher.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import yc.xuezhifan.schoolbackstage.annotation.CurrentSchool;
import yc.xuezhifan.schoolbackstage.annotation.SchoolLogin;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.YcTeacherConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.teacher.bean.YcTeacherExcel;
import yc.xuezhifan.schoolbackstage.teacher.service.YcTeacherService;
import yc.xuezhifan.schoolbackstage.utils.FileUtil;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;


/**
 * 

* <p>Title: YcTeacherBatchController.java </p> 

* <p>Description: Excel批量操作</p> 

* <p>Copyright: Copyright (c) 2018年10月2日</p>
 
* @email zhuangzhuang@xuezhifan.com

* @author zhuangzhuang 

* @date 2018年10月2日  

* @version 1.0
 */
@Controller
@RequestMapping("/teacher")
public class YcTeacherBatchController {

	@Autowired
	YcTeacherService ycTeacherService;

	
	/**
	 * 导出批量添加教师表格
	 */
	@RequestMapping(value="/exportTeacherExcel")
	public void exportTeacherExcel(HttpServletResponse response) {
		
		//模拟从数据库获取需要导出的数据
        List<YcTeacherExcel> personList = new ArrayList<>();
        //导出操作
        FileUtil.exportExcel(personList,"教师信息统计表","教师信息统计表",YcTeacherExcel.class,"教师信息统计表.xls",response);
        
	}
	
	/**
	 * 导入表格并批量添加数据
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/importTeacherExcel")
	@ResponseBody
	@SchoolLogin
	public JacksonData importTeacherExcel(@CurrentSchool YcSchool ycSchool ,MultipartFile file ) throws Exception {
		
		String filename = file.getOriginalFilename();
		File newFile = new File(filename);
		FileOutputStream os = new FileOutputStream(newFile);
		os.write(file.getBytes());
		os.close();

        //解析excel
        List<YcTeacherExcel> personList = FileUtil.importExcel(filename,1,1,YcTeacherExcel.class);
		String result = ycTeacherService.saveTeacherBatch(ycSchool, personList);
		//删除文件
		newFile.delete();
		System.out.println(result);
		if ("批量添加教师成功".equals(result)){
			return ResultUtil.success(result);
		}else {
			return ResultUtil.errorObject(204,result);
		}

	}
	
	@RequestMapping("/hello")
	public ModelAndView hello() {
		return new ModelAndView("/hello");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
