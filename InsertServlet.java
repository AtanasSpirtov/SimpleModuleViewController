package com.example.demo2;

import ConnectionsManager.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.Objects;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {


    @Override
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (Objects.nonNull(request.getParameter("Add"))) {
            PrintWriter out = response.getWriter();
            try {
                ConnectionPool connection = ConnectionPool.getInstance();
                String username = request.getParameter("user_name");
                String age = request.getParameter("age");

                PreparedStatement pst = connection.getConnection().prepareStatement
                        ("INSERT INTO user_information(user_name , age) VALUES(?,?)");
                pst.setString(1, username);
                pst.setInt(2, Integer.parseInt(age));
                int i = pst.executeUpdate();
                request.setAttribute("user_name", username);
                request.setAttribute("age", age);
                request.getRequestDispatcher("/SuccessfullyInserted.jsp").forward(request, response);
                out.println(i != 0 ? "Record has been inserted" : "failed to insert the data");
                connection.releaseConnection(connection.getConnection());
            } catch (Exception e) {
                out.println(e);
            }
        }
    }

    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/InsertServlet.jsp").forward(request, response);
    }
}