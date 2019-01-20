package yc.xuezhifan.schoolbackstage.oss.service;

import java.util.Date;

/**
 * @author wangAodi
 *oss 上传成功缓存地址，当提交到业务数据库时删除相应的属性
 */
public interface OssCacheService {
	
	Integer saveOssCache(String id, String url, Date date);
	
	/**
	 * 根据url删除oss缓存表
	 * @param url
	 * @return
	 */
	Integer deleteOssCache(String url);
}
