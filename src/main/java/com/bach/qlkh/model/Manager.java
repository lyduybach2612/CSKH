package com.bach.qlkh.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Entity
@Table(name = "managers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String managerName;
    String password;
    String email;
    @OneToMany(mappedBy = "manager",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY)
    List<User> users;

}
