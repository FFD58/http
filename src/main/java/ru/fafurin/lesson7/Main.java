package ru.fafurin.lesson7;
// Урок 7. Retrofit

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
// 1. Что такое Retrofit?
// Ответ: Retrofit - это библиотека-клиент для Java. Позволяет получать и загружать JSON или другие данные через веб-сервис на основе REST


// URL из лекции нерабочий, поэтому использовал api.nasa из прошлых уроков


// 2. Приведите сценарий его использования?

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/planetary/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NasaApiService service = retrofit.create(NasaApiService.class);
        Call<PhotoDto> photo = service.getDayPhoto();

        Response<PhotoDto> response = photo.execute();
        System.out.println(response.body());
    }
}

interface NasaApiService {
    @GET("apod?api_key=DEMO_KEY")
    Call<PhotoDto> getDayPhoto();
}

class PhotoDto {
    private final String copyright;
    private final String date;
    private final String explanation;
    private final String hdurl;
    private final String media_type;
    private final String service_version;
    private final String title;
    private final String url;

    public PhotoDto(String copyright, String date, String explanation, String hdurl, String media_type, String service_version, String title, String url) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.media_type = media_type;
        this.service_version = service_version;
        this.title = title;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "copyright='" + copyright + '\'' +
                ", date='" + date + '\'' +
                ", explanation='" + explanation + '\'' +
                ", hdurl='" + hdurl + '\'' +
                ", media_type='" + media_type + '\'' +
                ", service_version='" + service_version + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
