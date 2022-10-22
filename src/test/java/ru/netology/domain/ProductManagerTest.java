package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.Repository;

public class ProductManagerTest {

    Repository repo = new Repository();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(1, "Война и Мир", 1600, "Толстой");
    Book book2 = new Book(2, "Скотный двор", 1000, "Оруэлл");
    Book book3 = new Book(3, "1984", 2900, "Оруэлл");
    Smartphone phone1 = new Smartphone(4, "iPhone13", 60_000, "Apple");
    Smartphone phone2 = new Smartphone(5, "Samsung Galaxy S22", 55_000, "Samsung");
    Book book4 = new Book(6, "Бумажный дворец", 1300, "Коули Хеллер");

    @BeforeEach
    public void setup() {
        manager.save(book1);
        manager.save(book2);
        manager.save(book3);
        manager.save(phone1);
        manager.save(phone2);
        manager.save(book4);
    }

    @Test
    public void shouldShowReversedItems() {

        Product[] expected = {book4, phone2, phone1, book3, book2, book1};
        Product[] actual = manager.getItemsReversed();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowItems() {

        Product[] expected = {book1, book2, book3, phone1, phone2, book4};
        Product[] actual = manager.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByText() {

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Скотный двор");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchSeveralByText() {

        Product[] expected = {book2, book4};
        Product[] actual = manager.searchBy("двор");

        Assertions.assertArrayEquals(expected, actual);

    }
}
