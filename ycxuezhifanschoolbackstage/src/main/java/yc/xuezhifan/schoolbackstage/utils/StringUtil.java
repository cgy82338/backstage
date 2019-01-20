package yc.xuezhifan.schoolbackstage.utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author liuke
 * @date   2018年8月4日
 *
 */
public class StringUtil {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isEmail(String str) {
        String pattern1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(pattern1);
        Matcher mat = pattern.matcher(str);
        return !mat.find();
    }

    /**
     * 取出str字符串中的一个img标签
     */
    public static String selsrcSingle(String str) {
        String ss = "";
        Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
        //<img[^<>]*src=[\'\"]([0-9A-Za-z.\\/]*)[\'\"].(.*?)>");
        Matcher m = p.matcher(str);
        while (m.find()) {
            ss = m.group(1);
        }
        return ss;
    }

    /**
     * 判断是否为手机号
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 校验是否为正整数
     * @param intStr
     * @return
     */
    public static final boolean isValidInteger(String intStr) {
        return (intStr == null) ? false : intStr.matches("\\d+");
    }

    /**
     * 查询文件夹下面所有文件名
     * path:文件夹地地址  例："C://Documents and Settings//yinxm//デスクトップ//TestFile"
     * */
    public static String[] getFile(String path){
        // get file list where the path has
        File file = new File(path);
        // get the folder list
        File[] array = file.listFiles();
        String[] arrayTitle = new String[array.length];
        for(int i=0;i<array.length;i++){
            if(array[i].isFile()){
                // only take file name
//                System.out.println("^^^^^" + array[i].getName());
                arrayTitle[i] = array[i].getName();
                // take file path and name
//                System.out.println("#####" + array[i]);
                // take file path and name
//                System.out.println("*****" + array[i].getPath());
            }else if(array[i].isDirectory()){
                getFile(array[i].getPath());
            }
        }
        return arrayTitle;
    }
    /**
     * 删除某个文件夹下的所有文件夹和文件
     */
        public static boolean deletefile(String delpath)
                        throws FileNotFoundException, IOException {
                try {
                        File file = new File(delpath);
                        if (!file.isDirectory()) {
//                                System.out.println("不是文件�?);
                                file.delete();
                        } else if (file.isDirectory()) {
                                //System.out.println("2");
                                String[] filelist = file.list();
                                for (int i = 0; i < filelist.length; i++) {
                                        File delfile = new File(delpath + "\\" + filelist[i]);
                                        if (!delfile.isDirectory()) {
//                                                System.out.println("path=" + delfile.getPath());
//                                                System.out.println("absolutepath="
//                                                                + delfile.getAbsolutePath());
//                                                System.out.println("name=" + delfile.getName());
                                                delfile.delete();
//                                                System.out.println("删除文件成功");
                                        } else if (delfile.isDirectory()) {
                                                deletefile(delpath + "\\" + filelist[i]);
                                        }
                                }
//                                file.delete();//这个是删除该文件夹的
                        }
                } catch (FileNotFoundException e) {
//                        System.out.println("deletefile()   Exception:" + e.getMessage());
                }
                return true;
        }


    /**
     *
     * 基本功能：替换指定的标签
     * @author linshutao
     * @param str
     * @param beforeTag   要替换的标签
     * @param tagAttrib   要替换的标签属�?�?
     * @param startTag    新标签开始标�?
     * @param endTag   新标签结束标�?
     * @return String
     */
    public   static String replaceHtmlTag(String str, String beforeTag,
                                          String tagAttrib, String startTag, String endTag) {
        //  String regxpForTag = "<//s*" + beforeTag + "//s+([^>]*)//s*>" ;
        String regxpForTag = "<//s*" + beforeTag + "//s+([^>]*)//s*" ;
        String regxpForTagAttrib = tagAttrib  ;
        //Pattern.CASE_INSENSITIVE 忽略大小�?
        Pattern patternForTag = Pattern.compile (regxpForTag,Pattern. CASE_INSENSITIVE );
        Pattern patternForAttrib = Pattern.compile (regxpForTagAttrib,Pattern. CASE_INSENSITIVE );
        Matcher matcherForTag = patternForTag.matcher(str);
        StringBuffer sb = new StringBuffer ();
        boolean result = matcherForTag.find();
        // 循环找出每个 img 标签
        while (result) {
            StringBuffer sbreplace = new StringBuffer( "<img " );
            Matcher matcherForAttrib = patternForAttrib.matcher(matcherForTag
                    .group(1));
            if (matcherForAttrib.find()) {
                matcherForAttrib.appendReplacement(sbreplace, startTag
                        + matcherForAttrib.group(1) + endTag);
            }
            matcherForAttrib.appendTail(sbreplace);
            matcherForTag.appendReplacement(sb, sbreplace.toString());
            result = matcherForTag.find();
        }
        matcherForTag.appendTail(sb);
        return sb.toString();
    }
    
    /**
     * 基本功能：list集合转字符串
     * @param list �?��转字符串的集�?
     * @param separator 字符串中的分隔符
     * @return String
     */
    public static String listToString(@SuppressWarnings("rawtypes") List list, char separator){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<list.size(); i++){
			sb.append(list.get(i)).append(separator);
		}
		return sb.toString().substring(0,sb.toString().length()-1);
	}

}
