drop table time if exists;

create table time(timecolumn timestamp not null, temperature int not null, primary key(timecolumn));