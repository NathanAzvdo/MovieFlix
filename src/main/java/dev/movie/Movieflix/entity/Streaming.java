package dev.movie.Movieflix.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(name="streaming")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Streaming {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;


}
