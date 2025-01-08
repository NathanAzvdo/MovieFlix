package dev.movie.Movieflix.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="category")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

}
