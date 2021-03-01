DELETE FROM user;
DELETE FROM concept;
INSERT INTO user VALUES (1,'Bruce','Wayne','bwayne','batmansecret1'),
                        (2,'Clark','Kent','ckent','supermansecret2'),
                        (3,'Tony','Stark','tstark','ironmansecret3'),
                        (4,'Steve','Rogers','srogers','capamericasecret4'),
                        (5,'Peter','Parker','pparker','spidermansecret5'),
                        (6,'Darth','Vader','dvader','darksidesecret6');
INSERT INTO `concept` VALUES (1,1,'Blaster','Smuggler',NULL,'Weapon','Blaster pistol'),
                             (2,3,'Sentry Bot','Alliance',NULL,'Mecha','Allainace drone used for security'),
                             (3,1,'Sarif Industries','Headquarters','Building','Environment','Main Headquarters for characters'),
                             (4,1,'Adam Jensen','Main',NULL,'Character','The main character'),
                             (5,1,'Biotics','Special Powers',NULL,'Abstract','Extra special poers that some people have'),
                             (6,1,'ArcLight','Biotic','Energy','Abstract','A powerful biotic pulse blast'),
                             (7,3,'ExoSuit','Armor','Suit','Equipment','Powerful armor');
