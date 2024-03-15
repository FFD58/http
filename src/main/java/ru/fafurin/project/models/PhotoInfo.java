package ru.fafurin.project.models;

public class PhotoInfo {
    private final String copyright;
    private final String date;
    private final String explanation;
    private final String hdurl;
    private final String media_type;
    private final String service_version;
    private final String title;
    private final String url;

    public PhotoInfo(String copyright, String date, String explanation, String hdurl, String media_type, String service_version, String title, String url) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.media_type = media_type;
        this.service_version = service_version;
        this.title = title;
        this.url = url;
    }
}