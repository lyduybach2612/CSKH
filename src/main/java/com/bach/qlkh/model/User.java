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
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String address;
    String phoneNumber;
    String email;
    LocalDate dateOfBirth;
    Boolean gender;
    @CreationTimestamp
    LocalDateTime createdDate;
    @UpdateTimestamp
    LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "manage_id")
    Manager manager;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY)
    List<CareDiary> careDiaries;

}
