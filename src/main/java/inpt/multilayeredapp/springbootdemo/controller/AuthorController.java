package inpt.multilayeredapp.springbootdemo.controller;

import inpt.multilayeredapp.springbootdemo.dto.AuthorDto;
import inpt.multilayeredapp.springbootdemo.dto.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController extends CustomController{

     @Autowired
     AuthorMapper authorMapper;

    @GetMapping("v1/")
    public ResponseEntity<List<AuthorDto>> getAll() {
        return new ResponseEntity(
                authorMapper.authorsToAuthorDtos(authorService.gatAll()),
                HttpStatus.OK
        );
    }

    @GetMapping("v1/{id}")
    public ResponseEntity<AuthorDto> get(@PathVariable(value = "id") Integer id)  {
        return new ResponseEntity(
                authorMapper.authorToAuthorDto(authorService.getByKey(id)),
                HttpStatus.OK);
    }


    @GetMapping("v1/find")
    public ResponseEntity<List<AuthorDto>> findByName(
            @RequestParam(value = "name", required = true) String name) {
        return new ResponseEntity(
                authorMapper.authorsToAuthorDtos(authorService.getByName(name)),
                HttpStatus.OK);
    }

}
