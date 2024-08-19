CREATE TABLE greeting
(
    id        UUID         NOT NULL,
    name      text NOT NULL,
    message   text NOT NULL,
    image_url text,
    video_url text,
    CONSTRAINT pk_greeting PRIMARY KEY (id)
);