insert into kpacks (title, descr, cr_date) values ('Test title pack - 1', 'Test description pack - 1', '2023-01-01');
insert into kpacks (title, descr, cr_date) values ('Test title pack - 2', 'Test description pack - 2', '2023-01-02');
insert into kpacks (title, descr, cr_date) values ('Test title pack - 3', 'Test description pack - 3', '2023-01-03');
insert into kpacks (title, descr, cr_date) values ('Test title pack - 4', 'Test description pack - 4', '2023-01-04');
insert into kpacks (title, descr, cr_date) values ('Test title pack - 5', 'Test description pack - 5', '2023-01-05');

insert into kpacksets (title) values ('Test pack set title - 1');
insert into kpacksets (title) values ('Test pack set title - 2');
insert into kpacksets (title) values ('Test pack set title - 3');
insert into kpacksets (title) values ('Test pack set title - 4');
insert into kpacksets (title) values ('Test pack set title - 5');

insert into pack_set_cross (pack_id, set_id) values ('1', '1');
insert into pack_set_cross (pack_id, set_id) values ('1', '2');
insert into pack_set_cross (pack_id, set_id) values ('2', '3');
insert into pack_set_cross (pack_id, set_id) values ('2', '4');
insert into pack_set_cross (pack_id, set_id) values ('3', '4');
insert into pack_set_cross (pack_id, set_id) values ('3', '5');
insert into pack_set_cross (pack_id, set_id) values ('4', '1');
insert into pack_set_cross (pack_id, set_id) values ('4', '2');
insert into pack_set_cross (pack_id, set_id) values ('5', '3');
insert into pack_set_cross (pack_id, set_id) values ('5', '4');
insert into pack_set_cross (pack_id, set_id) values ('5', '5');