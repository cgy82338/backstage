package yc.xuezhifan.schoolbackstage.oss.bean;

/**
 * @author Administrator
 * Oss缓存对象
 */
public class OssCacheBean {
	private String id;
	private String yc_url;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getYc_url() {
		return yc_url;
	}
	public void setYc_url(String yc_url) {
		this.yc_url = yc_url;
	}
	public OssCacheBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OssCacheBean(String id, String yc_url) {
		super();
		this.id = id;
		this.yc_url = yc_url;
	}
	
	
}
