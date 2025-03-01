package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {
    public List<MenuDTO> findAllMenus(SqlSession sqlSession) {

        return sqlSession.selectList("MenuMapper.findAllMenus"); // 여러 행 조회 selectList
    }

    public MenuDTO findMenuByMenuCode(SqlSession sqlSession, int menuCode) {

        return sqlSession.selectOne("MenuMapper.findMenuByMenuCode", menuCode); // 1개행 조회 selectOne
    }

    public int registMenu(SqlSession sqlSession, MenuDTO menu) {

        return sqlSession.insert("MenuMapper.registMenu", menu);
    }

    public int modifyMenu(SqlSession sqlSession, MenuDTO menu) {

        return sqlSession.update("MenuMapper.modifyMenu", menu);
    }

    public int removeMenu(SqlSession sqlSession, MenuDTO menu) {

        return sqlSession.delete("MenuMapper.removeMenu", menu);
    }
}