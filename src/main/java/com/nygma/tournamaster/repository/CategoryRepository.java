package com.nygma.tournamaster.repository;

import com.nygma.tournamaster.model.Category;
import com.nygma.tournamaster.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
