package io.spectre.helloshop.domain;

import io.spectre.helloshop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_ITEM")
@Getter
@Setter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;

    private int count;

    // ===== Business Logic =====
    /**
     * 주문상품 생성
     * 상품의 재고는 주문수량만큼 차감한다.
     * @param item 상품
     * @param orderPirce 상품가격
     * @param count 주문수량
     * @return 주문상품
     */
    public static OrderItem createOrderItem(Item item, int orderPirce, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPirce);
        orderItem.setCount(count);

        item.removeStock(count);
        return orderItem;
    }

    /**
     * 주문상품 취소
     * 상품에 재고를 취소된만큼 쌓는다.
     */
    public void cancel() {
        getItem().addStock(count);
    }

    /**
     * 주문상품 가격 계산
     * 주문상품의 단가를 수량만큼 계산한다.
     * @return 주문상품 가격
     */
    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }



}
