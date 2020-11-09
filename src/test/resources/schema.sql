CREATE TABLE IF NOT EXISTS `SENDER`(
    `id`          INTEGER PRIMARY KEY,
    `code`        VARCHAR(100) NOT NULL
);
CREATE TABLE IF NOT EXISTS `SENDER_PROPERTIES`(
    `id`          INTEGER PRIMARY KEY,
    `senderId`      INTEGER NOT NULL,
    `code`        VARCHAR(100) NOT NULL,
    `property`        VARCHAR(100)
);