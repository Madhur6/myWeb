package com.hostel.myHostel.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String location;
    private double price;
    private String imageUrl;
    private String category;  // Apartment, House, Commercial, etc.

    @ManyToOne
    private User owner;
}
