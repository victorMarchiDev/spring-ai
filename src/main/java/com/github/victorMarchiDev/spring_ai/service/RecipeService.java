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
                Quero criar uma receita usando os seguintes ingredientes: {ingredients}.
                O tipo de cozinha que eu prefiro é {cuisine}.
                Por favor, considere as seguintes restrições alimentares: {dietaryRestrictions}.
                Forneça uma receita detalhada com título, lista de ingredientes** e modo de preparo.
                A receita deve ser direta e sem decorações ou emojis.
                Use apenas texto simples, sem formatação Markdown.
                Inclua apenas: título da receita, lista de ingredientes e modo de preparo, em formato conciso e claro.
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
