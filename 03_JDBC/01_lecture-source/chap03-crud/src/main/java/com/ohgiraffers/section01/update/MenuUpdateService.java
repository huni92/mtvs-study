package com.ohgiraffers.section01.update;

import com.ohgiraffers.model.dto.MenuDTO;
import com.ohgiraffers.section01.insert.MenuDAO;

import java.sql.Connection;

import static com.ohgiraffers.common.Template.*;


// Service
// 주 역할 : 트랜젝션 담당
// 하나의 트랜젝션은 하나의 Connection을 가진다.
public class MenuUpdateService {

    public boolean updateMenu(MenuDTO menu) {

        Connection con = getConnection();

        MenuDAO menuDAO = new MenuDAO();
        int result = menuDAO.updateMenu(con, menu);

        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        return result > 0;
    }
}
