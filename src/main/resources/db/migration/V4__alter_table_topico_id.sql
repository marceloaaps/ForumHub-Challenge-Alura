-- Remover a chave estrangeira
ALTER TABLE resposta DROP FOREIGN KEY FK_RESPOSTA_ON_TOPICO;

-- Alterar a coluna da tabela 'topico' (exemplo)
ALTER TABLE topico MODIFY COLUMN id BIGINT NOT NULL;

-- Recriar a chave estrangeira
ALTER TABLE resposta ADD CONSTRAINT FK_RESPOSTA_ON_TOPICO FOREIGN KEY (topico_id) REFERENCES topico(id);