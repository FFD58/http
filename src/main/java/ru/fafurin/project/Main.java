package ru.fafurin.project;
import ru.fafurin.project.domain.PhotoInfoService;
import java.io.IOException;
import java.util.List;

// URL из лекции нерабочий, поэтому использовал api.nasa из прошлых уроков

public class Main {
    public static void main(String[] args) throws IOException {
        PhotoInfoService photoInfoService = new PhotoInfoService();
        List<String> responseList = photoInfoService.getPhotoInfosByTwoDates("2024-01-01", "2024-01-30");
        if (!responseList.isEmpty()) {
            System.out.println(responseList);
        } else System.out.println("Error 404");
    }
}
