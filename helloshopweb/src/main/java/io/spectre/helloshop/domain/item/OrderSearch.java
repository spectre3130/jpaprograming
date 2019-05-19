package io.spectre.helloshop.domain.item;

import io.spectre.helloshop.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {

    private String memberName;

    private OrderStatus orderStatus;

}
