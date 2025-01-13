package dev.movie.Movieflix.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(name="release_date")
    private LocalDate releaseDate;

    private Double rating;

    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(name="movie_category", joinColumns = @JoinColumn(name="movie_id"),
    inverseJoinColumns = @JoinColumn(name="category_id"))
    private List<Category> categories;

    @ManyToMany
    @JoinTable(name="movie_streaming", joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns = @JoinColumn(name="streaming_id"))
    private List<Streaming> streamings;
}
