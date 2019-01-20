package yc.xuezhifan.schoolbackstage.oss.service.iml;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yc.xuezhifan.schoolbackstage.oss.mapper.OssCacheMapper;
import yc.xuezhifan.schoolbackstage.oss.service.OssCacheService;

/**
 * @author wangAodi
 * oss 上传成功缓存地址，当提交到业务数据库时删除相应的属性
 */
@Service
public class OssCacheServiceImpl implements OssCacheService {

	@Autowired
	OssCacheMapper ossCacheMapper;
	
	public Integer saveOssCache(String id, String url,Date date) {
		// TODO Auto-generated method stub
		return ossCacheMapper.saveOssCache(id,url,date);
	}

	/**
	 * 根据url删除oss缓存表
	 */
	@Override
	public Integer deleteOssCache(String url) {
		// TODO Auto-generated method stub
		return ossCacheMapper.deleteOssCache(url);
	}

}
