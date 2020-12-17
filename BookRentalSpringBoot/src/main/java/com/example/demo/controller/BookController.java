package com.example.demo.controller;

import com.example.demo.models.BookModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {


    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/getbook/{bookTitle}")
    public List<BookModel> getBook(@PathVariable String bookTitle) {
        //check if book title contains empty spaces
        if(bookTitle.contains(" ")){
            //replace empty space with _
            bookTitle = bookTitle.replaceAll("\\s", "_" );
        }
        System.out.println(bookTitle);

        BookModel book;
        //url for api call
        String url = "https://openlibrary.org/search.json?q=" + bookTitle;
        System.out.println(url);

        //assign value from api call to books
        String books = restTemplate.getForObject(url, String.class);

        ArrayList<BookModel> bookList = null;
        try {
            //create json object from api call
            JSONObject jsonObject = new JSONObject(books);

            //create json array from json object at docs attribute
            JSONArray jsonArray = jsonObject.getJSONArray("docs");
            System.out.println("json to string: " + jsonArray.toString());


            bookList = new ArrayList<>(jsonArray.length());

            for(int i=0; i < jsonArray.length(); i++) {
                book = new BookModel();

                System.out.println(" index " + i + ": " + jsonArray.get(i));

                //get current object from array
                JSONObject objIndex = (JSONObject) jsonArray.get(i);

                // set book title
                book.setTitle(objIndex.getString("title"));

                //get current index of array
                //check if first_publish_year is present
                //assigns it to books publish year
                if(jsonArray.getJSONObject(i).has("first_publish_year")) {
                    book.setPublishYear(Long.parseLong(objIndex.getString("first_publish_year")));
                }
                //else check if publish_year is present
                //assigns it to books publish year
                else if (jsonArray.getJSONObject(i).has("publish_year")) {
                    book.setPublishYear(Long.parseLong(objIndex.getJSONArray("publish_year").getString(0)));
                }
                //else
                //assigns books publish year to 0
                else {
                    book.setPublishYear(0);
                }

                //get current index of array
                //check if author_name is present
                //assigns it to author
                if (jsonArray.getJSONObject(i).has("author_name"))
                    book.setAuthor(objIndex.getJSONArray("author_name").get(0).toString());
                //else no author found
                else
                    book.setAuthor("no author found");


                //get current index of array
                //check if publisher is present
                //assigns it to books publish
                if(jsonArray.getJSONObject(i).has("publisher"))
                    book.setPublisher(objIndex.getJSONArray("publisher").get(0).toString());
                //else no publisher found
                else
                    book.setPublisher("no publisher found");
                bookList.add(book);
            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        return bookList;
    }

}
