package inpt.multilayeredapp.springbootdemo.service;

import inpt.multilayeredapp.springbootdemo.model.Author;
import inpt.multilayeredapp.springbootdemo.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends CustomService{

    public Book getByKey(Integer key){
        return bookDao.findByKey(key).get();
    }

    public List<Book> getByTitle(String title){
        return bookDao.findByTitle(title);
    }

    public List<Book> gatAll(){
        return bookDao.findAll();
    }

}
