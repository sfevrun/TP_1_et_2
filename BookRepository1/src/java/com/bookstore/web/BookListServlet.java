/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookstore.BookRepository;
import javax.annotation.sql.DataSourceDefinition;
import javax.inject.Inject;
import com.bookstore.JDBC;

/**
 *
 * @author Administrator
 */
//@WebServlet(name = "BookListServlet", urlPatterns = {"/BookListServlet"})
  

@DataSourceDefinition(
name = "java:app/jdbc/bookstore",
     className = "org.apache.derby.jdbc.ClientDataSource",
     portNumber = 1527,
     serverName = "localhost",
     databaseName = "bookstore",
     user = "app",
     password = "app",
     properties={"create=true"})

  
@WebServlet("/book/")  
public class BookListServlet extends HttpServlet {  
      
    @Inject  
    @JDBC
    private BookRepository bookRepo;  
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        request.setAttribute("books", bookRepo.listBooks());  
        getServletContext().getRequestDispatcher("/book-list.jsp").forward(request, response);  
    }  
  
} 