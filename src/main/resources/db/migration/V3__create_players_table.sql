CREATE TABLE players
(
    id         UUID        NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    birth_date date        NOT NULL,
    user_id    UUID        NOT NULL,
    CONSTRAINT pk_players PRIMARY KEY (id)
);

ALTER TABLE players
    ADD CONSTRAINT uc_players_user UNIQUE (user_id);

ALTER TABLE players
    ADD CONSTRAINT FK_PLAYERS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);