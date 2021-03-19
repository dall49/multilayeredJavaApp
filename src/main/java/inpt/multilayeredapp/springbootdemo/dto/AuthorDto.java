package inpt.multilayeredapp.springbootdemo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class AuthorDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("birthDate")
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date birthDate;

    @JsonProperty("books")
    private List<BookDto> books = new ArrayList<>();

}
