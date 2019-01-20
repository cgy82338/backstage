package yc.xuezhifan.schoolbackstage.oss.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OssCacheMapper {

	/**
	 * @param url
	 * 保存 oss 上传成功的缓存地址
	 * @return
	 */
	Integer saveOssCache(@Param("id") String id, @Param("url") String url, @Param("yc_create_date") Date yc_create_date);

	/**
	 * 根据url删除oss缓存表
	 * @param url
	 * @return
	 */
	Integer deleteOssCache(@Param("url") String url);
	
}
