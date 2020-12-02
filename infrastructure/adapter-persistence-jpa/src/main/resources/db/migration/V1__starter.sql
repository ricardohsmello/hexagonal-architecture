CREATE SEQUENCE account_uuid_seq;
CREATE SEQUENCE category_uuid_seq;
CREATE SEQUENCE finance_uuid_seq;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE "account"
(
    "uuid" uuid DEFAULT uuid_generate_v4() NOT NULL,
    "name" text NOT NULL,
    "balance" float,
    CONSTRAINT pk_account PRIMARY KEY ("uuid")
);

CREATE TABLE "category"
(
    "uuid" uuid DEFAULT uuid_generate_v4() NOT NULL,
    "type" numeric(1) NOT NULL,
    "name" text NOT NULL,
    CONSTRAINT pk_category PRIMARY KEY ("uuid")
);

CREATE TABLE "finance" (
	"uuid" uuid DEFAULT uuid_generate_v4() NOT NULL,
	"value" float,
	"description" text,
	"date_time" date,
	"category_uuid" uuid NOT NULL,
    FOREIGN KEY ("category_uuid") REFERENCES "category" ("uuid"));
);