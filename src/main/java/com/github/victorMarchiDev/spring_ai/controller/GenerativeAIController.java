package com.github.victorMarchiDev.spring_ai.controller;

import com.github.victorMarchiDev.spring_ai.service.ChatService;
import com.github.victorMarchiDev.spring_ai.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerativeAIController {

    private final ChatService service;
    private final RecipeService recipeService;
    public GenerativeAIController(ChatService service, RecipeService recipeService) {
        this.service = service;
        this.recipeService = recipeService;
    }


    @GetMapping("/ask-ai")
    public String getResponse(@RequestParam String prompt){
        return service.getResponse(prompt);
    }

    @GetMapping("/ask-ai-options")
    public String getResponseWithOptions(@RequestParam String prompt){
        return service.getResponseWithOptions(prompt);
    }

    @GetMapping("/recipe-creator")
    public String recipeCreator(@RequestParam String ingredients,
                                @RequestParam(defaultValue = "any") String cuisine,
                                @RequestParam(defaultValue = "none") String dietaryRestrictions){
        return recipeService.createRecipe(ingredients, cuisine, dietaryRestrictions);
    }



}
