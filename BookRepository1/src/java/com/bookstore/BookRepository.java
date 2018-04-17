/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore;

import java.util.List;

/**
 *
 * @author Administrator
 */
public interface BookRepository {
     Book lookupBookById(String id);  
  
    void addBook(String title, String description,  
            String price, String pubDate);  
  
    void updateBook(String id, String title,  
            String description, String price, String pubDate);  
      
    void removeBook(String id);  
  
  
    List<Book> listBooks();  
    
}
