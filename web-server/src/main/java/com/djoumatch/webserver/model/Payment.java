package com.djoumatch.webserver.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float amount;
    @OneToOne
    private Move move;
    @ManyToOne
    private Payer payer;
}
