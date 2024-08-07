package com.ohgiraffers.association.section02.onetomany;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity // 한페이지에 entity 2개는 같은 라이프사이클이 아닌 이상 지양
@Table(name="TBL_ORDER_MENU")
public class OrderMenu {

    @EmbeddedId
    private OrderMenuPk orderMenuPk;

    @Column(name="ORDER_AMOUNT")
    private int orderAmount;

    public OrderMenu() {}

    public OrderMenu(OrderMenuPk orderMenuPk, int orderAmount) {
        this.orderMenuPk = orderMenuPk;
        this.orderAmount = orderAmount;
    }

    public OrderMenuPk getOrderMenuPk() {
        return orderMenuPk;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    @Override
    public String toString() {
        return "OrderMenu{" +
                "orderMenuPk=" + orderMenuPk +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
