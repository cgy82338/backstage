package yc.xuezhifan.schoolbackstage.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;

import yc.xuezhifan.schoolbackstage.properties.AliyunOSSPropertie;

import javax.servlet.http.HttpSession;

/** 
* @author hanchangqing 
* @version 创建时间：2018年8月10日 下午3:40:42 
* 阿里云OSS查询、删除工具类
*/

public class AliyunOSSUtil {
	
	static String endpoint = AliyunOSSPropertie.ALIYUNOSS_END_POINT;
	static String accessKeyId = AliyunOSSPropertie.ALIYUNOSS_ACCESS_KEY_ID;
	static String accessKeySecret = AliyunOSSPropertie.ALIYUNOSS_ACCESS_KEY_SECRET;
	static String bucketName = AliyunOSSPropertie.ALIYUNOSS_BUCKET_NAME;
	static String fileHost = AliyunOSSPropertie.ALIYUNOSS_FILE_HOST;
	static String fileVideoHost = AliyunOSSPropertie.ALIYUNOSS_FILE_VIDEO_HOST;

	private static String timeString = DateUtil.getDateAndTimeThree();//时间
	private static String notice = AliyunOSSPropertie.ALIYUN_OSS_NOTICE;
	private static String image = AliyunOSSPropertie.ALIYUN_OSS_IMAGE;
	private static String audio = AliyunOSSPropertie.ALIYUN_OSS_AUDIO;
	private static String avator = AliyunOSSPropertie.ALIYUN_OSS_AVATOR;
	/**
	 * 查询对象是否存在OSS
	 * @param key 资源地址（url）
	 * @return
	 */
	public static boolean objectExist(String key){
		
		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		
		// 判断文件是否存在。
	    boolean found = ossClient.doesObjectExist(bucketName, key);
	    System.out.println(found);
	    
	    // 关闭OSSClient。
	    ossClient.shutdown();
		
		return found;
	}
	
	/**
	 * 删除OSS存储对象(单一删除)
	 * @param fileUrl
	 */
	public static boolean deleteObject(String fileUrl) {

		//获取fileName
		String fileName = AliyunOSSUtil.getFileName(fileUrl);
		if(bucketName==null||fileName==null) return false; 
		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		
		// 删除文件。
		ossClient.deleteObject(bucketName, fileName);
		
		// 关闭OSSClient。
		ossClient.shutdown();
		return true;  
	}

