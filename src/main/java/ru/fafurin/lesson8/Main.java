package ru.fafurin.lesson8;
// Урок 8. GSON

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {

// 1. Что такое GSON?
// 2. Для чего он используется?
        // Ответ: GSON - библиотека Гугл для сериализации любого объекта в формат json и десериализации json-данных в объект

// 3. Приведите пример любого JSON запроса?
//        {
//            "some_entity": {
//                "some_field": "some data",
//                "some_field": "some data",
//                "some_field": "some data",
//                "some_field": "some data",
//                "some_field": "some data",
//                "some_field": "some data",
//                "some_field": "some data",
//                "some_field": "some data",
//            }
//        }





        Gson gson = new Gson();
        PhotoDto dto = new PhotoDto(
                "Dave Doctor",
                "2024-03-15",
                "Big, beautiful spiral galaxy NGC 1055 is a dominant member of a small galaxy group a mere 60 million",
                "https://apod.nasa.gov/apod/image/2403/Image133k_n1055.jpg",
                "image",
                "v1",
                "Portrait of NGC 1055",
                "https://apod.nasa.gov/apod/image/2403/Image133k_n1055_1024.jpg");

        String result = gson.toJson(dto);
        System.out.println(result);

        PhotoDto photoDto = gson.fromJson(result, PhotoDto.class);
        System.out.println(photoDto);
    }

   static class PhotoDto {
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
}
