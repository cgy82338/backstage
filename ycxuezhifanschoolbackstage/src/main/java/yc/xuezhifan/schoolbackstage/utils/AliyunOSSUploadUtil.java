package yc.xuezhifan.schoolbackstage.utils;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import yc.xuezhifan.schoolbackstage.properties.AliyunOSSPropertie;

/**
 * 阿里云上传工具类
 * 
 * @author hanchangqing
 *
 */
public class AliyunOSSUploadUtil {

	private static final Logger logger = LoggerFactory.getLogger(AliyunOSSUploadUtil.class);
	
	static String endpoint = AliyunOSSPropertie.ALIYUNOSS_END_POINT;
	static String accessKeyId = AliyunOSSPropertie.ALIYUNOSS_ACCESS_KEY_ID;
	static String accessKeySecret = AliyunOSSPropertie.ALIYUNOSS_ACCESS_KEY_SECRET;
	static String bucketName = AliyunOSSPropertie.ALIYUNOSS_BUCKET_NAME;
	static String fileHost = AliyunOSSPropertie.ALIYUNOSS_FILE_HOST;
	static String fileVideoHost = AliyunOSSPropertie.ALIYUNOSS_FILE_VIDEO_HOST;
	static String fileImageHost = AliyunOSSPropertie.ALIYUN_OSS_IMAGE;

	static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	static String dateStr = format.format(new Date());

	static OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

	/**
	 * 上传视频类型文件
	 * @param file
	 * @return url
	 */
	public static String uploadVideo(File file) {

		logger.info("666=========>OSS文件上传开始：" + file.getName());
		try {
			// 容器不存在，就创建
			if (!ossClient.doesBucketExist(bucketName)) {
				ossClient.createBucket(bucketName);
				CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
				createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
				ossClient.createBucket(createBucketRequest);
			}
			// 创建文件路径
			String videoUrl = fileVideoHost + "/"
					+ (dateStr + "/" + UUID.randomUUID().toString().replace("-", "") + "-" + file.getName());
			// 上传文件
			PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName, videoUrl, file).withProgressListener(new PutObjectProgressListener()));
//			ossClient.putObject(new PutObjectRequest(bucketName, videoUrl, file).
//	        		<PutObjectRequest>withProgressListener(new PutObjectProgressListener()));
			// 设置权限 这里是公开读
			ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicReadWrite);
			if (null != result) {
				logger.info("888==========>OSS文件上传成功,OSS地址：" + videoUrl);
				return videoUrl;
			}
		} catch (OSSException oe) {
			logger.error(oe.getMessage());
		} catch (ClientException ce) {
			logger.error(ce.getMessage());
		} finally {
			// 关闭
//			ossClient.shutdown();
			
			
		}
		return null;
	}

	/**
	 * 上传图片类型文件
	 * @param file
	 * @return
	 */
	public static String uploadImage(File file) {

		logger.info("666=========>OSS文件上传开始：" + file.getName());
		try {
			// 容器不存在，就创建
			if (!ossClient.doesBucketExist(bucketName)) {
				ossClient.createBucket(bucketName);
				CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
				createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
				ossClient.createBucket(createBucketRequest);
			}
			// 创建文件路径
			String imageUrl = fileImageHost + "/"
					+ (dateStr + "/" + UUID.randomUUID().toString().replace("-", "") + "-" + file.getName());
			System.out.println(imageUrl);
			// 上传文件
			PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName, imageUrl, file).withProgressListener(new PutObjectProgressListener()));
			// 设置权限 这里是公开读
			ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicReadWrite);
			if (null != result) {
				logger.info("888==========>OSS文件上传成功,OSS地址：" + imageUrl);
				return imageUrl;
			}
		} catch (OSSException oe) {
			logger.error(oe.getMessage());
		} catch (ClientException ce) {
			logger.error(ce.getMessage());
		} finally {
			// 关闭
//			ossClient.shutdown();
		}
		return null;
	}

	/**
	 * 上传其他类型文件
	 * @param file
	 * @return
	 */
	public static String uploadOther(File file) {

		logger.info("666=========>OSS文件上传开始：" + file.getName());
		try {
			// 容器不存在，就创建
			if (!ossClient.doesBucketExist(bucketName)) {
				ossClient.createBucket(bucketName);
				CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
				createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
				ossClient.createBucket(createBucketRequest);
			}
			// 创建文件路径
			String otherUrl = fileHost + "/"
					+ (dateStr + "/" + UUID.randomUUID().toString().replace("-", "") + "-" + file.getName());
			// 上传文件
			PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName, otherUrl, file).withProgressListener(new PutObjectProgressListener()));
			// 设置权限 这里是公开读
			ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicReadWrite);
			if (null != result) {
				logger.info("888==========>OSS文件上传成功,OSS地址：" + otherUrl);
				return otherUrl;
			}
		} catch (OSSException oe) {
			logger.error(oe.getMessage());
		} catch (ClientException ce) {
			logger.error(ce.getMessage());
		} finally {
			// 关闭
//			ossClient.shutdown();
		}
		return null;
	}

	/**
	 * 获得url链接
	 *
	 * @param key
	 * @return
	 */
	public static String getUrl(String key) {
		// 设置URL过期时间为10年 3600l* 1000*24*365*10

		String endpoint = AliyunOSSPropertie.ALIYUNOSS_END_POINT;
		String accessKeyId = AliyunOSSPropertie.ALIYUNOSS_ACCESS_KEY_ID;
		String accessKeySecret = AliyunOSSPropertie.ALIYUNOSS_ACCESS_KEY_SECRET;
		String bucketName = AliyunOSSPropertie.ALIYUNOSS_BUCKET_NAME;
		String fileHost = AliyunOSSPropertie.ALIYUNOSS_FILE_HOST;
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

		Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
		// 生成URL
		URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
		if (url != null) {
			System.out.println("haha==========>OSS文件地址：" + url);
			return url.toString();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
