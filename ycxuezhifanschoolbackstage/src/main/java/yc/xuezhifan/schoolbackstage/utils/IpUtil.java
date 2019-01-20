package yc.xuezhifan.schoolbackstage.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 
 * @author liuke
 * @date   2018年8月4日
 *
 */
public class IpUtil {
	public static String getIp(){
		 String localip=null;
		 InetAddress ia=null;
		try {
			 ia=InetAddress.getLocalHost();
			  localip=ia.getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return localip;
	}
	
}
