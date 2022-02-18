package com.phoenixStore.data.dto;


import com.phoenixStore.data.models.QuantityOp;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartUpdateDto {

    private Long userId;

    private Long itemId;

    private QuantityOp quantityOp;
}
