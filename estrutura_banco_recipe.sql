-- ================================
-- ESTRUTURA DO BANCO DE DADOS (DDL)
-- ================================

CREATE TABLE TB_RECIPE (
    id BIGSERIAL PRIMARY KEY,
    ingredients VARCHAR(1000) NOT NULL,
    cuisine VARCHAR(255) NOT NULL,
    dietary_restrictions VARCHAR(500),
    generated_recipe TEXT NOT NULL,
    created_at TIMESTAMP
);

-- ================================
-- DADOS DE EXEMPLO (DML)
-- ================================

INSERT INTO TB_RECIPE (ingredients, cuisine, dietary_restrictions, generated_recipe, created_at) VALUES
('Arroz, frango, tomate', 'Brasileira', 'Sem glúten', 'Receita de arroz com frango e tomate.', NOW()),
('Macarrão, queijo, leite', 'Italiana', 'Sem restrições', 'Receita de macarrão ao molho branco.', NOW()),
('Tofu, brócolis, molho shoyu', 'Asiática', 'Vegana', 'Receita de tofu com brócolis e shoyu.', NOW());