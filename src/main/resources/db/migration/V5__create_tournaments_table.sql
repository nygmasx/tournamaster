CREATE TABLE IF NOT EXISTS tournaments
(
    id       UUID NOT NULL,
    name     VARCHAR(255),
    city     VARCHAR(255),
    state    VARCHAR(255),
    country  VARCHAR(255),
    owner_id UUID,
    CONSTRAINT pk_tournaments PRIMARY KEY (id)
);