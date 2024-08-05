package com.ohgiraffers.persistence.section03.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.persistence.EntityManager;

public class EntityLifecycleTests {

    /* 엔티티 생명주기
    *   비영속(new/transient) : 영속성 컨텍스트와 전혀 관계가 없는 상태
    *   영속(managed) : 영속성 컨텍스트에 저장된 상태
    *   준영속(detached) : 영속성 컨텍스트에 저장되었다가 분리된 상태
    *   삭제(removed) : 삭제된 상태
    * */
    // 영속성 컨텍스트?
    // 엔티티 매니저가 엔티티 객체를 저장하는 공간으로 엔티티 객체를 보관하고 관리한다.
    // (엔티티 매니저가 생성될 때 하나의 영속성 컨텍스트가 만들어진다.)

    private EntityLifecycle lifecycle;

    @BeforeEach
    void setUp() {
        lifecycle = new EntityLifecycle();
    }

    @DisplayName("비영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void testTransient(int menuCode) {

        Menu foundMenu = lifecycle.findMenuByMenuCode(menuCode);

        Menu newMenu = new Menu(
                menuCode,
                foundMenu.getMenuName(),
                foundMenu.getMenuPrice(),
                foundMenu.getCategoryCode(),
                foundMenu.getOrderableStatus()
        );

        Assertions.assertNotEquals(newMenu, foundMenu);
    }

    @DisplayName("다른 엔티티 매니저가 관리하는 엔티티의 영속성 조회 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testManagedOtherEntityManager(int menuCode) {

        Menu menu1 = lifecycle.findMenuByMenuCode(menuCode);
        Menu menu2 = lifecycle.findMenuByMenuCode(menuCode);

        Assertions.assertNotEquals(menu1, menu2);
    }

    @DisplayName("같은 엔티티 매니저가 관리하는 엔티티 영속성 조회 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testManagedSameEntityManager(int menuCode) {

        EntityManager manager = EntityManagerGenerator.getEntityManager();

        Menu menu1 = manager.find(Menu.class, menuCode);
        Menu menu2 = manager.find(Menu.class, menuCode);

        Assertions.assertEquals(menu1, menu2);
    }
}
