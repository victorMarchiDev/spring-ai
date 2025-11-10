package com.github.victorMarchiDev.spring_ai.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_RECIPE")
public class RecipeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String ingredients;

    @Column(nullable = false, length = 255)
    private String cuisine;

    @Column(length = 500)
    private String dietaryRestrictions;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String generatedRecipe;

    private LocalDateTime createdAt;

    // Construtor padrão exigido pelo JPA
    public RecipeModel() {
        this.createdAt = LocalDateTime.now();
    }

    // Construtor completo
    public RecipeModel(String ingredients, String cuisine, String dietaryRestrictions, String generatedRecipe) {
        this.ingredients = ingredients;
        this.cuisine = cuisine;
        this.dietaryRestrictions = dietaryRestrictions;
        this.generatedRecipe = generatedRecipe;
        this.createdAt = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIngredients() { return ingredients; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }

    public String getCuisine() { return cuisine; }
    public void setCuisine(String cuisine) { this.cuisine = cuisine; }

    public String getDietaryRestrictions() { return dietaryRestrictions; }
    public void setDietaryRestrictions(String dietaryRestrictions) { this.dietaryRestrictions = dietaryRestrictions; }

    public String getGeneratedRecipe() { return generatedRecipe; }
    public void setGeneratedRecipe(String generatedRecipe) { this.generatedRecipe = generatedRecipe; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
