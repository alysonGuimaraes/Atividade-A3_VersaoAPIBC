CREATE TABLE proponente (
    id UUID PRIMARY KEY,
    nome VARCHAR(50),
    cpf VARCHAR(11),
    dta_nascimento DATE
);

CREATE TABLE valores_receber (
    id UUID PRIMARY KEY,
    nome_instituicao VARCHAR(25),
    cnpj VARCHAR(14),
    valor FLOAT,
    tipo_valor VARCHAR(30),
    observacao VARCHAR(60),
    dta_referencia DATE,
    id_prop UUID,
    CONSTRAINT fk_proponente FOREIGN KEY (id_prop) REFERENCES proponente(id)
);