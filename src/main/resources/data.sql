-- Inserir proponentes
INSERT INTO proponente (id, nome, cpf, dta_nascimento) VALUES
  ('79d8bb9b-8d1b-404e-85a4-072e3a4c7523', 'João Silva', '29891443078', '1990-05-20'),
  ('06abebb1-91b6-4828-9891-2bf32849a28d', 'Maria Souza', '73170235079', '1985-10-15');

-- Inserir valores a receber
INSERT INTO valores_receber (id, nome_instituicao, cnpj, valor, tipo_valor, observacao, dta_referencia, id_prop) VALUES
  ('2999a152-40ba-4f4e-bd91-36d229b72ce3', 'Banco XYZ', '71710084000103', 1500.75, 'Antecipação', 'Recebido parcialmente', '2024-01-01', '79d8bb9b-8d1b-404e-85a4-072e3a4c7523'),
  ('9457c4ea-d89c-4a70-b6ba-59ae5b314b0c', 'Banco ABC', '75204850000100', 800.50, 'Repasse', 'Aguardando análise', '2024-02-01', '06abebb1-91b6-4828-9891-2bf32849a28d');
