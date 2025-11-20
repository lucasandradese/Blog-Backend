-- V1__create_table_blog

CREATE TABLE comment_tb (
        id BIGSERIAL PRIMARY KEY,
        content TEXT,
        data TIMESTAMP NULL,
        userId INTEGER NOT NULL,
        postID INTEGER NOT NULL
        CONSTRAINT fk_post_user FOREIGN KEY (userId) REFERENCES user_tb(id),
        CONSTRAINT fk_post_tag FOREIGN KEY (postId) REFERENCES post_tb(id)
)

CREATE TABLE post_tb (
        id BIGSERIAL PRIMARY KEY,
        title VARCHAR(255) NOT NULL,
        content TEXT NOT NULL,
        data TIMESTAMP NULL,
        userId INTEGER NOT NULL,
        tagId INTEGER NOT NULL
        CONSTRAINT fk_post_user FOREIGN KEY (userId) REFERENCES user_tb(id),
        CONSTRAINT fk_post_tag FOREIGN KEY (tagId) REFERENCES tag_tb(id)
)

CREATE TABLE tag_tb (
        id BIGSERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL
);

CREATE TABLE user_tb (
        id BIGSERIAL PRIMARY KEY,
        name VARCHAR(100) NOT NULL,
        email VARCHAR(100) NOT NULL UNIQUE,
        username VARCHAR(50),
        password VARCHAR(255) NOT NULL,
        role VARCHAR(50) NOT NULL
);
