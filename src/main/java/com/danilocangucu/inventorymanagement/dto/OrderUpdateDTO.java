package com.danilocangucu.inventorymanagement.dto;

import com.danilocangucu.inventorymanagement.entity.OrderItem;
import com.danilocangucu.inventorymanagement.util.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdateDTO {
    private List<OrderItem> items;
    private OrderStatus status;
    private Date orderDate;
}
