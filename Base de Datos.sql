CREATE TABLE cliente (
cli_codigo SERIAL PRIMARY KEY ,
cli_nombre CHARACTER VARYING(80) NOT NULL,
cli_cedula INTEGER NOT NULL UNIQUE,
cli_ruc CHARACTER VARYING(15) NOT NULL UNIQUE,
cli_direcc CHARACTER VARYING(80),
cli_telefo INTEGER
);


CREATE TABLE config(
Cfg_org CHARACTER VARYING(100) NOT NULL,
Cfg_telefo CHARACTER VARYING(60)
);

CREATE TABLE detalle(
det_numero SERIAL PRIMARY KEY,
det_nroest INTEGER NOT NULL,
det_codser INTEGER REFERENCES servicio(ser_codigo)  NOT NULL,
det_monto INTEGER
);

CREATE TABLE deuda(
deu_numero SERIAL PRIMARY KEY,
deu_nroest INTEGER REFERENCES estadia(est_numero) NOT NULL,
deu_codcli INTEGER REFERENCES cliente(cli_numero) NOT NULL,
deu_monto INTEGER NOT NULL,
deu_pagado INTEGER NOT NULL
);

CREATE TABLE habita(
hab_codigo SERIAL PRIMARY KEY,
hab_descri CHARACTER VARYING(100) NOT NULL,
hab_mondia INTEGER NOT NULL,
hab_obse CHARACTER VARYING(500)
);

CREATE TABLE cobranza(
cob_codigo SERIAL PRIMARY KEY,
cob_fecha DATETIME,
cob_nrodeuda INTEGER REFERENCES deuda(deu_numero) NOT NULL,
cob_codcli INTEGER REFERENCES cliente(cli_codigo) NOT NULL,
cob_pagado INTEGER
);

CREATE TABLE estadia(
est_numero SERIAL PRIMARY KEY,
est_fecha DATETIME,
est_codcli INTEGER REFERENCES cliente(cli_codigo) NOT NULL,
est_codhab INTEGER REFERENCES habita(hab_codigo) NOT NULL,
est_fecsal DATETIME,
est_monto INTEGER,
est_desc INTEGER,
est_obse CHARACTER VARYING(500) ,
est_activo BOOLEAN
);

CREATE TABLE servicio(
ser_codigo SERIAL PRIMARY KEY,
ser_descri CHARACTER VARYING(100) NOT NULL,
ser_monto INTEGER,
ser_obse CHARACTER varying(500)
);





















