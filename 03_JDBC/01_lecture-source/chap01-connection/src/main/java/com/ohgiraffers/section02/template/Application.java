package com.ohgiraffers.section02.template;

import java.sql.Connection;

import static com.ohgiraffers.section02.template.Template.getConnection;
import static jdk.internal.net.http.common.Utils.close;

public class Application {

    public static void main(String[] args) {
        
        Connection con = getConnection();
        System.out.println("con = " + con);

        close(con);
    }
}
