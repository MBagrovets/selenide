package com.itacademy.modelRetrofit.listusers;

import java.util.List;

public class Root {

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<Data> data;
    private Support123 support;

    public Root(int page, int per_page, int total, int total_pages, List<Data> data, Support123 support) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
        this.support = support;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public Support123 getSupport() {
        return support;
    }

    public void setSupport(Support123 support) {
        this.support = support;
    }
}



