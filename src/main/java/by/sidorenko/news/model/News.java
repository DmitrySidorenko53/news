package by.sidorenko.news.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "news_title", nullable = false)
    private String title;
    @Column(name = "publish_date", nullable = false)
    private Date date;
    @Column(name = "brief", nullable = false)
    private String brief;
    @Column(name = "content", nullable = false)
    private String content;

    public News() {
    }

    public News(String title, Date date, String brief, String content) {
        this.title = title;
        this.date = date;
        this.brief = brief;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
