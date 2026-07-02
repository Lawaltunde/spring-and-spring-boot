package com.amigoscode.book;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    // Inject your BookRepository here via constructor injection

    // TODO: 3 - Create a GET endpoint mapped to "/api/v1/books"
    //  that returns all books from the database
    //  Hint: use the repository's findAll() method

    // TODO: 4 - Create a GET endpoint mapped to "/api/v1/books/{id}"
    //  that returns a single book by its ID
    //  Hint: use the repository's findById() method
    //  Return 404 if the book is not found

    // TODO: 5 - Create a POST endpoint mapped to "/api/v1/books"
    //  that accepts a Book in the request body and saves it to the database
    //  Hint: use the repository's save() method

    // TODO: 6 - Create a DELETE endpoint mapped to "/api/v1/books/{id}"
    //  that deletes a book by its ID
    //  Hint: use the repository's deleteById() method

}
