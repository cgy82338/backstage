package yc.xuezhifan.schoolbackstage.bean;

/**
 * 

* <p>Title: JacksonData.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月28日</p>
 
* @email zhuangzhuang@xuezhifan.com

* @author zhuangzhuang 

* @date 2018年10月28日  

* @version 1.0
 */
public class JacksonData<T> {
private Integer code;
private String msg;
private T data;
private long count;
public Integer getCode() {
	return code;
}
public void setCode(Integer code) {
	this.code = code;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public T getData() {
	return data;
}
public void setData(T data) {
	this.data = data;
}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public JacksonData() {
	super();
	// TODO Auto-generated constructor stub
}
public JacksonData(Integer code, String msg, T data) {
	super();
	this.code = code;
	this.msg = msg;
	this.data = data;
}
}
