package yc.xuezhifan.schoolbackstage.utils;

import io.rong.RongCloud;
import io.rong.methods.message._private.Private;
import io.rong.methods.message.chatroom.Chatroom;
import io.rong.methods.message.discussion.Discussion;
import io.rong.methods.message.history.History;
import io.rong.methods.message.system.MsgSystem;
import io.rong.methods.sensitive.SensitiveWord;
public class RongCloudUtil {
	private static final String appKey = "n19jmcy5n82a9";
	private static final String appSecret = "UQhK5ZWBD4";
	private static final String appkey1="pwe86ga5pvk46";
	private static final String appSecret1="vLXLPd6Nvdb";
	
	private static final RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
	private static final RongCloud rongCloud1 = RongCloud.getInstance(appkey1, appSecret1);
	public static RongCloud getRongcloud1() {
		return rongCloud1;
	}
		// 自定义 api 地址方式
		Private Private = rongCloud.message.msgPrivate;
		MsgSystem system = rongCloud.message.system;
		Chatroom chatroom = rongCloud.message.chatroom;
		Discussion discussion = rongCloud.message.discussion;
		History history = rongCloud.message.history;//历史
		SensitiveWord SensitiveWord=rongCloud.sensitiveword;//敏感词 
		public static RongCloud getRongcloud() {
			return rongCloud;
		}
		
		
}
