create table parent (
    id      integer primary key,
    name    varchar ,
    age     integer
);

create table child (
    id      integer primary key,
    name    varchar ,
    age     integer,
    parent_id integer
);

ALTER TABLE child ADD CONSTRAINT FK_CHILD
    FOREIGN KEY(parent_id) REFERENCES parent(ID);