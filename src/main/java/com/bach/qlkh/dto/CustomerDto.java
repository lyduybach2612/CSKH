package com.bach.qlkh.dto;

import com.bach.qlkh.model.CareDiary;
import com.bach.qlkh.model.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    Long id;
    @NotEmpty(message = "Tên không được để trống")
    String name;
    @NotEmpty(message = "Địa chỉ không được để trống")
    String address;
    @NotEmpty(message = "Số điện thoại không được để trống")
    String phoneNumber;
    @NotEmpty(message = "Email không được để trống")
    String email;
    @NotEmpty(message = "Tên tài khoản không được để trống")
    String username;
    @NotEmpty(message = "Mật khẩu không được để trống")
    @Size(min = 6, message = "Mật khẩu phải có ít nhất 6 kí tự")
    String password;
    LocalDate dateOfBirth;
    String gender;
    List<CareDiary> careDiaries;

}
