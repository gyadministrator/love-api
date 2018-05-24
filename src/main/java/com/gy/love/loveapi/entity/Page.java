package com.gy.love.loveapi.entity;

/**
 * @author ran
 * @Description: ${todo}
 * @date 2018/5/2119:35
 */
public class Page {
    private String column="id";
    private String keyword="";
    private int page=1;
    private int pageSize=10;
    private int isNoticed;

    public int getIsNoticed() {
        return isNoticed;
    }

    public void setIsNoticed(int isNoticed) {
        this.isNoticed = isNoticed;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
