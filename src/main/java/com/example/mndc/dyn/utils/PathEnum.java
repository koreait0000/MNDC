package com.example.mndc.dyn.utils;

public enum PathEnum {
    MY("my"),
    MYCONTENT ("mycontent"),
    TEST ("test");

    private String url;

    PathEnum(String url) {
        this.url = url;
    }

    public String getUrl() {
        return "/" + url;
    }
    public String getRedirectUrl(String... ddd) {
        return "redirect:/" + url;
    }
}
