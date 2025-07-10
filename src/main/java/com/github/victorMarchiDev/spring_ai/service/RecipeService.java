package com.github.victorMarchiDev.spring_ai.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RecipeService {

    private final ChatModel chatModel;
    public RecipeService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String createRecipe(String ingredients, String cuisine, String dietaryRestrictions){
        //Definindo o template do prompt que vamos utilizar na query
        var template = """
                I want to create a recipe using the following ingredients: {ingredients}.
                The cuisine type I prefer is {cuisine}.
                Please consider the following dietary restrictions: {dietaryRestrictions}. 
                Please provide me with a detailed recipe including title, list of ingredients and cooking instructions
                """;
        //Criando um objeto do tipo PromptTemplate e atribuindo a ele, os templates que colocamos
        PromptTemplate promptTemplate = new PromptTemplate(template);

        //Criando um Map para armazenar os valores dos meus parametros
        Map<String, Object> params = Map.of(
                "ingredients"  , ingredients,
                "cuisine"  , cuisine,
                "dietaryRestrictions"  , dietaryRestrictions
        );
        //Criando um objeto prompt utilizando o promptTemplate com parâmetros
        Prompt prompt = promptTemplate.create(params);

        //Retornando uma chamada do meu modelo em texto
        return chatModel.call(prompt).getResult().getOutput().getText();
    }
}
