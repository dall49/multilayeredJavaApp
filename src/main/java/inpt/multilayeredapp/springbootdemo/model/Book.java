package inpt.multilayeredapp.springbootdemo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
@Data @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor @ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Basic
    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Basic
    @Column(name = "releaseDate", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
    private Set<Author> authors = new HashSet<>();

}
