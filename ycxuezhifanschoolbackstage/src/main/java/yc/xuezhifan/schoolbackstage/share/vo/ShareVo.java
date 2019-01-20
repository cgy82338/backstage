package yc.xuezhifan.schoolbackstage.share.vo;
/**
 * 关注人的信息
 */
public class ShareVo {
    private String id;//被关注孩子的id
    private String childname;//孩子的姓名
    private String username;//关注人的真实姓名
    private Integer relation;//关注人与孩子的关系
    private String phone;//关注人的手机号

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getChildname() {
        return childname;
    }

    public void setChildname(String childname) {
        this.childname = childname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
