package com.nousunde.wxma.service;

import com.nousunde.wxma.dao.BookDAO;
import com.nousunde.wxma.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookSvc {
    @Autowired
    private BookDAO bookDAO;

    public List<Book> getBooks(){
        return bookDAO.getBooks();
    }

    public Book getBookById(String bookId){
        if (bookId.isEmpty() || bookId == null)
            return null;
        return bookDAO.getBookById(bookId);
    }

    public Book getBookByBarcode(String bookISBN){
        if (bookISBN.isEmpty() || bookISBN == null)
            return null;
        return bookDAO.getBookByBarCode(bookISBN);
    }
    public void addBook(Book book){
        if(book == null)
            return;
        bookDAO.addBook(book);
    }

    public void updateBook(Book book){
        if(book == null)
            return;
        bookDAO.updateBook(book);
    }

    public void deleteBook(String bookId){
        if (bookId.isEmpty() || bookId == null)
            return ;
        bookDAO.deleteBookById(bookId);
    }

    public List<String> getRefLangs(){
        List<String> lang = new ArrayList<>();
        List<Book> bookList = getBooks();
        for (Book b :
                bookList) {
            if (!lang.contains(b.getLang()))
                lang.add(b.getLang());
        }
        return lang;
    }
    public List<Book> getBookByLang(String lang){
        List<Book> bookList = getBooks();
        if (bookList.isEmpty())
            return null;
        List<Book> books4Lang = new ArrayList<>();

        for (Book b :
                bookList) {
            if (b.getLang().trim().equals(lang.trim()))
                books4Lang.add(b);
        }
        return books4Lang;
    }
}
