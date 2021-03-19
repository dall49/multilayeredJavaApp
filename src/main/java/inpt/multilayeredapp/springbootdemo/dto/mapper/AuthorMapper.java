package inpt.multilayeredapp.springbootdemo.dto.mapper;

import inpt.multilayeredapp.springbootdemo.dto.AuthorDto;
import inpt.multilayeredapp.springbootdemo.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorMapper {

    AuthorDto authorToAuthorDto(Author author);
    List<AuthorDto> authorsToAuthorDtos(List<Author> authors);

}
