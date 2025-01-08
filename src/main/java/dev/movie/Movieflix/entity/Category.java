package dev.movie.Movieflix.entity;


import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(name="category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

}
