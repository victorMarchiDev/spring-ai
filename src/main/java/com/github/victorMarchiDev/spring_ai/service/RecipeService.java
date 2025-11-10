package com.github.victorMarchiDev.spring_ai.service;

import com.github.victorMarchiDev.spring_ai.model.RecipeModel;
import com.github.victorMarchiDev.spring_ai.repository.RecipeRepository;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RecipeService {

    private final ChatModel chatModel;
    private final RecipeRepository recipeRepository;

    public RecipeService(ChatModel chatModel, RecipeRepository recipeRepository) {
        this.chatModel = chatModel;
        this.recipeRepository = recipeRepository;
    }

    public String createRecipe(String ingredients, String cuisine, String dietaryRestrictions) {
        // Template do prompt enviado para a IA
        var template = """
                Quero criar uma receita usando os seguintes ingredientes: {ingredients}.
                O tipo de cozinha que eu prefiro é {cuisine}.
                Por favor, considere as seguintes restrições alimentares: {dietaryRestrictions}.
                Forneça uma receita detalhada com título, lista de ingredientes e modo de preparo.
                A receita deve ser direta e sem decorações, emojis ou enfeites.
                Use apenas texto simples, sem formatação Markdown.
                Inclua apenas: título da receita, lista de ingredientes e modo de preparo, de forma concisa e clara.
                """;

        // Cria o prompt com os parâmetros
        PromptTemplate promptTemplate = new PromptTemplate(template);
        Map<String, Object> params = Map.of(
                "ingredients", ingredients,
                "cuisine", cuisine,
                "dietaryRestrictions", dietaryRestrictions
        );

        Prompt prompt = promptTemplate.create(params);

        // Faz a chamada para o modelo de IA
        var response = chatModel.call(prompt);
        String generatedRecipe = response.getResult().getOutput().getText();

        // Cria e salva a receita no banco
        RecipeModel recipe = new RecipeModel(
                ingredients,
                cuisine,
                dietaryRestrictions,
                generatedRecipe
        );

        recipeRepository.save(recipe);

        // Retorna a receita gerada
        return generatedRecipe;
    }
}
