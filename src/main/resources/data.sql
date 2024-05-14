INSERT INTO user (uid, email, password, nickname) VALUES ('exampleUid', 'example@example.com', 'examplePassword', 'exampleNickname');
INSERT INTO board (uid,reg_time, title, content, hit) VALUES ('exampleUid',now(), 'Example Title', 'Example Content', 0);

INSERT INTO board (uid,reg_time, title, content, hit) VALUES ('exampleUid2',now(), 'Example Title2', 'Example Content2', 2);
INSERT INTO board (uid,reg_time, title, content, hit) VALUES ('exampleUid2',now(), 'Example Title3', 'Example Content3', 2);
INSERT INTO board (uid,reg_time, title, content, hit) VALUES ('exampleUid2',now(), 'Example Title4', 'Example Content4', 2);
INSERT INTO board (uid,reg_time, title, content, hit) VALUES ('exampleUid2',now(), 'Example Title5', 'Example Content5', 2);
INSERT INTO board (uid,reg_time, title, content, hit) VALUES ('exampleUid2',now(), 'Example Title6', 'Example Content6', 2);
INSERT INTO board (uid,reg_time, title, content, hit) VALUES ('exampleUid2',now(), 'Example Title7', 'Example Content7', 2);
INSERT INTO board (uid,reg_time, title, content, hit) VALUES ('exampleUid2',now(), 'Example Title8', 'Example Content8', 2);
INSERT INTO board (uid,reg_time, title, content, hit) VALUES ('exampleUid2',now(), 'Example Title9', 'Example Content9', 2);
INSERT INTO board (uid,reg_time, title, content, hit) VALUES ('exampleUid2',now(), 'Example Title10', 'Example Content10', 2);
INSERT INTO board (uid,reg_time, title, content, hit) VALUES ('exampleUid2',now(), 'Example Title11', 'Example Content11', 2);

INSERT INTO file (bno, file_Url, file_Name, file.file_origin) VALUES (1, 'exampleUrl', 'exampleFileName', 'exampleFileOrigin');
INSERT INTO hash (hash, bno) VALUES ('exampleHash', 1);
INSERT INTO hash (hash, bno) VALUES ('exampleHash2', 1);
INSERT INTO hash (hash, bno) VALUES ('exampleHash3', 1);
INSERT INTO hash (hash, bno) VALUES ('exampleHash4', 2);
INSERT INTO reply (bno, uid, reply) VALUES (1, 'exampleUid', 'Example Reply');
# INSERT INTO heart (bno, uid) VALUES (1, 'exampleUid');

