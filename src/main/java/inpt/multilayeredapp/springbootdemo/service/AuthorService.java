package inpt.multilayeredapp.springbootdemo.service;

import inpt.multilayeredapp.springbootdemo.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService extends CustomService{

    public Author getByKey(Integer key){
        return authorDao.findByKey(key).get();
    }

    public List<Author> getByName(String name){
        return authorDao.findByName(name);
    }

    public List<Author> gatAll(){
        return authorDao.findAll();
    }

}
