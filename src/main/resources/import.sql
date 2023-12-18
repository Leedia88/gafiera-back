INSERT INTO `category` (`name`) VALUES ('Class');
INSERT INTO `category` (`name`) VALUES ('Concert');
INSERT INTO `category` (`name`) VALUES ('Festival');
INSERT INTO `category` (`name`) VALUES ('Workshop');
INSERT INTO `category` (`name`) VALUES ('Practice');

INSERT INTO `users` (`name`, `lastname`, `email`, `password`) VALUES ('Chagas', 'Marcelo', 'mc@g.com', 'azerty');
INSERT INTO `users` (`name`, `lastname`, `email`, `password`) VALUES ('Flavia', 'Ana', 'af@g.com', 'azerty');
INSERT INTO `users` (`name`, `lastname`, `email`, `password`) VALUES ('Lacaze', 'Aline', 'lc@g.com', 'azerty');
INSERT INTO `users` (`name`, `lastname`, `email`, `password`) VALUES ('Lima', 'Marion', 'mm@g.com', 'azerty');
INSERT INTO `users` (`name`, `lastname`, `email`, `password`) VALUES ('Slack', 'Ludo', 'ls@g.com', 'azerty');


--INSERT INTO `event` (`id`, `title`, `description`, `start_date`, `place`, owner_id`, `category_id`) VALUES (1, 'Roda de Samba Live', '8 brilliant musicians around a table for an incredible show', STR_TO_DATE('09-06-2023', '%m-%d-%Y'), 'La Candela', 1, 1);
INSERT INTO `event` (`id`, `title`, `description`, `duration`, `start_date`, `place`,`owner_id`, `category_id`) VALUES (2, 'MasterClass Puladinho', 'If you love dancing samba and want to take it to the next level, then our level 2 intermediate is for you.', 20, STR_TO_DATE('12-16-2023', '%m-%d-%Y'), "Breughel l'ancien",1, 4);
INSERT INTO `event` (`id`, `title`, `description`, `duration`,`start_date`, `place`,`owner_id`, `category_id`) VALUES (3, 'Monthly Workshop', 'Focus on different techniques. For all levels', 21, STR_TO_DATE('06-16-2023', '%m-%d-%Y'), 'La Candela',1, 1);
INSERT INTO `event` (`id`, `title`, `description`, `duration`,`start_date`, `place`,`owner_id`, `category_id`) VALUES (4, 'Crash Course Beginner', 'Our Samba dance teachers are brilliant at Level 1 or beginners samba dance classes in London. They are perfect for anybody new to samba dance.',20, STR_TO_DATE('10-06-2023', '%m-%d-%Y'),'La Candela', 1, 1);
INSERT INTO `event` (`id`, `title`, `description`, `duration`,`start_date`, `place`,`owner_id`, `category_id`) VALUES (5, 'Concert Trio Padana', 'Our music is a mix of Forro and Samba. Vem dançar!', 19, STR_TO_DATE('11-16-2023', '%m-%d-%Y'), "Manding'art",1, 1);
INSERT INTO `event` (`id`, `title`, `description`, `duration`,`start_date`, `place`,`owner_id`, `category_id`) VALUES (1, 'Roda de Samba', 'New show in town', 14, STR_TO_DATE('11-16-2023', '%m-%d-%Y'), 'London Town',1, 2);

