package site.liberumscientia.postshandler.dto;

public class ForumPostRequest {
    private String title;
    private String content;

    // Getters e Setters

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        title = this.title;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        content = this.content;
    }
}
