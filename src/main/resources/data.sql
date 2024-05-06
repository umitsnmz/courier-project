create table PUBLIC.COURIER_TRACKING
(
    ID        BIGINT not null
        primary key,
    COURIERID BIGINT,
    LAT       DOUBLE PRECISION,
    LNG       DOUBLE PRECISION,
    TIME      TIMESTAMP,
    ENTRANCE  BOOLEAN,
    STORE     CHARACTER VARYING(255)
);


create table PUBLIC.COURIER
(
    ID              BIGINT not null
        primary key,
    DATE_OF_BIRTH   CHARACTER VARYING(255),
    IDENTITY_NUMBER BIGINT,
    NAME            CHARACTER VARYING(255),
    PLATE           CHARACTER VARYING(255),
    SURNAME         CHARACTER VARYING(255)
);

INSERT INTO PUBLIC.COURIER_TRACKING (ID, COURIERID, LAT, LNG, TIME, ENTRANCE, STORE) VALUES (425, 12345, 40.99241324462897, 29.12795115858212, '2024-05-05 14:46:40.592838', true, 'Ataşehir MMM Migros');
INSERT INTO PUBLIC.COURIER_TRACKING (ID, COURIERID, LAT, LNG, TIME, ENTRANCE, STORE) VALUES (426, 12345, 40.98980560899731, 29.139624131970262, '2024-05-05 14:47:19.689415', false, null);
INSERT INTO PUBLIC.COURIER_TRACKING (ID, COURIERID, LAT, LNG, TIME, ENTRANCE, STORE) VALUES (427, 12345, 40.98873661054858, 29.14082576158374, '2024-05-05 14:47:31.946708', false, null);
INSERT INTO PUBLIC.COURIER_TRACKING (ID, COURIERID, LAT, LNG, TIME, ENTRANCE, STORE) VALUES (428, 12345, 40.98703589547959, 29.14159823776384, '2024-05-05 14:47:43.640514', false, null);
INSERT INTO PUBLIC.COURIER_TRACKING (ID, COURIERID, LAT, LNG, TIME, ENTRANCE, STORE) VALUES (429, 12345, 40.98931970276002, 29.14672662129282, '2024-05-05 14:47:57.480984', false, null);

INSERT INTO PUBLIC.COURIER (ID, DATE_OF_BIRTH, IDENTITY_NUMBER, NAME, SURNAME,PLATE ) VALUES (13245,'1999-01-01',11111111111,'TestAD','TestSOYAD','34AAA123');