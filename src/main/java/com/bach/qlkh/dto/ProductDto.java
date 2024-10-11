package com.bach.qlkh.dto;


import com.bach.qlkh.model.Customer;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    Long id;
    @NotEmpty(message = "Tên sản phẩm không được phép bỏ trống")
    String name;
    @NotEmpty(message = "Mô tả sản phẩm không được phép bỏ trống")
    String description;
    @Min(value = 0, message = "Giá sản phẩm không thể nhỏ hơn 0")
    Long price;
    String imageUrl;

}
