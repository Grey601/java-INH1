package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class RepositoryTest {

    Repository repo = new Repository();
    Book book1 = new Book(1, "Война и Мир", 1600, "Толстой" );
    Book book2 = new Book(2, "Скотный двор", 1000, "Оруэлл" );
    Book book3 = new Book(3, "1984", 2900, "Оруэлл" );
    Smartphone phone1 = new Smartphone(4, "iPhone13", 60_000, "Apple" );
    Smartphone phone2 = new Smartphone(5, "Samsung Galaxy S22", 55_000, "Samsung" );

    @Test
    public void shouldSaveTest() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(phone1);
        repo.save(phone2);

        Product[] expected = {book1, book2, book3, phone1, phone2};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdTest() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(phone1);
        repo.save(phone2);
        repo.removeById(2);

        Product[] expected = {book1, book3, phone1, phone2};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdTest2() {
        repo.save(book1);
        repo.removeById(1);

        Product[] expected = {};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }
}
