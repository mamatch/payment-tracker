package com.djoumatch.webserver.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "move")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Move {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Supplier supplier;
    @ManyToOne
    private Customer customer;
    @OneToMany
    private List<Merchandise> merchandises;
    private Date departureDate;
    private Date estimatedArrivalDate;
    private Date effectiveArrivalDate;
    @OneToOne
    private Payment payment;
}
