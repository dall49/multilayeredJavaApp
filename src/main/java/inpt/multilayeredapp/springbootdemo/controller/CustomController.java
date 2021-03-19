package inpt.multilayeredapp.springbootdemo.controller;

import inpt.multilayeredapp.springbootdemo.service.AuthorService;
import inpt.multilayeredapp.springbootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Validated
@Transactional(readOnly = true)
public abstract class CustomController {

    @Autowired
    protected AuthorService authorService;

    @Autowired
    protected BookService bookService;

}
