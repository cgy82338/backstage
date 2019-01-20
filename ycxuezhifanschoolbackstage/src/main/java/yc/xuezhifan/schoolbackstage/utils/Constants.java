package yc.xuezhifan.schoolbackstage.utils;

import yc.xuezhifan.schoolbackstage.smsmoible.util.MD5;

/**
 *
 *
 * <p>
 * Title: Constants.java
 * </p>
 *
 * <p>
 * Description:
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2018年10月19日
 * </p>
 *
 * @email xiaoke@xuezhifan.com
 *
 * @author xiaoke
 *
 * @date 2018年10月19日
 *
 * @version 1.0
 */
public class Constants {
	// public static final String URL = "http://www.xuezhifan.com/";
	public static final String URL = "http://172.16.0.169:8080/";
//        public static final String URL = "http://172.16.0.188:9998/";

	public static final String DOWNLOAD_URL = URL + "html/huamutong.apk";
	public static final String COVER_DEFAULT = "default_avatar.png";
	public static final String FILE_PATH = "D://recordfile";

	/*
	 * public static final String API_KEY = "HGGcyEBPPlfjIieCVnWSlMD6"; public
	 * static final String SECRET_KEY = "vFypyImE4aFxWspAHTCbpsm4Nh2P2pPN";
	 *
	 * public static final String IOS_API_KEY = "7Bh59Y1Rv6o8lLzF0NFq5iUG"; public
	 * static final String IOS_SECRET_KEY = "0poAXw15j9GmGdGCVxP3SlaQXbs4BKkE";
	 */

	/*
	 * public static final String SAVE_ERROR = "save_error"; public static final
	 * String DEFAULT_SERVICE_TOP_BG = "img/user_bg.jpg";//默认背景图--顶部的 public static
	 * final String DEFAULT_DOWNLOAD_URL = "html/download.html";//默认下载地址
	 */
	public static final String HAS_ZAN = "has_zan";

	public static final String HAS_CODE = "has_code";

	public static final String NO_SEND_CODE = "no_send_code";

	public static final String SEND_SMS_ERROR = "send_sms_error";

	public static final String HAS_EXISTS = "has_exists";

	public static final String TOO_MANY_CODE = "too_many_code";

	public static final String CODE_NOT_EQUAL = "code_not_equal";

	public static final String PHONE_ERROR = "phone_error";

	public static final String HX_ERROR = "hx_error";
	// 短信验证配置url
	public static final String SMSURL = "http://sms.10690221.com:9011/hy/";
	public static final String SMSUID = "80777";
	public static final String SMSAUTH = new MD5().getMD5ofStr("qyrjqyrj87987");

	public static final Long DAY_MILLISECOND = 86400000L;

