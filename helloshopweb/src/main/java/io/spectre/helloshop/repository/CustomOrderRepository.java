package io.spectre.helloshop.repository;

import io.spectre.helloshop.domain.Order;
import io.spectre.helloshop.domain.OrderSearch;

import java.util.List;

public interface CustomOrderRepository {

    public List<Order> search(OrderSearch orderSearch);
}
