package com.portfolio.price_tracker.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // Nombre del producto
    @Column(length = 1024)
    private String url; // url del prducto que se va a monitorear
    private String currentPrice; // el último precio que se registra -> String por simplicidad.




}
