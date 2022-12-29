package com.djoumatch.webserver.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "merchandise")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Merchandise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne
    private Move move;
}
