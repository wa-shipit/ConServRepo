INSERT IGNORE INTO springdb.syain (id, name, email) VALUES (1, '山田太郎', 'taro.yamada@example.com');
INSERT IGNORE INTO springdb.syain (id, name, email) VALUES (2, '佐藤花子', 'hanako.sato@example.com');
INSERT IGNORE INTO springdb.syain (id, name, email) VALUES (3, '鈴木一郎', 'ichiro.suzuki@example.com');
DELETE FROM company;
INSERT IGNORE INTO company (compid, compname, compmember, compboss) VALUES (1, '株式会社システム開発', 999, '開発太郎');
INSERT IGNORE INTO company (compid, compname, compmember, compboss) VALUES (2, 'スペシャリスト株式会社', 999, 'スペシャリスト次郎');

DELETE FROM ormitem;
INSERT INTO `ormitem` (`itemid`, `itemname`, `itembaika`, `itemgenka`) VALUES (1, 'コーヒー', 150, 50);
INSERT INTO `ormitem` (`itemid`, `itemname`, `itembaika`, `itemgenka`) VALUES (2, 'お茶', 150, 30);



--余談
--INSERT INTO でなく INSERT IGNORE INTOにすると
--主キーの値が重複したデータをINSERTするときに、
--エラーを出さずにINSERTせずスルーしてくれるよ。
--主にバッチ処理とかストアドプロシージャとかに良く使われるよ。