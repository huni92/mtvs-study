package com.ohgiraffers.section01.update;

import com.ohgiraffers.model.dto.MenuDTO;
import com.ohgiraffers.section01.insert.MenuDAO;

import java.util.Scanner;

import static java.awt.SystemColor.menu;

public class Application {

    public static void main(String[] args) {
        MenuDTO menu = new MenuDTO();
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 메뉴의 이름을 입력하세요 : ");
        String menuName = sc.nextLine();
        sc.nextLine();
        System.out.print("가격입력 : ");
        int price = sc.nextInt();
//        System.out.print("수정하고 싶은 컬럼명을 입력하세요 : ");
//        String columnName = sc.nextLine();
//        sc.nextLine();
//        System.out.print("수정하고 싶은 값을 입력하세요 : ");
//        int menuCode = sc.nextInt();

        menu.setMenuName(menuName);
        menu.setMenuPrice(price);
//        menu.setColumnName(columnName);
//        menu.setNumValue(menuCode);

        MenuUpdateService menuUpdateService = new MenuUpdateService();
        if (menuUpdateService.updateMenu(menu)) {
            System.out.println("메뉴 수정에 성공하셨습니다!");
        } else {
            System.out.println("메뉴 수정에 실패하셨습니다.");
        }
    }
}
