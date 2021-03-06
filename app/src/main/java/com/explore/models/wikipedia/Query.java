package com.explore.models.wikipedia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Query {

    private Map<String, PageDescription> pages;

    public void setPages(Map<String, PageDescription> pages) {
        this.pages = pages;
    }

    public Map<String, PageDescription> getPages() {
        return pages;
    }

}
