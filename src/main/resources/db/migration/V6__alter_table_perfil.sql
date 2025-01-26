DROP TABLE IF EXISTS usuario_perfil;

ALTER TABLE Usuario
ADD COLUMN perfil_id BIGINT;

ALTER TABLE Usuario
ADD CONSTRAINT fk_usuario_perfil
FOREIGN KEY (perfil_id)
REFERENCES Perfil (id)
ON DELETE CASCADE;


