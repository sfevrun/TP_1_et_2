/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;


/**
 *
 * @author Administrator
 */
@ApplicationScoped
@InMemory  
public class BookRepositoryImpl implements BookRepository{
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
    private int count;  
      
    private Map<String, Book> idToBookMap = new HashMap<String, Book>();  
  
    public BookRepositoryImpl()  {  
        synchronized (this) {  
            books(book("War and Peace", "blah blah blah", "5.50", "1970-05-27"),  
                    book("Pride and Prejudice", "blah blah blah", "5.50", "1960-05-27"),  
                    book("book1", "blah blah blah", "5.50", "1950-05-27"),  
                    book("book2", "blah blah blah", "5.50", "1980-05-27"),  
                    book("book3", "blah blah blah", "5.50", "1970-05-27"),  
                    book("book4", "blah blah blah", "5.50", "1970-05-27"),  
                    book("book5", "blah blah blah", "5.50", "1970-05-27"),  
                    book("book6", "blah blah blah", "5.50", "1970-05-27"),  
                    book("book7", "blah blah blah", "5.50", "1970-05-27"),  
                    book("book8", "blah blah blah", "5.50", "1970-05-27"),  
                    book("book9", "blah blah blah", "5.50", "1970-05-27"),  
                    book("Java for dummies", "blah blah blah", "1.99", "1970-05-27"));  
        }  
    }  
  
    private Book book(String title, String description, String aPrice,  
            String aPubDate)  {  
  
        Date pubDate = null;  
        BigDecimal price = null;  
          
        try {  
            price = new BigDecimal(aPrice);  
        }catch (Exception ex) {  
        }  
          
        try {  
            pubDate = dateFormat.parse(aPubDate);  
        }catch (Exception ex) { 
            ex.printStackTrace();
        }  
          
        return new Book("" + (count++), title, description, price, pubDate);  
          
    }  
  
    private void books(Book... books) {  
        for (Book book : books) {  
            doAddBook(book);  
        }  
    }  
  
    private void doAddBook(Book book) {  
        synchronized (this) {  
            this.idToBookMap.put(book.getId(), book);  
        }  
    }  
  
    @Override  
    public Book lookupBookById(String id)  {  
        synchronized (this) {  
            return this.idToBookMap.get(id).cloneMe();  
        }  
    }  
  
    @Override  
    public void addBook(String title, String description, String price,  
            String pubDate)  {  
        doAddBook(book(title, description, price, pubDate));  
    }  
  
    @Override  
    public void updateBook(String id, String title, String description,  
            String price, String pubDate) {  
        Book book = book(title, description, price, pubDate);  
        synchronized (this) {  
            book.setId(id);  
            this.idToBookMap.put(id, book);  
        }  
    }  
  
    private List<Book> doListBooks()  {  
        List<Book> books;  
        synchronized (this) {  
  
            books = new ArrayList<Book>(this.idToBookMap.size());  
            for (Book book : this.idToBookMap.values()) {  
                books.add(book.cloneMe());  
            }  
        }  
        return books;  
    }  
      
    public List<Book> listBooks() {  
          
        List<Book> books = doListBooks();  
  
        Collections.sort(books, new Comparator<Book>() {  
            public int compare(Book bookA, Book bookB) {  
                return bookA.getId().compareTo(bookB.getId());  
            }  
        });  
        return books;  
    }  
  
    @Override  
    public void removeBook(String id)  {  
        synchronized(this) {  
            this.idToBookMap.remove(id);  
        }  
    }  
    
}
