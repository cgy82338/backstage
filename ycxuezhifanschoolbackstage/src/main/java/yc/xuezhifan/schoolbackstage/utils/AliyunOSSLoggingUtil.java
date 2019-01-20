package yc.xuezhifan.schoolbackstage.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.BucketLoggingResult;
import com.aliyun.oss.model.SetBucketLoggingRequest;

import yc.xuezhifan.schoolbackstage.properties.AliyunOSSPropertie;

/** 
* @author hanchangqing 
* @version 创建时间：2018年8月10日 下午4:22:33 
* 阿里云oss日志管理工具类 
*/
public class AliyunOSSLoggingUtil {
	static String endpoint = AliyunOSSPropertie.ALIYUNOSS_END_POINT;
	static String accessKeyId = AliyunOSSPropertie.ALIYUNOSS_ACCESS_KEY_ID;
	static String accessKeySecret = AliyunOSSPropertie.ALIYUNOSS_ACCESS_KEY_SECRET;
	static String bucketName = AliyunOSSPropertie.ALIYUNOSS_BUCKET_NAME;
	
	/**
	 * 开启AliyunOSS日志
	 */
	private void startUpLogging() {
		
		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
	    
		SetBucketLoggingRequest request = new SetBucketLoggingRequest(bucketName);
		
		// 设置存放日志文件的存储空间。
		request.setTargetBucket("yclogging");
		
		// 设置日志文件存放的目录。
		request.setTargetPrefix("ycxzf");
		ossClient.setBucketLogging(request);
		
		// 关闭OSSClient。
		ossClient.shutdown();
		
	}
	
	/**
	 * 查看AliyunOSS日志
	 */
	private void viewLogging() {

		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		BucketLoggingResult result = ossClient.getBucketLogging(bucketName);
		System.out.println(result.getTargetBucket());
		System.out.println(result.getTargetPrefix());
		// 关闭OSSClient。
		ossClient.shutdown();
		
		
	}
	
	
	/**
	 * 关闭AliyunOSS日志
	 */
	private void shutdownLogging() {
		
		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		SetBucketLoggingRequest request = new SetBucketLoggingRequest(bucketName);
		request.setTargetBucket(null);
		request.setTargetPrefix(null);
		ossClient.setBucketLogging(request);
		// 关闭OSSClient。
		ossClient.shutdown();
	}
	
}
