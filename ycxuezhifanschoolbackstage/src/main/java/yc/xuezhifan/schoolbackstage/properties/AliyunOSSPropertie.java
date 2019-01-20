package yc.xuezhifan.schoolbackstage.properties;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 

* <p>Title: AliyunOSSPropertie.java </p> 

* <p>Description: 阿里云OSS配置文件</p> 

* <p>Copyright: Copyright (c) 2018年10月28日</p>
 
* @email zhuangzhuang@xuezhifan.com

* @author zhuangzhuang 

* @date 2018年10月28日  

* @version 1.0
 */
@Component
public class AliyunOSSPropertie implements InitializingBean {

	@Value("${aliyun.oss.endpoint}")
	private String aliyun_oss_endpoint;

	@Value("${aliyun.oss.keyid}")
	private String aliyun_oss_keyid;

	@Value("${aliyun.oss.keysecret}")
	private String aliyun_oss_keysecret;

	@Value("${aliyun.oss.filehost}")
	private String aliyun_oss_filehost;

    @Value("${aliyun.oss.bucketname}")
    private String aliyun_oss_bucketname;
    
    @Value("${aliyun.oss.filevideohost}")
	private String aliyun_oss_filevideohost;

	@Value("${aliyun.oss.filecoursehost}")
	private String aliyun_oss_filecoursehost;

	@Value("${aliyun.oss.notice}")
	private String aliyun_oss_notice;

	@Value("${aliyun.oss.image}")
	private String aliyun_oss_image;

	@Value("${aliyun.oss.audio}")
	private String aliyun_oss_audio;

	@Value("${aliyun.oss.avator}")
	private String aliyun_oss_avator;

	public static String ALIYUNOSS_END_POINT;
	public static String ALIYUNOSS_ACCESS_KEY_ID;
	public static String ALIYUNOSS_ACCESS_KEY_SECRET;
    public static String ALIYUNOSS_BUCKET_NAME;
	public static String ALIYUNOSS_FILE_HOST;
	public static String ALIYUNOSS_FILE_VIDEO_HOST;
	public static String ALIYUNOSS_FILE_COURSE_HOST;
	public static String ALIYUN_OSS_NOTICE;
	public static String ALIYUN_OSS_IMAGE;
	public static String ALIYUN_OSS_AUDIO;
	public static String ALIYUN_OSS_AVATOR;


	@Override
	public void afterPropertiesSet() throws Exception {
		ALIYUNOSS_END_POINT = aliyun_oss_endpoint;
		ALIYUNOSS_ACCESS_KEY_ID = aliyun_oss_keyid;
		ALIYUNOSS_ACCESS_KEY_SECRET = aliyun_oss_keysecret;
		ALIYUNOSS_FILE_HOST = aliyun_oss_filehost;
		ALIYUNOSS_BUCKET_NAME = aliyun_oss_bucketname;
		ALIYUNOSS_FILE_VIDEO_HOST = aliyun_oss_filevideohost;
		ALIYUNOSS_FILE_COURSE_HOST = aliyun_oss_filecoursehost;
		ALIYUN_OSS_NOTICE = aliyun_oss_notice;
		ALIYUN_OSS_IMAGE = aliyun_oss_image;
		ALIYUN_OSS_AUDIO = aliyun_oss_audio;
		ALIYUN_OSS_AVATOR = aliyun_oss_avator;
	}
}
