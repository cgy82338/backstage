package yc.xuezhifan.schoolbackstage.fileshared.bean;


/**
 * 

* <p>Title: YcFileUploadResult.java </p> 

* <p>Description: 文件上传返回结果表</p> 

* <p>Copyright: Copyright (c) 2018年10月19日</p>
 
* @email zhuangzhuang@xuezhifan.com

* @author zhuangzhuang 

* @date 2018年10月19日  

* @version 1.0
 */
public class YcFileUploadResult {
	
	private String yc_file_shared_type;//	文件类型
	
	private String yc_file_shared_size;//	文件大小

	private String yc_file_shared_url;//文件保存地址
	
	/**
	 * 封装
	 * @return
	 */
	public String getYc_file_shared_type() {
		return yc_file_shared_type;
	}

	public void setYc_file_shared_type(String yc_file_shared_type) {
		this.yc_file_shared_type = yc_file_shared_type;
	}

	public String getYc_file_shared_size() {
		return yc_file_shared_size;
	}

	public void setYc_file_shared_size(String yc_file_shared_size) {
		this.yc_file_shared_size = yc_file_shared_size;
	}

	public String getYc_file_shared_url() {
		return yc_file_shared_url;
	}

	public void setYc_file_shared_url(String yc_file_shared_url) {
		this.yc_file_shared_url = yc_file_shared_url;
	}

	@Override
	public String toString() {
		return "YcFileUploadResult [yc_file_shared_type=" + yc_file_shared_type + ", yc_file_shared_size="
				+ yc_file_shared_size + ", yc_file_shared_url=" + yc_file_shared_url + "]";
	}
	
	
	
	
	
}
