package yc.xuezhifan.schoolbackstage.utils;

import yc.xuezhifan.schoolbackstage.bean.JacksonData;

/**
 * 

* <p>Title: ResultUtil.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月17日</p>
 
* @email zhuangzhuang@xuezhifan.com

* @author zhuangzhuang 

* @date 2018年10月17日  

* @version 1.0
 */
public class ResultUtil {
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static  JacksonData success(Object data){
		JacksonData result=new JacksonData();
		result.setCode(200);
		result.setMsg("成功");
		result.setData(data);
		return result;
	}

	@SuppressWarnings("rawtypes")
	public static JacksonData success() {
		return success(null);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static  JacksonData success(Object data,long count){
		JacksonData result=new JacksonData();
		result.setCode(200);
		result.setMsg("成功");
		result.setData(data);
		result.setCount(count);
		return result;
	}
	@SuppressWarnings("rawtypes")
	public static JacksonData error(Integer code,String  msg) {
		JacksonData result=new JacksonData();
		result.setCode(code);
		result.setMsg(msg);
		return result;
		
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JacksonData errorObject(Integer code,Object  data) {
		JacksonData result=new JacksonData();
		result.setCode(code);
		result.setData(data);
		return result;
		
	}
}
