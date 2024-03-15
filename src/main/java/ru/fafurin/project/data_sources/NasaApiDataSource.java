package ru.fafurin.project.data_sources;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.fafurin.project.models.PhotoInfo;

import java.util.List;

public interface NasaApiDataSource {
    @GET("apod?api_key=DEMO_KEY")
    Call<PhotoInfo> getDayPhotoInfo();

    @GET("apod?api_key=DEMO_KEY")
    Call<List<PhotoInfo>> getPhotoInfosByTwoDates(@Query("start_date") String startDate, @Query("end_date") String endDate);
}
