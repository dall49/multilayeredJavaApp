package inpt.multilayeredapp.springbootdemo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
@Data @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor @ToString
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Basic
    @Column(name = "surname", nullable = false, length = 50)
    private String surname;

    @Basic
    @Column(name = "birthDate", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "author_book", joinColumns = {
            @JoinColumn(name = "author_id")}, inverseJoinColumns = {
            @JoinColumn(name = "book_id")})
    private Set<Book> books = new HashSet<>();

}