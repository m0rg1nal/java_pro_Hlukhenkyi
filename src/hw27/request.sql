create table users
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(256) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(256) NOT NULL
);
insert into users (name, age, email) values ('John', 30, 'john@example.com'),
                                            ('Alice', 25, 'alice@example.com'),
                                            ('Bob', 35, 'bob@example.com');
select * from users;
delete from users where name = 'Bob';