	// 支付半 appid
	public static final String PARTNER = "2018101961725158";
	//商户pid
	public static final String ALIPID="2088621208860854";
	// 商户收款账号
	public static final String SELLER = "2452249931@qq.com";
	// 商户私钥，pkcs8格式
	public static final String RSA_PRIVATE = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDApmdWfmA4gSFM\r\n" +
			"2SiA6FpXAARKei39VGBMMEYE0Pvdz2xgig4+VYfEYZyrmhfgaeh//xWOOUsG0Ua/\r\n" +
			"HUF3PEdOHsMVZAUJr0IYkYKKSeM85b3d/GVk75QzCI1VDBUlX879EiBUxvPPgwL4\r\n" +
			"DubRkxvhETcaGxhta7yzvj5XzD7cdlLI78kuqbrB1VTVB2ChjxaT6YvdaFbbiDw0\r\n" +
			"/Ifq36zRtm/3srpPMAFQuwLUQ19EUX5uCJiZLU+9D9yWiXzdWR7ZCIG40AU6gvKN\r\n" +
			"gDEQikgw7omn1As5yUwDqM0Rxwuh3fq59fxgViKxPwcKXOqfAphPLIBRNkdDMINd\r\n" +
			"n4oUMkahAgMBAAECggEACMfMz/Fkm06vYNxI708nxu1WRLq629/7n51Xo6KOyDZK\r\n" +
			"/z9rlMW7MWUtidi1G+JX2XWb2uabl8z0B4Pi1vdlXJckVxY+8IkPXyVKqNjjRYRH\r\n" +
			"GhYF3QraW1UZc/XgBNsQCRLJbHPA6wVSnlG3jXfB/okVVNhFTb9qU1rpZoEFoHCj\r\n" +
			"5nnRQ5Zv2iDO+v0X1nfzLVL9r0dUoRTFCCZfWN5RI8yDbjMUB50IGFrR8CLzPUae\r\n" +
			"jJCtMxTOZ9UGxlL/YV4GfdU0ozGPqfwMC/72gVgxbQYLqPsIsf9wIkmuHxsA7SbJ\r\n" +
			"GLDYi2SoXW4iNK4siZtwqNlE+h4spklUeT8GXJfMkQKBgQDk+44DNSXO1yI8DwV1\r\n" +
			"XRWaEM1jGW7AlnnUfLoIOmPfn3Qhsiy4RSYVV7GbPGjGukZqwst0pvIC851q/z51\r\n" +
			"4HzCAkXx5GggjoajS8MFtqIiIaEmbwAlFOQ0B6pCJzOdTnXkQsTUR0f77w/dZoUd\r\n" +
			"NmGtnKGpPBli6hcpTmycYPVvrQKBgQDXYWsNPwwnhNNl7NNPfm3cZGnOlMAWRv5I\r\n" +
			"ccac5ODC0O2cHbZ/R72rZ26C2dsp4ARoKG8gXgw00hDyCEV7V+4dmdmTexWhAQeI\r\n" +
			"ws81x+RPx4bsLQbV24Utxt+Rcr/+o6ahhgYc2Z3QMHGHgKvnI41wXz5SHwqoJNIm\r\n" +
			"2CI/7HmBRQKBgQDj4c2VN6Fm1geGCdT+1iKXbz1X8ImeNKMOawqhAas/c+sZVb7X\r\n" +
			"rEmYV+uzeE016VAHE9FzSGn1sgjp4ReCLGU8lxKRByTxsaYggVeXKgj1Os6r9zAH\r\n" +
			"t2DcvvwcVfMyDFGbVy+Xq1DiUypQxqSXS/Wt2AGy8NK69AkU3K2Oe5gHCQKBgQC3\r\n" +
			"9ZUh8z/GYUTOQcEanLnpDDrzH0oRvQFjjwo856CxxRGtzhMaE4SE6gsR6FGxKo2Z\r\n" +
			"CTAhTTLPyrx+fWIbP7c5wTZ9KRwIMIDm5r1lCh6PpbQv9SVpc94Eg2BhMsmaDN0+\r\n" +
			"COMfsR+Bul69hcFN4qfj2vW33puTkh+M3f4i6y+8oQKBgHB3sJnXvUN6g9YCGxp4\r\n" +
			"4zRYeXtHOqJXJpYWtk8vZ1XuLjPIhn9G/fxhgcXVwVkhEdZ6tE/z1kaoVlpcudgR\r\n" +
			"h8lJonlcJBiQlM36gRp266mmR+k3BAFq1e7HWHUpJ/MUxkW7KUhbpoxEWz7Z56vZ\r\n" +
			"x0OGUeInkwMAFR7cZcmY1TvX";
	// 支付宝应用公钥
	public static final String RSA_PUBLIC = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwKZnVn5gOIEhTNkogOhaVwAESnot/VRgTDBGBND73c9sYIoOPlWHxGGcq5oX4Gnof/8VjjlLBtFGvx1BdzxHTh7DFWQFCa9CGJGCiknjPOW93fxlZO+UMwiNVQwVJV/O/RIgVMbzz4MC+A7m0ZMb4RE3GhsYbWu8s74+V8w+3HZSyO/JLqm6wdVU1QdgoY8Wk+mL3WhW24g8NPyH6t+s0bZv97K6TzABULsC1ENfRFF+bgiYmS1PvQ/clol83Vke2QiBuNAFOoLyjYAxEIpIMO6Jp9QLOclMA6jNEccLod36ufX8YFYisT8HClzqnwKYTyyAUTZHQzCDXZ+KFDJGoQIDAQAB";
	//支付宝公钥
	public static final String RSA_TRAN_PUBLIC="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtuue688JYtIN+raZasTzzgNR32SP13ENPbRmW9KRRRD499bO0aVnQqBTSe84bVyLsviUEPaqkkKfKHLVkpP1W6S+cL/PmI79n6qMuNct3GulWD76iILoPVgj112LnmFOWLUJ23rvWDp6J3OHVeo7UAFtPzZtDS5DVxkWwFwA6wP1nx1x9CI41e5zWvvJrGqVssM7MzXYKnp3S1SOI2wdDjDAVyxHFasGbE5vZXHRR0H3R9DgTAqCC3LaqDxY7EUEjUkLC//t/Bq/MWIL6LhMIjiJJfX29o+rqq8s3Lra5RV7TsLt8ROD/U2inZl2zon4bHPvvO8xawCq+unL42qy6wIDAQAB";
	// 微信统一下单notify_url
	public static final String WEIXIN_NOTIFY_URL = URL + "orderSaveWxFk.do";

	// appid
	public static final String WX_APP_ID = "wx3bb7f01999e50165";// yum
	// 商户号
	public static final String WX_MCH_ID = "1368485802";// yum
	// API密钥，在商户平台设置
	public static final String WX_API_KEY = "cd46a2cae4981a4fab91b2c3271052aa";// yum

	public static final String AES_SELLER = "d3a37ab4beccd5328b4666da4149d43e";

	public static final String SALT = "lover1314";
	// 短信验证配置url
//	public static final String SMSURL = "http://sms.10690221.com:9011/hy/";
//	public static final String SMSUID = "80777";
//	public static final String SMSAUTH = new MD5().getMD5ofStr("qyrjqyrj87987");
	//邀请下载注册链接
	public static final String INVITECONNECTION="http://www.xuezhifan.com";
	//用户默认头像
	public static final String DEFAULTAVAER="https://xuezhifantest.oss-cn-beijing.aliyuncs.com/image/2018-11-08/%E9%BB%98%E8%AE%A4.png";
	//用户默认注册的头像
	public static final String DEFAULTREGISTRAVAER="https://xuezhifantest.oss-cn-beijing.aliyuncs.com/image/2018-11-08/%E9%BB%98%E8%AE%A42.png";
	//默认昵称前缀
	public static final String NICKNAME = "小帆用户_";

	public static final String TREASURER="18265438335,15266798273";
}
