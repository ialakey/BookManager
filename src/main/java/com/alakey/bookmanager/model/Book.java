package com.alakey.bookmanager.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vendorCode;

    private String title;

    @Column(name = "book_year", nullable = false)
    private int year;

    private String brand;

    private int stock;

    private double price;
}