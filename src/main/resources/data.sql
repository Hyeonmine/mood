INSERT INTO user (uid, email, password, nickname) VALUES ('exampleUid', 'example@example.com', 'examplePassword', 'exampleNickname');
INSERT INTO user (uid, email, password, nickname) VALUES ('exampleUid2', 'example@example.com', 'examplePassword', 'exampleNickname');
INSERT INTO board (uid,reg_time, title, content, hit) VALUES ('exampleUid',now(), 'Example Title', 'Example Content', 0);
INSERT INTO board (uid,reg_time, title, content, hit) VALUES ('exampleUid2',now(), 'Example Title2', 'Example Content2', 2);
INSERT INTO file (bno, file_Url, file_Name, file.file_origin) VALUES (1, 'exampleUrl', 'exampleFileName', 'exampleFileOrigin');
INSERT INTO hash (hash, bno) VALUES ('exampleHash', 1);
INSERT INTO reply (bno, uid, reply) VALUES (1, 'exampleUid', 'Example Reply');