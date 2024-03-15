package ru.fafurin.project.domain;

import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.fafurin.project.data_sources.NasaApiDataSource;
import ru.fafurin.project.models.PhotoInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PhotoInfoService {
    private final NasaApiDataSource dataSource;

    public PhotoInfoService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/planetary/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        dataSource = retrofit.create(NasaApiDataSource.class);
    }

    public Optional<PhotoInfo> getPhotoInfo() {
        Call<PhotoInfo> photoInfo = dataSource.getDayPhotoInfo();
        Response<PhotoInfo> response;
        try {
            response = photoInfo.execute();
            if (response.body() != null) return Optional.of(response.body());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    public List<String> getPhotoInfosByTwoDates(String startDate, String endDate) {
        Call<List<PhotoInfo>> photoInfos = dataSource.getPhotoInfosByTwoDates(startDate, endDate);
        List<String> responseList = new ArrayList<>();
        try {
            Response<List<PhotoInfo>> response = photoInfos.execute();
            Gson gson = new Gson();
            if (response.body() != null) {
                for (PhotoInfo photoInfo : response.body()) {
                    responseList.add(gson.toJson(photoInfo));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return responseList;
    }
}
