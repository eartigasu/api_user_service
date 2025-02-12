create table phone (id bigint generated by default as identity, citycode varchar(255), contrycode varchar(255), number varchar(255), primary key (id));
create table user_example (id uuid not null, created timestamp(6), email varchar(255), is_active boolean not null, last_login timestamp(6), modified timestamp(6), name varchar(255), password varchar(255), token TEXT, primary key (id));
create table user_example_phones (user_id uuid not null, phones_id bigint not null);
alter table if exists user_example_phones drop constraint if exists UK_squuer06v53em2i7v9b14jj80;
alter table if exists user_example_phones add constraint UK_squuer06v53em2i7v9b14jj80 unique (phones_id);
alter table if exists user_example_phones add constraint FKlotu41r377oaebuuwqmpyipnn foreign key (phones_id) references phone;
alter table if exists user_example_phones add constraint FKq0svv97gkb6nb6wdr1s9lbobt foreign key (user_id) references user_example;
