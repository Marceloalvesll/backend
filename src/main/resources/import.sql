insert into Telefone (numero, codigoArea, operadora)
values ('1234567890', '023', 'Vivo'),
       ('9876543210', '056', 'Claro'),
       ('5555555555', '089', 'TIM'),
       ('9998887777', '011', 'Oi'),
       ('3333333333', '022', 'Nextel'),
       ('7777777777', '033', 'Vivo'),
       ('4444444444', '044', 'Claro'),
       ('6666666666', '055', 'TIM'),
       ('8888888888', '066', 'Oi'),
       ('2222222222', '077', 'Nextel'),
       ('1111111111', '088', 'Vivo'),
       ('5551112222', '094', 'Claro'),
       ('7778889999', '011', 'TIM'),
       ('1231231234', '061', 'Oi'),
       ('9876543210', '092', 'Nextel'),
       ('5554443333', '083', 'Vivo'),
       ('9876543210', '074', 'Claro'),
       ('1234567890', '055', 'TIM'),
       ('1112223333', '063', 'Oi'),
       ('1118923333', '053', 'TIM');

alter sequence telefone_id_seq restart with 21;

INSERT INTO Endereco (cep, cidade, estado, numero, rua)
VALUES
('01001-000', 'São Paulo', 1, 100, 'Avenida Paulista'),
('20040-002', 'Rio de Janeiro', 2, 150, 'Rua do Ouvidor'),
('30130-110', 'Belo Horizonte', 3, 200, 'Avenida Afonso Pena'),
('90040-001', 'Porto Alegre', 4, 250, 'Rua da Praia'),
('40020-160', 'Salvador', 5, 300, 'Avenida Sete de Setembro'),
('57020-410', 'Maceió', 5, 50, 'Rua do Comércio'),
('60060-170', 'Fortaleza', 5, 350, 'Avenida Beira Mar'),
('69020-120', 'Manaus', 5, 75, 'Rua Eduardo Ribeiro'),
('66020-240', 'Belém', 5, 125, 'Avenida Nazaré'),
('76820-245', 'Porto Velho', 5, 175, 'Rua Carlos Gomes'),
('69020-130', 'Manaus', 5, 80, 'Rua Saldanha Marinho'),
('64001-240', 'Teresina', 5, 20, 'Avenida Frei Serafim'),
('50010-330', 'Recife', 5, 400, 'Rua da Aurora'),
('69900-060', 'Rio Branco', 5, 45, 'Avenida Brasil'),
('79002-400', 'Campo Grande', 5, 220, 'Rua 14 de Julho'),
('60060-180', 'Fortaleza', 5, 360, 'Rua Barão do Rio Branco'),
('57020-420', 'Maceió', 5, 55, 'Avenida Fernandes Lima'),
('66020-250', 'Belém', 5, 130, 'Rua João Alfredo'),
('50010-340', 'Recife', 5, 410, 'Avenida Conde da Boa Vista');

alter sequence endereco_id_seq restart with 21;

insert into Administrador (cargo,cpf,login ,email, nome, senha)
values ('Gerente', '12345678901','joao','gerente@example.com', 'João Silva', 'mvJiSec3uZLUqe825+2/3gsotQ5Ar+XalO7KWvyv/3KJaUVQQ3o7aiPHavKLuSxUitM/BVb3c4SQ00XCH61DcQ=='),
       ('Supervisor', '23456789012', 'maria' ,'supervisor@example.com', 'Maria Santos', 'senha456'),
       ('Coordenador', '34567890123','carlos' ,'coordenador@example.com', 'Carlos Rodrigues', 'senha789'),
       ('Analista', '45678901234','ana' ,'analista@example.com', 'Ana Pereira', 'senhaabc'),
       ('Diretor', '56789012345','paulo' ,'diretor@example.com', 'Paulo Oliveira', 'senhadef');

alter sequence administrador_id_seq restart with 6;

insert into administrador_telefone (id_administrador, id_telefone)
values (1, 10),
       (1, 9),
       (2, 7),
       (2, 6),
       (3, 5),
       (4, 4),
       (4, 3),
       (5, 2),
       (5, 1);

