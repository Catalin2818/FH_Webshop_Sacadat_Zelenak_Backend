package com.fhproject.shoppingCart;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Integer> {
    public Long countById(long id);
    public Optional<ShoppingCart> findByUser(int userId);
    public Optional<ShoppingCart> findByUserAndFinished(int userId, boolean finished);
}
