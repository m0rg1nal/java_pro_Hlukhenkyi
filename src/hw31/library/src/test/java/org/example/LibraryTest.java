package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library = new Library();

    @Test
    public void testAddBook(){
        Book book = new Book("1984", "George Orwell");
        library.addBook(book);

        assertTrue(library.getBooks().contains(book), "Book was not added.");
        assertEquals(1, library.getBookCount(), "Book count should be 1 after adding 1 book.");
    }

    @Test
    public void testRemoveExistingBook(){
        Book book = new Book("Metamorphosis", "Franz Kafka");
        library.addBook(book);
        boolean result = library.removeBook(book);

        assertTrue(result, "Book was not deleted.");
        assertFalse(library.getBooks().contains(book), "Book should not be in the library.");
        assertEquals(0, library.getBookCount(), "Book count should be 0.");
    }

    @Test
    public void removeNonExistingBook(){
        Book book = new Book("Metamorphosis", "Franz Kafka");
        boolean result = library.removeBook(book);

        assertFalse(result, "Book was not in the library, so shouldn't be deleted.");
        assertEquals(0, library.getBookCount(), "Book count should be 0.");
    }

    @Test
    public void removeNullBook(){
        boolean result = library.removeBook(null);

        assertFalse(result, "Book is null, so should rerutn false");
        assertEquals(0, library.getBookCount(), "Book count should be 0.");
    }

    @Test
    public void testGetBooksWithAddedBooks(){
        Book book = new Book("Metamorphosis", "Franz Kafka");
        library.addBook(book);
        List<Book> books = library.getBooks();

        assertTrue(books.contains(book), "Library should contain the book.");
        assertEquals(1, books.size(), "Library should contain 1 book only.");
    }

    @Test
    public void testGetBooksEmpty(){
        List<Book> books = library.getBooks();

        assertTrue(books.isEmpty(), "Library should not contain any books.");
        assertNotNull(books, "getBooks() should not return null.");
    }

    @Test
    public void testGetBookCountEmpty(){
        library.getBookCount();

        assertEquals(0,library.getBookCount(), "Book count should be 0.");
    }

    @Test
    public void testGetBookCountWithAddedBooks() {
        Library library = new Library();
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("Brave New World", "Aldous Huxley"));

        assertEquals(2, library.getBookCount(), "Library should contain 2 books");
    }

    @Test
    public void testGetBookCountWithRemovedBook() {
        Library library = new Library();
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("Brave New World", "Aldous Huxley");

        library.addBook(book1);
        library.addBook(book2);
        library.removeBook(book1);

        assertEquals(1, library.getBookCount(), "Library should contain 1 book after removal");
    }

    @Test
    public void testGetBookCountWithRemovedNonExistentBook() {
        Library library = new Library();
        library.addBook(new Book("1984", "George Orwell"));
        library.removeBook(new Book("Dune", "Frank Herbert"));

        assertEquals(1, library.getBookCount(), "Book count should remain the same after removing a non-existent book");
    }

    @Test
    public void testGetBookCountWithAddedDuplicateBooks() {
        Library library = new Library();
        Book book = new Book("1984", "George Orwell");

        library.addBook(book);
        library.addBook(book); // той самий об'єкт

        assertEquals(2, library.getBookCount(), "Duplicates should be counted if added twice");
    }
}