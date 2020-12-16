package com.example.demo.controller;

import com.example.demo.models.BookModel;

import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BookController {

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/getbook")
    public String getBook() throws JSONException {

        BookModel book = new BookModel();
        String bookList = restTemplate.getForObject("https://openlibrary.org/search.json?q=clean_code", String.class);
        JSONObject jsonObject = new JSONObject(bookList).getJSONArray("docs").getJSONObject(0);

        book.setTitle(jsonObject.getString("title"));
        book.setPublishYear(Long.parseLong(jsonObject.getString("first_publish_year")));
        if(jsonObject.has("author_name"))
            book.setAuthor(jsonObject.getJSONArray("author_name").get(0).toString());
        else
            book.setAuthor("no author found");
        book.setPublisher(jsonObject.getJSONArray("publisher").get(0).toString());

        return book.toString();
    }

}
