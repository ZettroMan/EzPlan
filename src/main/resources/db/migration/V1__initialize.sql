create table users
(
    id       bigserial primary key,
    username varchar(30) not null,
    password varchar(80) not null,
    email    varchar(50) unique
);

create table roles
(
    id   serial primary key,
    name varchar(50) not null
);

create table users_roles
(
    user_id bigint references users (id),
    role_id int references roles (id),
    primary key (user_id, role_id)
);

create table categories
(
    id      serial primary key,
    name    varchar(255),
    color   char(7),
    user_id bigint references users (id)
);

create table priorities
(
    id      serial primary key,
    name    varchar(255),
    value   int,
    color   char(7),
    user_id bigint references users (id)
);

create table tasks
(
    id          bigserial primary key,
    name        varchar(255),
    description varchar(65535),
    done        bit,
    weight      integer,
    archived    bit,
    category_id int references categories (id),
    priority_id int references priorities (id)
-- ,    parent_id   bigint references tasks (id)
);


insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users (username, password, email)
values ('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com');

insert into users_roles (user_id, role_id)
values (1, 1);

insert into categories (name, color, user_id)
values ('Работа', '#4fe30d', 1),
       ('Семья', '#f43ed0', 1),
       ('Учеба', '#6a1792', 1),
       ('Друзья', '#2812dd', 1);

insert into priorities (name, value, color, user_id)
values ('Уже горит!!!', 100, '#ff0000', 1),
       ('Поскорей бы...', 75, '#ff4422', 1),
       ('Норм', 50, '#888888', 1),
       ('Пока терпит +/-', 25, '#34a622', 1),
       ('Вообще не к спеху :-)', 0, '#1122dd', 1);

insert into tasks (category_id, name, description, done, weight, archived, priority_id)
values (1, 'Доделать проект', 'Закончить разработку квантового передатчика мыслей', false, 10, false, 2),
       (2, 'Сходить семьей в кино', '', false, 10, false, 5),
       (3, 'Сделать итоговый проект по спрингу', '', false, 10, false, 3),
       (3, 'Изучить Angular', 'Посмотреть гигабайты видосов из инета, пройти все доступные курсы', false, 10, false, 3),
       (3, 'Доделать бэкенд на спринге', 'Там уже ', false, 10, false, 3),
       (3, 'Сделать фронт на ангуляре', '', false, 10, false, 3),
       (4, 'Сыграть в мозгобойню', 'В следующие выходные - самое то!', false, 10, false, 2);
