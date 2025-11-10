package com.github.victorMarchiDev.spring_ai.repository;

import com.github.victorMarchiDev.spring_ai.model.RecipeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<RecipeModel, Long> {
}
