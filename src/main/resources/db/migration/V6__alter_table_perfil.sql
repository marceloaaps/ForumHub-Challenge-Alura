-- 1. Remover a tabela associativa
DROP TABLE IF EXISTS usuario_perfil;

-- 2. Adicionar a coluna perfil_id na tabela Usuario
ALTER TABLE Usuario
ADD COLUMN perfil_id BIGINT;

-- 3. Criar a relação OneToOne entre Usuario e Perfil
ALTER TABLE Usuario
ADD CONSTRAINT fk_usuario_perfil
FOREIGN KEY (perfil_id)
REFERENCES Perfil (id)
ON DELETE CASCADE;

-- 4. (Opcional) Atualizar valores iniciais em Usuario com perfis associados
-- Certifique-se de ajustar essa parte com os dados reais
-- Exemplo (se aplicável):
-- UPDATE Usuario SET perfil_id = <id_perfil> WHERE id = <id_usuario>;