insert into Cliente (cpf, dataNascimento, email, login, nome, senha, sobrenome)
values ('123.456.789-01', '1990-05-15', 'cliente1@example.com', 'cliente1', 'Ana', 'mvJiSec3uZLUqe825+2/3gsotQ5Ar+XalO7KWvyv/3KJaUVQQ3o7aiPHavKLuSxUitM/BVb3c4SQ00XCH61DcQ==', 'Silva'),
       ('234.567.890-12', '1985-08-20', 'cliente2@example.com', 'cliente2', 'José', 'senha456', 'Santos'),
       ('345.678.901-23', '1992-03-10', 'cliente3@example.com', 'cliente3', 'Maria', 'senha789', 'Ribeiro'),
       ('456.789.012-34', '1988-11-25', 'cliente4@example.com', 'cliente4', 'Carlos', 'senhaabc', 'Oliveira'),
       ('567.890.123-45', '1995-06-30', 'cliente5@example.com', 'cliente5', 'Laura', 'senhadef', 'Pereira');

alter sequence cliente_id_seq restart with 6;


insert into cliente_endereco (id_cliente, id_endereco)
values (1, 9),
       (2, 8),
       (2, 7),
       (3, 6),
       (3, 5),
       (4, 4),
       (4, 3),
       (4, 2),
       (5, 1);

insert into cliente_telefone (id_cliente, id_telefone)
values (1, 11),
       (1, 12),
       (1, 13),
       (2, 14),
       (3, 15),
       (4, 16),
       (4, 17),
       (4, 18),
       (5, 19);

insert into CupomPromocional (codigo, dataExpiracao, valorDesconto)
values ('CUPOM123', '2023-12-31', 10.50),
       ('DESC10OFF', '2023-10-15', 15.00),
       ('SALE2023', '2023-11-30', 20.75),
       ('PROMO50', '2023-09-30', 50.00),
       ('BLACKFRIDAY', '2023-11-26', 30.25);

alter sequence cupompromocional_id_seq restart with 6;

insert into Marca (nomeMarca, paisOrigem)
values ('Pearl', 'Japão'),
       ('Mapex', 'Estados Unidos'),
       ('Tama', 'Japão'),
       ('Ludwig', 'Estados Unidos');

insert into Categoria (nomeCategoria)
values ('Categoria 1'),
       ('Categoria 2'),
       ('Categoria 3'),
       ('Categoria 4');

