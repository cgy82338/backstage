package yc.xuezhifan.schoolbackstage.schooldynamics.updateImage;

public class UpdateImage {

    private String src;
    private String title;

    public UpdateImage(String src, String title) {
        this.src = src;
        this.title = title;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
