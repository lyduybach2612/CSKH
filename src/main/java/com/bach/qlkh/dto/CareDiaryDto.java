package com.bach.qlkh.dto;

import com.bach.qlkh.model.Customer;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CareDiaryDto {

    Long id;
    @NotEmpty(message = "Vấn đề đang gặp không được phép bỏ trống")
    String title;
    @NotEmpty(message = "Nội dung vấn đề không được phép bỏ trống")
    String content;
    Boolean state;
    Customer customer;

}