	/**
	 * 删除OSS存储对象(多文件删除)
	 * @param fileUrls
	 */
	public static int deleteObjectList(List<String> fileUrls) {
		int deleteCount = 0; //成功删除的个数
		List<String> fileNames = AliyunOSSUtil.getFileName(fileUrls);
		if(bucketName==null||fileNames.size()<=0) return 0; 

		
		// 创建OSSClient实例。
		OSSClient ossClient = null;
		try {
			ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
			// 删除文件。
			DeleteObjectsResult deleteObjectsResult = ossClient.deleteObjects(new DeleteObjectsRequest(bucketName).withKeys(fileNames));
			//删除成功的文件列表
			List<String> deletedObjects = deleteObjectsResult.getDeletedObjects();
			deleteCount = deleteObjectsResult.getDeletedObjects().size();  
			System.out.println("成功删除："+deletedObjects);
		} catch (OSSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {  
			// 关闭OSSClient。
	 		ossClient.shutdown();
        }  
		 return deleteCount;  
		
	}
	
	/**
	 * 根据url获取fileName
	 * @param fileUrl
	 * @return
	 */
	private static String getFileName(String fileUrl){  
	        String str = "aliyuncs.com/";  
	        int beginIndex = fileUrl.indexOf(str);  
	        if(beginIndex==-1) return null;  
	        return fileUrl.substring(beginIndex+str.length());  
	}  
	
	/**
	 * 根据url获取fileNames集合
	 * @param fileUrls
	 * @return
	 */
	private static List<String> getFileName(List<String> fileUrls){  
	        List<String> names = new ArrayList<>();  
	        for (String url : fileUrls) {  
	            names.add(getFileName(url));  
	        }  
	        return names;  
	 }



	private static OSSClient client = null;
	private static ObjectMetadata meta = null;

	public static void init() {
		client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		meta = new ObjectMetadata();
	}


	/**
	 * 上传通知公告图片
	 * @param content
	 * @param fileUrl
	 * @param mimeType
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static String uploadImage(InputStream content, String fileUrl, String mimeType, HttpSession session)
			throws Exception {
		init();
		meta.setContentType(mimeType);
		String videoUrl = (notice +"/"+ image + "/" + timeString + "/"
				+ UUID.randomUUID().toString().replace("-", "") + "." + mimeType);
		PutObjectResult result = client.putObject(new PutObjectRequest(bucketName, videoUrl, content, meta)
				.<PutObjectRequest>withProgressListener(new PutObjectProgressListener(session)));
		System.out.println(AliyunOSSUploadUtil.getUrl(videoUrl).split("[?]")[0]);
		return AliyunOSSUploadUtil.getUrl(videoUrl).split("[?]")[0];
	}

	/**
	 * 上传头像
	 * @param content
	 * @param fileUrl
	 * @param mimeType
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static String uploadAvator(InputStream content, String fileUrl, String mimeType, HttpSession session)
			throws Exception {
		init();
		meta.setContentType(mimeType);
		String videoUrl = (avator +"/"+ image + "/" + timeString + "/"
				+ UUID.randomUUID().toString().replace("-", "") + "." + mimeType);
		PutObjectResult result = client.putObject(new PutObjectRequest(bucketName, videoUrl, content, meta)
				.<PutObjectRequest>withProgressListener(new PutObjectProgressListener(session)));
		System.out.println(AliyunOSSUploadUtil.getUrl(videoUrl).split("[?]")[0]);
		return AliyunOSSUploadUtil.getUrl(videoUrl).split("[?]")[0];
	}

	/**
	 * 上传音频
	 * @param content
	 * @param fileUrl
	 * @param mimeType
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static String uploadAudio(InputStream content, String fileUrl, String mimeType, HttpSession session)
			throws Exception {
		init();
		meta.setContentType(mimeType);
		String videoUrl = (notice +"/"+ audio + "/" + timeString + "/"
				+ UUID.randomUUID().toString().replace("-", "") + "." + mimeType);
		PutObjectResult result = client.putObject(new PutObjectRequest(bucketName, videoUrl, content, meta)
				.<PutObjectRequest>withProgressListener(new PutObjectProgressListener(session)));
		System.out.println(AliyunOSSUploadUtil.getUrl(videoUrl).split("[?]")[0]);
		return AliyunOSSUploadUtil.getUrl(videoUrl).split("[?]")[0];
	}


	/**
	 * 文件共享上传
	 * @param content
	 * @param fileUrl
	 * @param mimeType
	 * @param session
	 * @return
	 */
	public static String fileShared(InputStream content, String fileUrl, String mimeType, HttpSession session) {
		init();
		if ( mimeType.equalsIgnoreCase("jpg") || mimeType.equalsIgnoreCase("jpeg") || mimeType.equalsIgnoreCase("png") || mimeType.equalsIgnoreCase("bmp") || mimeType.equalsIgnoreCase("gif") ) {

			meta.setContentType(mimeType);
			String imageUrl = ("sharedfiles" + "/" + image + "/" + timeString + "/"
					+ UUID.randomUUID().toString().replace("-", "") + "." + mimeType);
			PutObjectResult result = client.putObject(new PutObjectRequest(bucketName, imageUrl, content, meta)
					.<PutObjectRequest>withProgressListener(new PutObjectProgressListener(session)));
			return AliyunOSSUploadUtil.getUrl(imageUrl).split("[?]")[0];

		} else if ( mimeType.equalsIgnoreCase("mp4") || mimeType.equalsIgnoreCase("3gp") || mimeType.equalsIgnoreCase("mov") || mimeType.equalsIgnoreCase("m4v") || mimeType.equalsIgnoreCase("rmvb") || mimeType.equalsIgnoreCase("wmv") || mimeType.equalsIgnoreCase("flv") || mimeType.equalsIgnoreCase("avi")) {

			meta.setContentType(mimeType);
			String videoUrl = ("sharedfiles" + "/" + "video" + "/" + timeString + "/"
					+ UUID.randomUUID().toString().replace("-", "") + "." + mimeType);
			PutObjectResult result = client.putObject(new PutObjectRequest(bucketName, videoUrl, content, meta)
					.<PutObjectRequest>withProgressListener(new PutObjectProgressListener(session)));
			return AliyunOSSUploadUtil.getUrl(videoUrl).split("[?]")[0];

		} else if ( mimeType.equalsIgnoreCase("txt") || mimeType.equalsIgnoreCase("doc") || mimeType.equalsIgnoreCase("pdf") || mimeType.equalsIgnoreCase("docx") || mimeType.equalsIgnoreCase("ppt") || mimeType.equalsIgnoreCase("pptx") || mimeType.equalsIgnoreCase("xls") || mimeType.equalsIgnoreCase("xlsx")) {

			meta.setContentType(mimeType);
			String fileUrl2 = ("sharedfiles" + "/" + "file" + "/" + timeString + "/"
					+ UUID.randomUUID().toString().replace("-", "") + "." + mimeType);
			PutObjectResult result = client.putObject(new PutObjectRequest(bucketName, fileUrl2, content, meta)
					.<PutObjectRequest>withProgressListener(new PutObjectProgressListener(session)));
			return AliyunOSSUploadUtil.getUrl(fileUrl2).split("[?]")[0];

		} else if (mimeType.equalsIgnoreCase("mp3") ||mimeType.equalsIgnoreCase("wav") ||mimeType.equalsIgnoreCase("aac") ) {

			meta.setContentType(mimeType);
			String audioUrl = ("sharedfiles" + "/" + audio + "/" + timeString + "/"
					+ UUID.randomUUID().toString().replace("-", "") + "." + mimeType);
			PutObjectResult result = client.putObject(new PutObjectRequest(bucketName, audioUrl, content, meta)
					.<PutObjectRequest>withProgressListener(new PutObjectProgressListener(session)));
			return AliyunOSSUploadUtil.getUrl(audioUrl).split("[?]")[0];

		} else {

			meta.setContentType(mimeType);
			String otherUrl = ("sharedfiles" + "/" + "other" + "/" + timeString + "/"
					+ UUID.randomUUID().toString().replace("-", "") + "." + mimeType);
			PutObjectResult result = client.putObject(new PutObjectRequest(bucketName, otherUrl, content, meta)
					.<PutObjectRequest>withProgressListener(new PutObjectProgressListener(session)));
			return AliyunOSSUploadUtil.getUrl(otherUrl).split("[?]")[0];

		}

	}
}
