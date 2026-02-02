package org.mehedi.ordermanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name="`orders`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private OrderType type;
    private LocalDateTime orderTime;
    private List<LocalDateTime> updatedTime;
    private PaymentMethod paymentMethod;
    private int tableNumber;
    private double billAmount;
    private String instruction;
}
