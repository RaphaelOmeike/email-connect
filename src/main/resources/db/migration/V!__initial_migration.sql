create table contact
(
    id         bigint auto_increment
        primary key,
    first_name varchar(30)                        not null,
    last_name  varchar(30)                        not null,
    email      varchar(50)                        not null,
    filePath   varchar(255)                       not null,
    created_at datetime default current_timestamp not null
);