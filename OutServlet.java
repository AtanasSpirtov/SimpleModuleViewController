package com.example.demo2;

import ConnectionsManager.ConnectionPool;
import People.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/OutServlet")
public class OutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("select id , user_name , age from user_information Limit 100")) {

            List<Person> personList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("user_name");
                int age = rs.getInt("age");
                personList.add(new Person(id, name, age));
            }

            request.setAttribute("users", personList);
            request.getRequestDispatcher("/OutServlet.jsp").forward(request, response);

        } catch (SQLException | ServletException e) {
            e.printStackTrace();
        }
    }
}