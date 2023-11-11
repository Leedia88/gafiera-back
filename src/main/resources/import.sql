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


INSERT INTO `event` (`id`, `title`, `description`, `start_date`, `owner_id`, `category_id`) VALUES (1, 'Concert Gafiera Live', 'Description 1.', STR_TO_DATE('09-06-2023', '%m-%d-%Y'), 1, 1);
INSERT INTO `event` (`id`, `title`, `description`, `start_date`, `owner_id`, `category_id`) VALUES (2, 'Concert Gafiera Live', 'Description 2.', STR_TO_DATE('12-16-2023', '%m-%d-%Y'), 1, 1);
INSERT INTO `event` (`id`, `title`, `description`, `start_date`, `owner_id`, `category_id`) VALUES (3, 'Concert Gafiera Live', 'Description 3', STR_TO_DATE('06-16-2023', '%m-%d-%Y'), 1, 1);
INSERT INTO `event` (`id`, `title`, `description`, `start_date`, `owner_id`, `category_id`) VALUES (4, 'Concert Gafiera Live', 'Description 4',STR_TO_DATE('10-06-2023', '%m-%d-%Y'), 1, 1);
INSERT INTO `event` (`id`, `title`, `description`, `start_date`, `owner_id`, `category_id`) VALUES (5, 'Concert Gafiera Live', 'Description 5', STR_TO_DATE('11-16-2023', '%m-%d-%Y'), 1, 1);

