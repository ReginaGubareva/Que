create sequence hibernate_sequence start 1 increment 1;

create table answer (
    id int8 not null,
    answer varchar(2048),
    question_id int8,
    primary key (id));

create table que (
    id int8 not null,
    que_description varchar(2048),
    que_name varchar(2048),
    primary key (id));

create table question (
    id int8 not null,
    question varchar(2048),
    que_id int8,
    primary key (id));

create table result (
    result_id int8 not null,
    que_id int8,
    user_id int8,
    primary key (result_id));

create table result_data (
    data_id int8 not null,
    answer varchar(2048) not null,
    question_id int8,
    result_result_id int8,
    primary key (data_id));

create table user_role (
    user_id int8 not null,
    roles varchar(255));

create table usr (
    id int8 not null,
    activation_code varchar(255),
    active boolean not null,
    email varchar(255),
    password varchar(255) not null,
    username varchar(255) not null,
    primary key (id));

alter table if exists answer add constraint answer_question_fk foreign key (question_id) references question;
alter table if exists question add constraint question_que_fk foreign key (que_id) references que;
alter table if exists result_data add constraint result_data_result_fk foreign key (result_result_id) references result;
alter table if exists user_role add constraint user_role_usr_fk foreign key (user_id) references usr;
