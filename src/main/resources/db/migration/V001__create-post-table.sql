create table post (
  id bigint not null auto_increment,
  title varchar(50) not null,
  content varchar(255) not null,
  category varchar(50) not null,
  created_At datetime not null,
  updated_At datetime,

  primary key (id)
);