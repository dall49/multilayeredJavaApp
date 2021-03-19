package inpt.multilayeredapp.springbootdemo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BookDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("releaseDate")
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date releaseDate;
}
