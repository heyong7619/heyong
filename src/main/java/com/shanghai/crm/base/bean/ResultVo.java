package com.shanghai.crm.base.bean;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class ResultVo<T> {
    /*private int page;
    private int pageSize;
    private int totalPages;
    private long totalRows;
    private List<T> dataList;*/

    private PageInfo<T> pageInfo;

    public PageInfo<T> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<T> pageInfo) {
        this.pageInfo = pageInfo;
    }
}
