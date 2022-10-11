package ru.netology.domain;

import ru.netology.repository.Repository;

public class ProductManager {
    private Repository repo;

    protected ProductManager(Repository repo) {
        this.repo = repo;
    }

    public void save(Product product) {
        repo.save(product);
    }

    public Product[] getItemsReversed() {
        Product[] all = repo.getItems();
        Product[] reversed = new Product[all.length];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = all[all.length - 1 - i];
        }
        return reversed;
    }

    public Product[] getItems() {
        Product[] all = repo.getItems();
        return all;
    }

    public Product[] searchBy(String text) {
        Product[] results = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repo.getItems()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[results.length + 1];
                int i = 0;
                for (Product result : results) {
                    tmp[i] = result;
                    i++;
                }
                tmp[results.length] = product;
                results = tmp;
            }
        }
        return results;
    }

    private static boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }

}