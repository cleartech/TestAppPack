create
database testappdb;

create table kpacks
(
    id      int(11) not null auto_increment,
    title   varchar(250)  not null,
    descr   varchar(2000) not null,
    cr_date date          not null,
    primary key (id)
);

create table kpacksets
(
    id    int(11) not null auto_increment,
    title varchar(250) not null,
    primary key (id)
);

create table pack_set_cross
(
    pack_id int(11),
    set_id  int(11),
    primary key (pack_id, set_id),
    foreign key (pack_id) references kpacks (id),
    foreign key (set_id) references kpacksets (id)
);