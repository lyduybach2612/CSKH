package com.bach.qlkh.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "customer")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String name;
    String address;
    String phoneNumber;
    String email;
    LocalDate dateOfBirth;
    String gender;
    @CreationTimestamp
    LocalDateTime createdDate;
    @UpdateTimestamp
    LocalDateTime updatedDate;


    @OneToMany(mappedBy = "customer",
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY)
    List<CareDiary> careDiaries;

    @OneToMany(mappedBy = "customer")
    List<Order> orders;

}
