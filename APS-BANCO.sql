CREATE DATABASE "APS"
TEMPLATE = template0
ENCODING = 'WIN1252'
CONNECTION LIMIT = -1;

CREATE TABLE Tb_Item(
cod_item	INTEGER,
nome		VARCHAR(60),
descricao	VARCHAR(100),
tp_item		INTEGER,
valor_unitario  NUMERIC,
cod_barra	INTEGER,
CONSTRAINT pk_tb_item_cod_item PRIMARY KEY(cod_item));

CREATE TABLE Tb_Usuario(
cod_usuario	VARCHAR(15),
senha		VARCHAR(12),
nome_usuario	VARCHAR(60),
tp_usuario	INTEGER,
CONSTRAINT pk_tb_usuario_cpf_usuario PRIMARY KEY(cod_usuario));

CREATE TABLE Tb_Fornecedor(
cnpj		VARCHAR(20),
nome		VARCHAR(60),
CONSTRAINT pk_tb_fornecedor_cnpj PRIMARY KEY(cnpj));

CREATE TABLE Tb_Localizacao(
cod_localizacao		INTEGER,
nome			VARCHAR(60),
setor			VARCHAR(30),
cpf_responsavel		VARCHAR(15),
CONSTRAINT pk_tb_localizacao_cod_localizacao PRIMARY KEY (cod_localizacao));

CREATE TABLE Tb_Funcionario(
cpf_funcionario		VARCHAR(14),
cod_localizacao 	INTEGER,
nome_funcionario	VARCHAR(60),
cargo_funcionario	VARCHAR(30),
sit_funcionario		INTEGER,
dt_entrada		DATE,
CONSTRAINT pk_tb_funcionario_cpf_funcionario PRIMARY KEY (cpf_funcionario),
CONSTRAINT fk_tb_funcionario_cod_localizacao FOREIGN KEY (cod_localizacao)
	REFERENCES Tb_Localizacao (cod_localizacao));

CREATE TABLE Tb_Pedido_Compra(
cod_compra	 	VARCHAR(200),
cpf_funcionario 	VARCHAR(14),
cnpj			VARCHAR(20),
valor_total		NUMERIC,
Dt_Pedido		DATE,
CONSTRAINT pk_tb_pedido_compra_cod_compra PRIMARY KEY(cod_compra),
CONSTRAINT fk_tb_pedido_compra_cpf_responsavel FOREIGN KEY (cpf_funcionario)
	REFERENCES Tb_Funcionario (cpf_funcionario),
CONSTRAINT fk_tb_pedido_compra_cnpj FOREIGN KEY (cnpj)
	REFERENCES Tb_Fornecedor (cnpj));

CREATE TABLE Tb_Pedido_Venda(
cod_venda		VARCHAR(200),
cod_usuario		VARCHAR(15),
valor_total		NUMERIC,
dt_entrada		DATE,
CONSTRAINT pk_tb_pedido_venda_cod_pedido PRIMARY KEY(cod_pedido),
CONSTRAINT fk_tb_pedido_venda_cod_usuario FOREIGN KEY(cod_usuario)
	REFERENCES Tb_Usuario (cod_usuario));

CREATE TABLE Tb_Ordem(
nota_fiscal		VARCHAR(200),
cod_item		INTEGER,
quantidade		INTEGER,
tp_ordem		INTEGER,
CONSTRAINT pk_tb_ordem_nota_fiscal_cod_item PRIMARY KEY(nota_fiscal,cod_item),
CONSTRAINT fk_tb_ordem_cod_item FOREIGN KEY(cod_item)
	REFERENCES Tb_Item (cod_item));

CREATE TABLE Tb_Estoque(
cod_item_estoque	INTEGER,
nota_fiscal		VARCHAR(200),
cod_localizacao		INTEGER,
quantidade		INTEGER,
CONSTRAINT pk_tb_estoque_cod_item_estoque PRIMARY KEY (cod_item_estoque),
CONSTRAINT fk_tb_estoque_cod_localizacao FOREIGN KEY (cod_localizacao)
	REFERENCES Tb_Localizacao (cod_localizacao));

SELECT * FROM Tb_Funcionario;
DELETE FROM Tb_Funcionario;