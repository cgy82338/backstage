package yc.xuezhifan.schoolbackstage.share.utils;

/**
 * 通过数字判断家长与孩子的关系
 */
public class ChildRelationUtil {

    public static String findChildRelationByNumber(Integer number) {
        switch (number) {
            case 1:
                return "母亲";
            case 2:
                return "父亲";
            case 3:
                return "爷爷";
            case 4:
                return "奶奶";
            case 5:
                return "外公";
            case 6:
                return "外婆";
            case 7:
                return "叔叔";
            case 8:
                return "阿姨";
            case 9:
                return "其他";
        }
        return "母亲";
    }
}
