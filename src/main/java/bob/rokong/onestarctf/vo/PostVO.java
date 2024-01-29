package bob.rokong.onestarctf.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import bob.rokong.onestarctf.code.PostCategory;

public class PostVO {
    private int pid;
    private PostCategory postCategory;
    private String title;
    private int authorUid;
    private String username;
    private Date date;
    private String content;
    private boolean isPublic;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public PostCategory getPostCategory() {
        return postCategory;
    }

    public String getCategory() {
        return postCategory.name();
    }

    public void setCategory(String category) {
        this.postCategory = PostCategory.fromString(category);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorUid() {
        return authorUid;
    }

    public void setAuthorUid(int authorUid) {
        this.authorUid = authorUid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public String getDatetime() {
        return (new SimpleDateFormat("yyyyMMddHHmmss")).format(date);
    }

    public void setDatetime(String datetime) {
        Date d;
        try {
            d = (new SimpleDateFormat("yyyyMMddHHmmss")).parse(datetime);
        } catch (ParseException e) {
            d = new Date();
        }
        this.date = d;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public String getPublicYn() {
        return isPublic ? "Y" : "N";
    }

    public void setPublicYn(String publicYn) {
        this.isPublic = "Y".equals(publicYn);
    }

    @Override
    public String toString() {
        return "PostVO{" +
                "pid=" + pid +
                ", category=" + getCategory() +
                ", title='" + title + '\'' +
                ", authorUid=" + authorUid +
                ", datetime=" + getDatetime() +
                ", content='" + content + '\'' +
                ", publicYn=" + getPublicYn() +
                '}';
    }
}
