package com.example.druid.pojo;

public class StatisticOrder {
    private Long id;

    private String source;

    private String actno;

    private String actname;

    private Integer channel;

    private String clue;

    private String starLevel;

    private String saledep;

    private String style;

    private Integer status;

    private String syctimeDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno == null ? null : actno.trim();
    }

    public String getActname() {
        return actname;
    }

    public void setActname(String actname) {
        this.actname = actname == null ? null : actname.trim();
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue == null ? null : clue.trim();
    }

    public String getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(String starLevel) {
        this.starLevel = starLevel == null ? null : starLevel.trim();
    }

    public String getSaledep() {
        return saledep;
    }

    public void setSaledep(String saledep) {
        this.saledep = saledep == null ? null : saledep.trim();
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSyctimeDay() {
        return syctimeDay;
    }

    public void setSyctimeDay(String syctimeDay) {
        this.syctimeDay = syctimeDay == null ? null : syctimeDay.trim();
    }
}