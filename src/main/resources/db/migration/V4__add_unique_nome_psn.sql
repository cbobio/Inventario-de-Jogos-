ALTER TABLE usuario
    ADD CONSTRAINT uk_usuario_nome_psn UNIQUE (nome_Psn);