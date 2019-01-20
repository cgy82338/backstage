package yc.xuezhifan.schoolbackstage.utils;

import javax.servlet.http.HttpSession;

import com.aliyun.oss.event.ProgressEvent;
import com.aliyun.oss.event.ProgressEventType;
import com.aliyun.oss.event.ProgressListener;

/**
 * @author hanchangqing
 * @version 创建时间：2018年8月10日 上午10:39:35 类说明
 */
public class PutObjectProgressListener implements ProgressListener {

	private long bytesWritten = 0L;
	private long totalBytes = -1L;
	private boolean succeed = false;
	private HttpSession session;
	private long percent = 0L;

	public PutObjectProgressListener() {

	}

	public PutObjectProgressListener(HttpSession mSession) {
		this.session = mSession;
		session.setAttribute("upload_percent", percent);
	}

	public void progressChanged(ProgressEvent progressEvent) {
		long bytes = progressEvent.getBytes();
		this.totalBytes = bytes;
		ProgressEventType eventType = progressEvent.getEventType();
		switch (eventType) {
		case TRANSFER_STARTED_EVENT:
			System.out.println("Start to upload......");
			break;
		case REQUEST_CONTENT_LENGTH_EVENT:
			
			break;
		case REQUEST_BYTE_TRANSFER_EVENT:
			this.bytesWritten += bytes;
			if (this.totalBytes != -1) {
				percent = this.bytesWritten;
				// 将进度percent放入session中
				session.setAttribute("upload_percent", percent);
				session.setAttribute("bytes", bytes/1024);
			} else {
				System.out.println(bytes + " 此时已写入字节，上传比例：" + "(" + this.bytesWritten + "/" + this.totalBytes + ")");
			}
			break;
		case TRANSFER_COMPLETED_EVENT:
			this.succeed = true;
			System.out.println("Succeed to upload, " + this.bytesWritten + " bytes have been transferred in total");
			break;
		case TRANSFER_FAILED_EVENT:
			System.out.println("Failed to upload, " + this.bytesWritten + " bytes have been transferred");
			break;
		default:
			break;
		}
	}

	public boolean isSucceed() {
		return succeed;
	}
}
