package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library
{
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Cannot add null book to library.");
        }
        books.add(book);
    }

    public boolean removeBook(Book book) {
        if (book == null) {
            return false;
        }
        return books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public int getBookCount() {
        return books.size();
    }
}
