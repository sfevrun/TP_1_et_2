/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Book implements Cloneable{
    private String title;  
    private String description;  
    private BigDecimal price;  
    private Date pubDate;  
    private String id;  
  
    public Book(String id, String title, String description, BigDecimal price, Date pubDate) {  
        this.id = id;  
        this.title = title;  
        this.description = description;  
        this.price = price;  
        this.pubDate = pubDate;  
    }  
  
    public Book() {  
    }  
  
    public String getTitle() {  
        return title;  
    }  
  
    public void setTitle(String title) {  
        this.title = title;  
    }  
  
    public String getDescription() {  
        return description;  
    }  
  
    public void setDescription(String description) {  
        this.description = description;  
    }  
  
    public BigDecimal getPrice() {  
        return price;  
    }  
  
    public void setPrice(BigDecimal price) {  
        this.price = price;  
    }  
  
    public Date getPubDate() {  
        return pubDate;  
    }  
  
    public void setPubDate(Date pubDate) {  
        this.pubDate = pubDate;  
    }  
  
    public String getId() {  
        return id;  
    }  
  
    public void setId(String id) {  
        this.id = id;  
    }  
  
    public Book cloneMe() {  
        try {  
            return (Book) super.clone();  
        } catch (CloneNotSupportedException e) {  
            return null;  
        }  
    }  
  
    @Override  
    public String toString() {  
        return "Book [title=" + title + ", description=" + description  
                + ", price=" + price + ", pubDate=" + pubDate + ", id=" + id  
                + "]";  
    }  
    
}