INSERT INTO BateriaCompleta (nomeBateria, descricao, quantidadeEstoque, quantidadeTambor, preco, nomeImagem, id_categoria, id_marca) 
VALUES 
    ('Bateria Acústica', 'Uma bateria premium feita com materiais de alta qualidade, proporcionando um som potente e uma experiência excepcional para músicos exigentes.', 10, 5, 1500.00, 'bateria_premium.jpg', 1, 1),
    ('Bateria Eletrônica', 'Perfeita para iniciantes, esta bateria eletrônica oferece uma maneira acessível de aprender a tocar bateria. Possui uma variedade de sons e recursos para ajudar no aprendizado.', 20, 3, 500.00, 'bateria_iniciante.jpg', 2, 2),
    ('Bateria Híbrida', 'Esta bateria combina o melhor dos mundos acústico e eletrônico. Oferece a sensação de uma bateria acústica tradicional, com a versatilidade e recursos adicionais de uma bateria eletrônica.', 15, 4, 2000.00, 'bateria_hibrida.jpg', 3, 3),
    ('Bateria Infantil ', 'Projetada para os pequenos músicos, esta bateria colorida é durável e fácil de montar. Ajuda as crianças a desenvolverem habilidades musicais enquanto se divertem.', 30, 3, 300.00, 'bateria_infantil.jpg', 4, 4),
    ('Bateria Acústica', 'Uma bateria básica, mas confiável, perfeita para ensaios e apresentações ao vivo. Oferece um som sólido a um preço acessível.', 25, 5, 800.00, 'bateria_standard.jpg', 1, 1),
    ('Bateria Eletrônica', 'Projetada para músicos profissionais, esta bateria eletrônica oferece uma ampla gama de sons e recursos avançados para performances ao vivo e estúdio.', 18, 4, 2500.00, 'bateria_profissional.jpg', 2, 2),
    ('Bateria Híbrida', 'Esta bateria híbrida avançada é ideal para músicos que exigem o máximo em termos de som e versatilidade. Possui uma variedade de tambores e pads de alta qualidade.', 12, 6, 3500.00, 'bateria_hibrida_avancada.jpg', 3, 3),
    ('Bateria Infantil', 'Uma bateria infantil completa, que inclui um assento confortável e colorido. Perfeita para crianças que desejam aprender a tocar bateria com conforto.', 22, 4, 400.00, 'bateria_infantil_assento.jpg', 4, 4),
    ('Bateria Acústica', 'Uma bateria robusta projetada para suportar as exigências de apresentações ao vivo. Oferece um som poderoso e uma aparência impressionante no palco.', 8, 5, 1800.00, 'bateria_palco.jpg', 1, 1),
    ('Bateria Eletrônica', 'Uma bateria eletrônica compacta e portátil, perfeita para músicos que precisam de mobilidade. Ideal para práticas silenciosas e pequenas apresentações.', 35, 2, 600.00, 'bateria_compacta.jpg', 2, 2),
    ('Bateria Híbrida', 'Esta bateria híbrida foi projetada especificamente para uso em estúdios de gravação. Oferece uma ampla gama de sons e recursos para gravações profissionais.', 16, 4, 3200.00, 'bateria_hibrida_estudio.jpg', 3, 3),
    ('Bateria Infantil', 'Uma bateria infantil com designs divertidos de personagens de desenhos animados. Incentiva as crianças a se envolverem na música enquanto se divertem.', 28, 3, 350.00, 'bateria_infantil_personagens.jpg', 4, 4);

INSERT INTO Acessorio (nomeAcessorio, descricao, preco, quantidadeEstoque, id_marca, id_categoria, nomeImagem)
VALUES 
('Baqueta de Madeira', 'Baqueta de madeira para bateria', 15.99, 100, 1, 1, 'baqueta.jpg'),
('Prato Crash 16"', 'Prato de crash de 16 polegadas', 79.99, 50, 2, 2, 'prato_crash.jpg'),
('Pedal de Bumbo Duplo', 'Pedal de bumbo duplo para bateria', 199.99, 25, 3, 3, 'pedal_bumbo.jpg');

INSERT INTO Baqueta (nomeBaqueta, descricao, preco, quantidadeEstoque, id_marca, id_categoria, nomeImagem)
VALUES 
('Baqueta de Madeira', 'Baqueta de madeira para bateria', 15.99, 100, 1, 1, 'baqueta_madeira.jpg'),
('Baqueta de Nylon', 'Baqueta de nylon para bateria', 12.99, 80, 2, 1, 'baqueta_nylon.jpg'),
('Baqueta de Fibra de Carbono', 'Baqueta de fibra de carbono para bateria', 24.99, 60, 3, 1, 'baqueta_fibra_carbono.jpg');


INSERT INTO TamborAvulso (nomeTambor, descricao, preco, quantidadeEstoque, id_marca, id_categoria, nomeImagem)
VALUES 
('Caixa', 'Caixa de bateria avulsa', 249.99, 8, 1, 1, 'caixa.jpg'),
('Surdo', 'Surdo de bateria avulso', 299.99, 5, 2, 1, 'surdo.jpg'),
('Tom', 'Tom de bateria avulso', 179.99, 12, 3, 1, 'tom.jpg');

