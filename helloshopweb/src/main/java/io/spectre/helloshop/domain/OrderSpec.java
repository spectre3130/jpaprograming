package io.spectre.helloshop.domain;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;

/**
 * order specifications
 */
public class OrderSpec {

    public static Specification<Order> memberNameLike(final String memberName) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if(StringUtils.isEmpty(memberName)) return null;
            Join<Order, Member> m = root.join("member", JoinType.INNER);
            return criteriaBuilder.like(m.<String>get("name"), "%" + memberName + "%");
        };
    }

    public static Specification<Order> orderStatusEq(final OrderStatus orderStatus) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if(orderStatus == null) return null;
            return criteriaBuilder.equal(root.get("status"), orderStatus);
        };
    }
}
