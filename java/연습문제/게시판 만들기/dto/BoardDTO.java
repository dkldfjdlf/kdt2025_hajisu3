package boardapp.model.dto;

public class BoardDTO {
    private int id;
    private String title;
    private String writer;
    private String content;
    private String date;
    private int viewCount;

    public BoardDTO(int id, String title, String writer, String content, String date, int viewCount) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.date = date;
        this.viewCount = viewCount;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getWriter() { return writer; }
    public void setWriter(String writer) { this.writer = writer; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public int getViewCount() { return viewCount; }
    public void setViewCount(int viewCount) { this.viewCount = viewCount; }
}
