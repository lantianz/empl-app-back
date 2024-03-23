package com.ltz.emplInfo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author tianzhi
 * @since 2024-03-18
 */
@TableName("empl_news")
public class EmplNews implements Serializable, Comparable<EmplNews> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String newsId;

    private String title;

    private String author;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private LocalDateTime sendTime;

    private String frontImg;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }

    public String getFrontImg() {
        return frontImg;
    }

    public void setFrontImg(String frontImg) {
        this.frontImg = frontImg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "EmplNews{" +
                "id=" + id +
                ", newsId='" + newsId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", sendTime=" + sendTime +
                ", frontImg='" + frontImg + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public int compareTo(EmplNews o) {
        if (o.sendTime.isEqual(this.sendTime)) {
            return 0;
        } else if (o.sendTime.isAfter(this.sendTime)) {
            return 1;
        } else {
            return -1;
        }
    }
}
