CREATE TABLE curso
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    name      VARCHAR(255)          NULL,
    categoria VARCHAR(255)          NULL,
    CONSTRAINT pk_curso PRIMARY KEY (id)
);

CREATE TABLE perfil
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NULL,
    CONSTRAINT pk_perfil PRIMARY KEY (id)
);

CREATE TABLE resposta
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    mensagem     VARCHAR(255)          NULL,
    topico_id    BIGINT                NULL,
    data_criacao datetime              NULL,
    autor_id     BIGINT                NULL,
    solucao      VARCHAR(255)          NULL,
    CONSTRAINT pk_resposta PRIMARY KEY (id)
);

CREATE TABLE topico
(
    id           BIGINT       NOT NULL,
    titulo       VARCHAR(255) NULL,
    mensagem     VARCHAR(255) NULL,
    data_criacao datetime     NULL,
    status       BIT(1)       NOT NULL,
    autor_id     BIGINT       NULL,
    curso_id     BIGINT       NULL,
    CONSTRAINT pk_topico PRIMARY KEY (id)
);

CREATE TABLE usuario
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    nome  VARCHAR(255)          NULL,
    email VARCHAR(255)          NULL,
    senha VARCHAR(255)          NULL,
    CONSTRAINT pk_usuario PRIMARY KEY (id)
);

CREATE TABLE usuario_perfil
(
    perfil_id  BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL
);

ALTER TABLE resposta
    ADD CONSTRAINT FK_RESPOSTA_ON_AUTOR FOREIGN KEY (autor_id) REFERENCES usuario (id);

ALTER TABLE resposta
    ADD CONSTRAINT FK_RESPOSTA_ON_TOPICO FOREIGN KEY (topico_id) REFERENCES topico (id);

ALTER TABLE topico
    ADD CONSTRAINT FK_TOPICO_ON_AUTOR FOREIGN KEY (autor_id) REFERENCES usuario (id);

ALTER TABLE topico
    ADD CONSTRAINT FK_TOPICO_ON_CURSO FOREIGN KEY (curso_id) REFERENCES curso (id);

ALTER TABLE usuario_perfil
    ADD CONSTRAINT fk_usuper_on_perfil FOREIGN KEY (perfil_id) REFERENCES perfil (id);

ALTER TABLE usuario_perfil
    ADD CONSTRAINT fk_usuper_on_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (id);