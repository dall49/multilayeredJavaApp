package inpt.multilayeredapp.springbootdemo.dto.mapper;

import inpt.multilayeredapp.springbootdemo.dto.BookDto;
import inpt.multilayeredapp.springbootdemo.model.Author;
import inpt.multilayeredapp.springbootdemo.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {

    public abstract BookDto bookToBookDto(Book book);
    public abstract List<BookDto> booksToBookDtos(List<Book> books);
}
