package com.ohgiraffers.section01.insert;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.Template.close;

public class MenuDAO {

    // 마이바티스 스타일
    public int insertMenu(Connection con, MenuDTO menu) {

        PreparedStatement pstmt = null;
        int result = 0;

        String query = "INSERT INTO TBL_MENU(MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS)"
                + "VALUES(?, ?, ?, ?)"; // 개행 필요

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menu.getMenuName());
            pstmt.setDouble(2, menu.getMenuPrice());
            pstmt.setDouble(3, menu.getCategoryCode());
            pstmt.setString(4, menu.getOrderableStatus());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }

    public int deleteMenu(Connection con, MenuDTO menu) {
        PreparedStatement pstmt = null;
        int result = 0;

        String query = "DELETE FROM TBL_MENU WHERE MENU_NAME = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menu.getMenuName());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }

    public int updateMenu(Connection con, MenuDTO menu) {
        PreparedStatement pstmt = null;
        int result = 0;

        String query = "UPDATE TBL_MENU SET MENU_PRICE = ? WHERE MENU_NAME = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setDouble(1, menu.getMenuPrice());
            pstmt.setString(2, menu.getMenuName());
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }
    // JPA 스타일
    //public int save() {}
}
