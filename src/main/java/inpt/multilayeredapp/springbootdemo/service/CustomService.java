package inpt.multilayeredapp.springbootdemo.service;


import inpt.multilayeredapp.springbootdemo.dao.AuthorDao;
import inpt.multilayeredapp.springbootdemo.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public abstract class CustomService {

    @Autowired
    protected AuthorDao authorDao;

    @Autowired
    protected BookDao bookDao;
}
