package yc.xuezhifan.schoolbackstage.utils;

import java.util.List;

/**
 * 分页类
 */
public class Page {
    private int code;//状态码
    private String msg;//
    private int count;//总记录数
    private List data;//数据集合

    public Page() {
    }

    public Page(int code, String msg, int count, List data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
