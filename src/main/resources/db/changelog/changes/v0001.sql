create table "user" (
  id SERIAL not null PRIMARY KEY,
  name varchar(255) not null,
  email varchar(255) not null
);

create table person (
  id SERIAL not null PRIMARY KEY,
  name varchar(255) not null,
  time_of_interaction timestamp without time zone,
  place_of_interaction varchar(255),
  additional_info varchar(500),
  user_id integer not null references "user" (id)
);

create table crowd (
  id SERIAL not null PRIMARY KEY,
  name varchar(255),
  count integer not null,
  time_of_interaction timestamp without time zone,
  place_of_interaction varchar(255),
  additional_info varchar(500),
  user_id integer not null references "user" (id)
);