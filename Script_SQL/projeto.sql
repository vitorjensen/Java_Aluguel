-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: host.docker.internal
-- Tempo de geração: 11/06/2025 às 18:32
-- Versão do servidor: 9.3.0
-- Versão do PHP: 8.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `projeto`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_aluguel`
--

CREATE TABLE `tb_aluguel` (
  `alu_codigo` int NOT NULL,
  `cli_codigo` varchar(200) DEFAULT NULL,
  `alu_data_inicial` date NOT NULL,
  `alu_data_final` date NOT NULL,
  `pro_codigo` int DEFAULT NULL,
  `alu_valor` decimal(6,2) DEFAULT NULL,
  `alu_valor_sinal` decimal(6,2) DEFAULT NULL,
  `alu_resta_pagar` decimal(6,2) DEFAULT NULL,
  `alu_pago_total` varchar(20) DEFAULT NULL,
  `alu_tipo_pagamento` varchar(20) DEFAULT NULL,
  `ven_nome` varchar(80) DEFAULT NULL,
  `alu_observacao` varchar(200) NOT NULL,
  `alu_status` varchar(80) DEFAULT NULL,
  `alu_qtde` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `tb_aluguel`
--

INSERT INTO `tb_aluguel` (`alu_codigo`, `cli_codigo`, `alu_data_inicial`, `alu_data_final`, `pro_codigo`, `alu_valor`, `alu_valor_sinal`, `alu_resta_pagar`, `alu_pago_total`, `alu_tipo_pagamento`, `ven_nome`, `alu_observacao`, `alu_status`, `alu_qtde`) VALUES
(26, '17', '2025-05-29', '2025-05-30', 1, 700.00, 700.00, 0.00, 'SIM', 'CRÉDITO 1X', 'RAMON', 'Pago', 'LOCADO', 1),
(28, '14', '2025-05-28', '2025-05-29', 3, 50.00, 50.00, 0.00, 'SIM', 'DÉBITO', 'Joyce', 'Pago', 'LOCADO', 1),
(29, '1', '2025-05-29', '2025-05-31', 4, 900.00, 500.00, 400.00, 'NÃO', 'CRÉDITO 1X', 'Vanessa', 'A pagar', 'LOCADO', 1),
(32, '4', '2025-05-29', '2025-05-31', 4, 1800.00, 600.00, 1200.00, 'NÃO', 'CRÉDITO 3X', 'Vania', 'A pagar', 'LOCADO', 2),
(34, '17', '2025-05-29', '2025-06-01', 4, 900.00, 600.00, 1200.00, 'NÃO', 'CRÉDITO 3X', 'Deborah', 'A pagar', 'RESERVADO', 2),
(35, '6', '2025-05-29', '2025-05-30', 3, 100.00, 60.00, 40.00, 'NÃO', 'CRÉDITO 1X', 'Vanessa', 'A pagar', 'LOCADO', 2),
(36, '19', '2025-06-08', '2025-06-14', 7, 900.00, 900.00, 0.00, 'NÃO', 'CRÉDITO 2X', 'Charles', 'A pagar', 'LOCADO', 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_cliente`
--

