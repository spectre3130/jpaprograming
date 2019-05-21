package io.spectre.helloshop.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specifications;

import static io.spectre.helloshop.domain.OrderSpec.memberNameLike;
import static io.spectre.helloshop.domain.OrderSpec.orderStatusEq;
import static org.springframework.data.jpa.domain.Specifications.where;

@Getter
@Setter
public class OrderSearch {

    private String memberName;

    private OrderStatus orderStatus;

    public Specifications<Order> toSpecification() {
        return where(memberNameLike(memberName))
                .and(orderStatusEq(orderStatus));
    }

}
