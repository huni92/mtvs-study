package com.ohgiraffers.section02.preparedstatement;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.ohgiraffers.common.Template.close;
import static com.ohgiraffers.common.Template.getConnection;

public class Application2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String empName = sc.next();
        // employee 테이블에서 '중' 이 이름에 포함된 사원을 조회하세요 (중 이라고 하는 글자를 스캐너로 입력)
        // 단, List<EmployeeDTO>에 담아서 출력하세요

        Connection con = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<EmployeeDTO> empList = null;

        try {
            String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_NAME LIKE '%중%' ";
            pstmt = con.prepareStatement(query);
//            pstmt.setString(1, empName);
            empList = new ArrayList<>();

            rset = pstmt.executeQuery();

            while (rset.next()) {

                EmployeeDTO row = new EmployeeDTO();
                row.setEmpId(rset.getString("EMP_ID"));
                row.setEmpName(rset.getString("EMP_NAME"));

                empList.add(row);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
            close(pstmt);
            close(rset);
        }

        // -----------------------------------
        empList.forEach(System.out::println);
    }
}
