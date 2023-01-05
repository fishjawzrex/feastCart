package org.example.repo;

import org.example.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepo extends JpaRepository<MenuItem,Integer> {
}
