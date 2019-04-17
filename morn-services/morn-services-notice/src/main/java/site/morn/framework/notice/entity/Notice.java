package site.morn.framework.notice.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 新闻
 *
 * @author TianGanLin
 * @version 1.0.0, 2017/9/10
 * @since 1.0-SNAPSHOT
 */
@Entity
public class Notice {


  @Id
  @GeneratedValue
  private Long id;                // 主键

  @Column(length = 191, nullable = false)
  private String title;           // 标题

  @Column(length = 1000)
  private String spread;          // 推广介绍(用于预览或微信分享)

  @Column
  private String url;             // 链接

  @Lob
  private String content;         // 内容

  @Column
  private String icon;            // 展示图

  @Column
  private String images;          // 多个展示图

  @Column
  @Temporal(TemporalType.DATE)
  private Date date;              // 发布时间

  @Column
  private Integer plate;          // 板块(用于区分不同性质的文章)

  @Column
  private Integer mark;           // 标记(用于区分不同类型的文章)

  @Column
  private Integer queue;          // 排序(必要时, 用此排序)

  @Column
  private String words;           // 关键字(用作搜索)

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

  public String getSpread() {
    return spread;
  }

  public void setSpread(String spread) {
    this.spread = spread;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getImages() {
    return images;
  }

  public void setImages(String images) {
    this.images = images;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Integer getPlate() {
    return plate;
  }

  public void setPlate(Integer plate) {
    this.plate = plate;
  }

  public Integer getMark() {
    return mark;
  }

  public void setMark(Integer mark) {
    this.mark = mark;
  }

  public Integer getQueue() {
    return queue;
  }

  public void setQueue(Integer queue) {
    this.queue = queue;
  }

  public String getWords() {
    return words;
  }

  public void setWords(String words) {
    this.words = words;
  }
}
