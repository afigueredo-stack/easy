-- easy.bank definition

-- Drop table

-- DROP TABLE easy.bank;

CREATE TABLE easy.bank (
	id int8 NOT NULL,
	"name" varchar NOT NULL,
	code varchar(3) NOT NULL,
	agency varchar(10) NULL,
	account varchar(40) NULL,
	"type" varchar(50) NULL, -- Tipo de conta - Pagamento/Poupança/Corrente
	CONSTRAINT bank_pk PRIMARY KEY (id)
);
CREATE UNIQUE INDEX bank_id_idx ON easy.bank USING btree (id);

-- Column comments

COMMENT ON COLUMN easy.bank."type" IS 'Tipo de conta - Pagamento/Poupança/Corrente';


-- easy.cashier definition

-- Drop table

-- DROP TABLE easy.cashier;

CREATE TABLE easy.cashier (
	id int8 NOT NULL,
	description varchar(200) NOT NULL,
	CONSTRAINT cashier_pk PRIMARY KEY (id)
);
CREATE UNIQUE INDEX cashier_id_idx ON easy.cashier USING btree (id);


-- easy.category definition

-- Drop table

-- DROP TABLE easy.category;

CREATE TABLE easy.category (
	id int8 NOT NULL,
	description varchar(100) NOT NULL,
	CONSTRAINT category_pk PRIMARY KEY (id)
);


-- easy.objective definition

-- Drop table

-- DROP TABLE easy.objective;

CREATE TABLE easy.objective (
	id int8 NOT NULL,
	description varchar(200) NOT NULL,
	target_value float4 NULL, -- Valor planejamento
	CONSTRAINT objetive_pk PRIMARY KEY (id)
);
CREATE UNIQUE INDEX objetive_id_idx ON easy.objective USING btree (id);

-- Column comments

COMMENT ON COLUMN easy.objective.target_value IS 'Valor planejamento';


-- easy."parameter" definition

-- Drop table

-- DROP TABLE easy."parameter";

CREATE TABLE easy."parameter" (
	id int8 NOT NULL,
	mode_calculate_objectives varchar(20) NOT NULL DEFAULT 'revenue'::character varying, -- Modo de calcular os objetivos
	mode_theme varchar(20) NOT NULL DEFAULT 'light'::character varying, -- Tema da aplicação - Claro ou Preto.
	CONSTRAINT parameter_pk PRIMARY KEY (id)
);
CREATE UNIQUE INDEX parameter_id_idx ON easy.parameter USING btree (id);

-- Column comments

COMMENT ON COLUMN easy."parameter".mode_calculate_objectives IS 'Modo de calcular os objetivos';
COMMENT ON COLUMN easy."parameter".mode_theme IS 'Tema da aplicação - Claro ou Preto.';


-- easy.broker definition

-- Drop table

-- DROP TABLE easy.broker;

CREATE TABLE easy.broker (
	id int8 NOT NULL,
	"name" varchar(250) NOT NULL,
	bank_id int8 NOT NULL,
	CONSTRAINT broker_pk PRIMARY KEY (id),
	CONSTRAINT broker_fk FOREIGN KEY (bank_id) REFERENCES easy.bank(id)
);
CREATE UNIQUE INDEX broker_id_idx ON easy.broker USING btree (id);


-- easy.card definition

-- Drop table

-- DROP TABLE easy.card;

CREATE TABLE easy.card (
	id int8 NOT NULL,
	description varchar(200) NOT NULL,
	date_expiration varchar(7) NULL,
	code_security int2 NULL,
	name_owner varchar NULL, -- Titular do cartão
	limit_max float8 NULL,
	"type" varchar(6) NOT NULL, -- Tipo do cartão:¶crédito=credit, ¶débito=debit, ¶ambos=both
	bank_id int8 NOT NULL,
	CONSTRAINT card_pk PRIMARY KEY (id),
	CONSTRAINT card_fk FOREIGN KEY (bank_id) REFERENCES easy.bank(id)
);
CREATE UNIQUE INDEX card_id_idx ON easy.card USING btree (id);
COMMENT ON TABLE easy.card IS 'Cartão de Crédito/Débito';

-- Column comments

COMMENT ON COLUMN easy.card.name_owner IS 'Titular do cartão';
COMMENT ON COLUMN easy.card."type" IS 'Tipo do cartão:
crédito=credit, 
débito=debit, 
ambos=both';


-- easy."user" definition

-- Drop table

-- DROP TABLE easy."user";

CREATE TABLE easy."user" (
	id int8 NOT NULL,
	username varchar(20) NOT NULL,
	email varchar(200) NOT NULL,
	phone varchar(11) NULL,
	fullname varchar(250) NOT NULL,
	"password" varchar NOT NULL,
	paramater_id int8 NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (id),
	CONSTRAINT user_fk FOREIGN KEY (paramater_id) REFERENCES easy.parameter(id)
);
CREATE UNIQUE INDEX user_id_idx ON easy."user" USING btree (id);


-- easy.entry definition

-- Drop table

-- DROP TABLE easy.entry;

CREATE TABLE easy.entry (
	id int8 NOT NULL,
	value float4 NOT NULL,
	date_entry date NOT NULL,
	date_expiration date NULL,
	description varchar(250) NOT NULL,
	type_entry int2 NOT NULL, -- 0=receita, 1=despesa
	bank_id int8 NULL,
	card_id int8 NULL,
	cashier_id int8 NULL,
	user_id int8 NOT NULL,
	category_id int8 NOT NULL,
	CONSTRAINT entry_fk FOREIGN KEY (bank_id) REFERENCES easy.bank(id),
	CONSTRAINT entry_fk_1 FOREIGN KEY (card_id) REFERENCES easy.card(id),
	CONSTRAINT entry_fk_2 FOREIGN KEY (cashier_id) REFERENCES easy.cashier(id),
	CONSTRAINT entry_fk_3 FOREIGN KEY (user_id) REFERENCES easy."user"(id),
	CONSTRAINT entry_fk_4 FOREIGN KEY (category_id) REFERENCES easy.category(id)
);
CREATE UNIQUE INDEX entry_id_idx ON easy.entry USING btree (id);

-- Column comments

COMMENT ON COLUMN easy.entry.type_entry IS '0=receita, 1=despesa';


-- easy.investment definition

-- Drop table

-- DROP TABLE easy.investment;

CREATE TABLE easy.investment (
	id int8 NOT NULL,
	description varchar NOT NULL,
	value float8 NOT NULL,
	porcentage_interest int4 NOT NULL,
	type_interest varchar NOT NULL,
	date_expiration date NULL,
	bronk_id int8 NOT NULL,
	user_id int8 NOT NULL,
	objective_id int8 NOT NULL,
	CONSTRAINT investment_pk PRIMARY KEY (id),
	CONSTRAINT investment_fk FOREIGN KEY (user_id) REFERENCES easy."user"(id),
	CONSTRAINT investment_fk_1 FOREIGN KEY (bronk_id) REFERENCES easy.broker(id),
	CONSTRAINT investment_fk_2 FOREIGN KEY (objective_id) REFERENCES easy.objective(id)
);
CREATE UNIQUE INDEX investment_id_idx ON easy.investment USING btree (id);