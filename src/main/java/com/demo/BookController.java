package com.demo;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.List;
import javax.validation.Valid;
import java.util.UUID;

@Controller("v1")
public class BookController {

    @Post("book")
    public BookSaved save(@Valid @Body Book book) {
        BookSaved bookSaved = new BookSaved();
        bookSaved.setName(book.getName());
        bookSaved.setIsbn(UUID.randomUUID().toString());
        return bookSaved;
    }

    @Get("books")
    public HttpResponse<List<String>> getBooks() {
        return HttpResponse.ok(List.of("test1", "test2", "test3"));
    }
}