CREATE TABLE `tb_cliente` (
  `cli_codigo` int NOT NULL,
  `cli_nome` varchar(120) NOT NULL,
  `cli_telefone` varchar(13) NOT NULL,
  `cli_cpf` varchar(14) NOT NULL,
  `cli_rua` varchar(120) NOT NULL,
  `cli_numero` varchar(120) NOT NULL,
  `cli_bairro` varchar(40) NOT NULL,
  `cli_cidade` varchar(120) NOT NULL,
  `cli_estado` char(2) NOT NULL,
  `cli_complemento` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `tb_cliente`
--

INSERT INTO `tb_cliente` (`cli_codigo`, `cli_nome`, `cli_telefone`, `cli_cpf`, `cli_rua`, `cli_numero`, `cli_bairro`, `cli_cidade`, `cli_estado`, `cli_complemento`) VALUES
(1, 'Maria Vitoria', '19 99488-4455', '256.700.777-00', 'Rua So Leopoldo', '500', 'Nova Morada', 'Sumaré', 'SP', 'Cond. 300, casa 17'),
(2, 'Heitor', '19 99301-5577', '345.669.997-09', 'Rua da Liberdade', '280', 'Jd Aparecida', 'Blumenau', 'SC', 'Apto 15'),
(3, 'Felipe ', '19 34555-5333', '345.667.766-66', 'Rua Primavera', '50', 'Nova Morada', 'Sumar', 'SP', 'Casa 120'),
(4, 'Guilherme', '19 34666-6431', '456.666.566-66', 'Rua Jos Dirceu', '30', 'Jardim Boer', 'Pirassununga', 'SC', 'Nada'),
(5, 'Maria Eduarda Santos', '19 34667-7448', '345.678.876-68', 'Rua Floripa2', '455', 'Nova Venezas', 'Nova odessa', 'RJ', 'Apto 4'),
(6, 'Joao Pedro', '19 34657-8900', '345.876.234-90', 'Rua Itatiba', '5000', 'Jd Salvador', 'Campinas', 'SP', 'Casa'),
(7, 'Jose', '19 34653-4556', '234.569.877-77', 'So Paulo', '50', 'Jd Amlia', 'Valinhos', 'AC', 'Apto 45'),
(8, 'Beatriz Duarte', '19 99457-7665', '123.456.786-54', 'Rua Itatinga', '220', 'JD Florianpolis', 'Santa Brbara', 'SP', 'Casa'),
(9, 'Joana Freitas', '19 99466-7584', '123.098.567-55', 'Rua SingaPura', '49', 'Jd Mato Grosso', 'Sumar', 'SP', 'Casa'),
(10, 'Roberta Dias', '19 99467-8756', '123.345.654-75', 'Rua dos Lrios', '450', 'Jd Ipiranga', 'Americana', 'SP', 'Apto'),
(11, 'Ramon Domiciano', '19 99488-3678', '123.456.765-44', 'Rua das Dálias ', '20', 'Jd Alvorada', 'Americana', 'SP', 'Apto '),
(12, 'Felipe', '19 99488-3660', '345.456.789-20', 'Jambeiros', '120', 'asdasdfsf', 'Campinas', 'SP', 'Casa 2'),
(13, 'Vitor Jensen', '19994883660', '459.327.968-20', 'Belém', '130', 'Fátima', 'Americana', 'SP', '345.456.789-20'),
(14, 'Leonardo', '19994883660', '345.456.789-20', 'Rua dos salgueiros', '120', 'asdasdfsf', 'Americana', 'sp', 'Casa'),
(15, 'Leonardo', '19994883660', '345.456.789-20', 'Rua dos salgueiros', '120', 'Jd Amoreira', 'Americana', 'sp', 'Casa'),
(16, 'Leonardo', '19994883660', '345.456.789-20', 'Rua dos salgueiros', '120', 'Amoreiras', 'Americana', 'sp', 'Casa'),
(17, 'Cleber', '19994883660', '45732489620', 'Rua salgueiros', '130', 'Bairro Flora', 'Americana', 'SP', 'Casa'),
(19, 'Isabela Dias', '19 99466-2890', '123.789.456-10', 'Rua Juventos', '120', 'Jd Iguaçu', 'São Pedro', 'SP', 'Apto');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_fornecedor`
--

CREATE TABLE `tb_fornecedor` (
  `for_codigo` int NOT NULL,
  `for_pessoa` varchar(20) NOT NULL DEFAULT '0000-00-00',
  `for_cnpj` varchar(18) NOT NULL,
  `for_razao` varchar(40) NOT NULL,
  `for_fantasia` varchar(120) NOT NULL,
  `for_endereco` varchar(120) NOT NULL,
  `for_numero` varchar(120) NOT NULL,
  `for_cidade` varchar(120) NOT NULL,
  `for_estado` char(2) NOT NULL,
  `for_telefone` varchar(14) NOT NULL,
  `for_data_cadastro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `tb_fornecedor`
--

INSERT INTO `tb_fornecedor` (`for_codigo`, `for_pessoa`, `for_cnpj`, `for_razao`, `for_fantasia`, `for_endereco`, `for_numero`, `for_cidade`, `for_estado`, `for_telefone`, `for_data_cadastro`) VALUES
(1, 'Jurídica', '08.799.668/0001-52', '206-2 - Sociedade Empresária Limitada', 'CARLA LOCACAO DE ROUPAS PARA NOIVAS LTDA', 'AVENIDA GONCALO BOTELHO DE CAMPOS', '2870', 'VARZEA GRANDE', 'MT', '(65) 9606-6456', '2022-10-12 00:00:00'),
(3, 'Jurídica', '16.910.335/0001-87', '206-2 - Sociedade Empresária Limitada', 'DRESS STORE LOCACAO DE VESTIDOS PARA FESTAS LTDA', 'AVENIDA CASTANHEIRAS', 'S/N', 'BRASILIA', 'DF', '(61) 3627-8870', '2022-10-12 00:00:00'),
(4, 'Jurídica', '35.274.269/0001-40', '206-2 - Sociedade Empresária Limitada', 'CELINA MEDEIROS ROUPARIA LTDA', 'RODOVIA BR-381 FERNAO DIAS', 'SN', 'BETIM', 'MG', '(31) 9287-2510', '2022-10-12 00:00:00'),
(5, 'Jurídica', '22.505.965/0001-79', '230-5 - Empresa Individual de Responsabi', 'ROUPARIA MODA FEMININA EIRELI', 'R FRANCISCO DA CUNHA', '197', 'SAO PAULO', 'SP', '(11) 2079-1366', '2022-10-12 00:00:00'),
(6, 'Jurídica', '50.211.705/0001-26', '206-2 - Sociedade Empresária Limitada', 'ESTILO ROUPARIA LTDA', 'AVENIDA VITAL BRASIL', '1297', 'POA', 'SP', '(11) 4639-5909', '2022-10-12 00:00:00'),
(7, 'Jurídica', '08.778.678/0001-01', '230-5 - Empresa Individual de Responsabi', 'LINNA ROUPAS E ACESSORIOS EIRELI', 'R ITABIRITO', '700', 'AMERICANA', 'SP', '(19) 3406-2511', '2022-11-03 00:00:00'),
(8, 'Jurídica', '11.513.961/0001-16', '306-9 - Fundação Privada', 'FUNDACAO AGENCIA DAS BACIAS HIDROGRAFICAS DOS RIOS PIRACICABA, CAPIVARI E JUNDIAI', 'RUA ALFREDO GUEDES', '1949', 'PIRACICABA', 'SP', '(19) 3412-2555', '2024-04-29 00:00:00');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_produto`
--

CREATE TABLE `tb_produto` (
  `pro_codigo` int NOT NULL,
  `pro_foto` varchar(250) NOT NULL,
  `for_fantasia` varchar(120) NOT NULL,
  `pro_descricao` varchar(250) NOT NULL,
  `pro_descricao_add` varchar(250) NOT NULL,
  `pro_custo` decimal(6,2) NOT NULL,
  `pro_indice` int NOT NULL,
  `pro_valor` decimal(6,2) NOT NULL,
  `pro_tamanho` varchar(30) NOT NULL,
  `pro_aluguel` varchar(100) NOT NULL,
  `pro_qtde` int NOT NULL,
  `pro_cor` varchar(10) NOT NULL,
  `pro_status` varchar(10) NOT NULL,
  `pro_tipo` varchar(255) NOT NULL,
  `pro_data_cadastro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `tb_produto`
--

INSERT INTO `tb_produto` (`pro_codigo`, `pro_foto`, `for_fantasia`, `pro_descricao`, `pro_descricao_add`, `pro_custo`, `pro_indice`, `pro_valor`, `pro_tamanho`, `pro_aluguel`, `pro_qtde`, `pro_cor`, `pro_status`, `pro_tipo`, `pro_data_cadastro`) VALUES
(1, 'fotos/1666553540.png', 'ROUPARIA MODA FEMININA EIRELI', 'Vestido branco', 'Vestido ROUPARIA FEMININA EIRELI', 900.00, 200, 700.00, 'M', 'Sim', 20, 'BRANCO', '', 'Longo', '2022-10-23 00:00:00'),
(3, 'fotos/1666572760.jpg', 'CELINA MEDEIROS ROUPARIA LTDA', 'Anel', 'Anel CELINA', 300.00, 250, 50.00, 'UN', 'Não', 30, 'DOURADO', '', 'Selecione...', '2022-10-23 00:00:00'),
(4, 'fotos/1667055867.png', 'ESTILO ROUPARIA LTDA', 'Vestido Preto ', 'Vestido preto(Estilo rouparia LTDA)', 1000.00, 100, 900.00, 'M', 'Sim', 25, 'PRETO', '', 'Curto', '2022-10-29 00:00:00'),
(7, 'fotos/1667057189.png', 'ROUPARIA MODA FEMININA EIRELI', 'Vestido longo Vermelho', 'S/N', 1000.00, 100, 900.00, 'G', 'SIM', 1, 'Vermelho', 'Ativo', 'Longo', '2025-06-08 11:31:29'),
(8, 'fotos/vestido_roxo.jpg', 'LINNA ROUPAS E ACESSORIOS EIRELI', 'Vestido logo', 'S/N', 1000.00, 100, 900.00, 'G', 'NÃO', 1, 'ROXO', 'ATIVO', 'Longo', '2025-06-11 13:46:24'),
(9, 'fotos/vestido_roxo.jpg', 'LINNA ROUPAS E ACESSORIOS EIRELI', 'Vestido logo', 'S/N', 1000.00, 100, 900.00, 'G', 'NÃO', 1, 'ROXO', 'ATIVO', 'Longo', '2025-06-11 13:46:24'),
(10, 'fotos/vestido_roxo.jpg', 'LINNA ROUPAS E ACESSORIOS EIRELI', 'Vestido logo', 'S/N', 1000.00, 100, 900.00, 'G', 'NÃO', 1, 'ROXO', 'ATIVO', 'Longo', '2025-06-11 13:46:24');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_vendedor`
--

CREATE TABLE `tb_vendedor` (
  `ven_codigo` int NOT NULL,
  `ven_nome` varchar(120) NOT NULL,
  `ven_empresa` varchar(120) NOT NULL,
  `ven_email` varchar(40) NOT NULL,
  `ven_data_cadastro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `tb_vendedor`
--

INSERT INTO `tb_vendedor` (`ven_codigo`, `ven_nome`, `ven_empresa`, `ven_email`, `ven_data_cadastro`) VALUES
(1, 'Vanessa', 'Amiss ModaFesta', 'vanessa@gmail.com', '2022-08-18 00:00:00'),
(2, 'Jessica', 'Amiss ModaFesta', 'jessica@gmail.com', '2022-08-18 00:00:00'),
(3, 'Vania', 'Amiss ModaFesta', 'vania@gmail.com', '2022-08-18 00:00:00'),
(4, 'Aline', 'Amiss ModaFesta', 'aline@gmail.com', '2022-08-18 00:00:00'),
(5, 'Debora', 'Amiss ModaFesta', 'deborah@gmail.com', '2022-08-18 00:00:00'),
(6, 'Joyce', 'Amiss ModaFesta', 'joyce@gmail.com', '2022-08-18 00:00:00'),
(7, 'Jamilly', 'Amiss ModaFesta', 'jamilly@gmail.com', '2022-08-18 00:00:00'),
(8, 'Aline Gusmao', 'Amiss ModaFesta', 'aline@gmail.com', '2022-08-18 00:00:00'),
(10, 'Lourdes', 'Amiss ModaFesta', 'lourdes@gmail.com', '2022-08-18 00:00:00'),
(15, 'VItor', 'Amiss', 'vitor@gmail.com', '2025-06-09 00:00:00'),
(16, 'Robson', 'Amiss Moda', 'robson@gmail.com', '2025-06-09 00:00:00');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `tb_aluguel`
--
ALTER TABLE `tb_aluguel`
  ADD PRIMARY KEY (`alu_codigo`);

--
-- Índices de tabela `tb_cliente`
--
ALTER TABLE `tb_cliente`
  ADD PRIMARY KEY (`cli_codigo`);

--
-- Índices de tabela `tb_fornecedor`
--
ALTER TABLE `tb_fornecedor`
  ADD PRIMARY KEY (`for_codigo`);

--
-- Índices de tabela `tb_produto`
--
ALTER TABLE `tb_produto`
  ADD PRIMARY KEY (`pro_codigo`);

--
-- Índices de tabela `tb_vendedor`
--
ALTER TABLE `tb_vendedor`
  ADD PRIMARY KEY (`ven_codigo`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_aluguel`
--
ALTER TABLE `tb_aluguel`
  MODIFY `alu_codigo` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT de tabela `tb_cliente`
--
ALTER TABLE `tb_cliente`
  MODIFY `cli_codigo` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de tabela `tb_fornecedor`
--
ALTER TABLE `tb_fornecedor`
  MODIFY `for_codigo` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de tabela `tb_produto`
--
ALTER TABLE `tb_produto`
  MODIFY `pro_codigo` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de tabela `tb_vendedor`
--
ALTER TABLE `tb_vendedor`
  MODIFY `ven_codigo` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
