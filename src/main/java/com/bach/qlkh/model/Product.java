package com.bach.qlkh.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    Long price;
    @CreationTimestamp
    LocalDateTime createdTime;
    @UpdateTimestamp
    LocalDateTime updateTime;
    @ManyToOne()
    @JoinColumn(name = "order_id")
    Order order;

}