-- insert into Pedido (dataCriacao, tipoPagamento, total, id_cliente, id_cupom)
-- values
--     ('2023-10-01 10:15:30', 'CARTAO_DE_CREDITO', 150.50, 1, 1),
--     ('2023-10-02 14:20:45', 'CARTAO_DE_DEBITO', 75.25, 2, NULL),
--     ('2023-10-03 08:30:15', 'BOLETO_BANCARIO', 200.00, 3, NULL),
--     ('2023-10-04 16:45:10', 'TRANSFERENCIA_BANCARIA', 125.75, 4, 2),
--     ('2023-10-05 12:10:05', 'PIX', 50.00, 5, 3),
--     ('2023-10-06 09:05:20', 'CARTAO_DE_CREDITO', 300.99, 1, NULL),
--     ('2023-10-07 11:30:40', 'CARTAO_DE_DEBITO', 100.25, 2, 4),
--     ('2023-10-08 13:15:55', 'BOLETO_BANCARIO', 75.50, 3, NULL),
--     ('2023-10-09 15:40:10', 'TRANSFERENCIA_BANCARIA', 45.75, 4, 5),
--     ('2023-10-10 18:00:25', 'PIX', 25.00, 5, NULL);

-- alter sequence pedido_id_seq restart  with 11;



-- insert into StatusPedido (data, status, id_pedido)
-- values
--     ('2023-10-01 10:16:00', 'AGUARDANDO_PAGAMENTO', 1),
--     ('2023-10-01 11:30:00', 'EM_PROCESSAMENTO', 1),
--     ('2023-10-01 15:45:00', 'ENVIADO', 1),
--     ('2023-10-02 14:21:00', 'AGUARDANDO_PAGAMENTO', 2),
--     ('2023-10-02 16:00:00', 'CANCELADO', 2),
--     ('2023-10-03 08:31:00', 'AGUARDANDO_PAGAMENTO', 3),
--     ('2023-10-03 12:45:00', 'EM_PROCESSAMENTO', 3),
--     ('2023-10-03 16:20:00', 'ENVIADO', 3),
--     ('2023-10-03 20:10:00', 'ENTREGUE', 3),
--     ('2023-10-04 16:46:00', 'AGUARDANDO_PAGAMENTO', 4),
--     ('2023-10-04 18:15:00', 'EM_PROCESSAMENTO', 4),
--     ('2023-10-04 22:30:00', 'ENVIADO', 4),
--     ('2023-10-05 09:40:00', 'ENTREGUE', 4),
--     ('2023-10-05 12:11:00', 'AGUARDANDO_PAGAMENTO', 5),
--     ('2023-10-05 14:30:00', 'CANCELADO', 5),
--     ('2023-10-06 09:06:00', 'AGUARDANDO_PAGAMENTO', 6),
--     ('2023-10-07 11:31:00', 'AGUARDANDO_PAGAMENTO', 7),
--     ('2023-10-07 15:55:00', 'EM_PROCESSAMENTO', 7),
--     ('2023-10-08 13:16:00', 'AGUARDANDO_PAGAMENTO', 8),
--     ('2023-10-08 17:40:00', 'ENVIADO', 8),
--     ('2023-10-09 15:41:00', 'AGUARDANDO_PAGAMENTO', 9),
--     ('2023-10-10 18:01:00', 'AGUARDANDO_PAGAMENTO', 10),
--     ('2023-10-10 21:25:00', 'EM_PROCESSAMENTO', 10),
--     ('2023-10-10 23:55:00', 'ENVIADO', 10);

-- alter sequence statuspedido_id_seq restart with 25;


-- insert into ItemPedido (precoUnitario, quantidade, subTotal, id_produto, id_pedido)
-- values
--     (299.99, 2, 599.98, 1, 1),
--     (49.99, 3, 149.97, 2, 1),
--     (999.99, 1, 999.99, 3, 2),
--     (199.99, 2, 399.98, 4, 3),
--     (799.99, 1, 799.99, 5, 3),
--     (149.99, 4, 599.96, 6, 4),
--     (49.99, 2, 99.98, 7, 5),
--     (399.99, 1, 399.99, 8, 6),
--     (99.99, 3, 299.97, 9, 7),
--     (799.99, 1, 799.99, 10, 7),
--     (199.99, 1, 199.99, 5, 8),
--     (59.99, 2, 119.98, 7, 9),
--     (149.99, 3, 449.97, 1, 10),
--     (299.99, 2, 599.98, 3, 10);