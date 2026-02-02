package org.mehedi.ordermanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mehedi.ordermanagementsystem.model.OrderType;
import org.mehedi.ordermanagementsystem.model.PaymentMethod;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private OrderType type;
    private PaymentMethod paymentMethod;
    private Integer tableNumber;
    private Double billAmount;
    private String instruction;
}
