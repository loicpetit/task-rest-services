-- CONNECT
\c TaskRestServices

-- TABLES
CREATE TABLE task (
    id serial PRIMARY KEY,
    msg text
);


-- DATA
INSERT INTO task(msg) VALUES('Tâche 1');
INSERT INTO task(msg) VALUES('Tâche 2');
