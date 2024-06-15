INSERT INTO members (last_name, first_name, email, phone_number, date_of_birth, flag)
VALUES ('Diasse', 'Alioune', 'aliounediasse1996@yahoo.com', '215-930-4422', '1996/12/10', true),
('Diasse', 'Mouhamed', 'mouhamedkid@gmail.com','267-997-1132','2007/07/15', false),
('Diasse', 'OUma', 'oumaDiasse@gmail.com', NULL, '2002/12/21', true),
('Diasse', 'Arame', 'ArameDiasse$@gmail.com', '215-736-4155','2000/02/15',false), 
('Diasse', 'Amina', 'aminadontknow@gmail.com', NULL, '2009/04/15',false), 
('Binta', 'Diallo', 'bintadiallo6@tahoo.com', '215-200-8992', '1970/11/18', false );
SELECT * FROM members;
INSERT INTO members (last_name, first_name, email, phone_number, date_of_birth, flag)
VALUES ('Shum', 'Prancer','prancerstheDog@gmail.com',null,'02/01/2020',false),
('Shum','Nellie','nellieshum4@gmail.com','267-9931974', '4/13/1999',true);

INSERT INTO group_for (group_name)
VALUES ('Young Activist'), ('Freedom Fighter'), ('CityGroove'), ('OneForAll');
SELECT * FROM group_for;
INSERT INTO member_group
VALUES ((select member_id from members WHERE first_name ='Alioune'),(SELECT group_id FROM group_for WHERE group_name ILIKE '%freedom%'));
SELECT * FROM member_group;
INSERT INTO member_group VALUES
((SELECT member_id from members WHERE first_name = 'Amina'),(SELECT group_id from group_for WHERE group_name ILIKE '%young%')),
((SELECT member_id FROM members WHERE last_name = 'Binta'),(SELECT group_id FROM group_for WHERE group_name ILIKE '%city%')),
((SELECT member_id FROM members WHERE first_name = 'Prancer'),(SELECT group_id FROM group_for WHERE group_name ILIKE '%one%'));

INSERT INTO member_group VALUES
((SELECT member_id FROM members WHERE first_name = 'Mouhamed'),(SELECT group_id FROM group_for WHERE group_name ILIKE '%one%'));
INSERT INTO member_group VALUES
((SELECT member_id FROM members WHERE first_name = 'Alioune'),(SELECT group_id FROM group_for WHERE group_name ILIKE '%one%'));
INSERT INTO member_group VALUES
((SELECT member_id from members WHERE first_name = 'Amina'),(SELECT group_id from group_for WHERE group_name ILIKE '%freedom%'));
INSERT INTO member_group VALUES
((SELECT member_id from members WHERE first_name = 'OUma'),(SELECT group_id from group_for WHERE group_name ILIKE '%city%'));
INSERT INTO member_group VALUES
((SELECT member_id from members WHERE last_name = 'Binta'),(SELECT group_id from group_for WHERE group_name ILIKE '%One%'));


SELECT * FROM member_group;


INSERT INTO event (event_name, event_description,start_date,start_time,length_duration, group_host)
VALUES ('Softball For Youth', 'A softball game in our community to promote peace and sport','12/9/2024','8:30:00PM', 60, (SELECT group_id from group_for WHERE group_name ILIKE '%one%')),
('Soccer between friends(or enemies)', 'A soccer tournament to see how in columbus has the best 5 man team', '11/30/2024', '6"00:00PM', 400, (SELECT group_id FROM group_for WHERE group_name ILIKE '%Young%')),
('Software development in OHIO','Come check out all the cool technology being build here in Columbus', '12/25/2024', '5:00:00PM', 45, (SELECT group_id from group_for WHERE group_name IlIKE '%city%'));

SELECT * FROM attended_event;


INSERT INTO attended_event (event_id, group_attended, member_attended) VALUES ((SELECT event_id FROM event WHERE event_name ILIKE '%softball%'),(SELECT group_id FROM group_for WHERE group_name ILIKE '%young%'),(select member_id from members where first_name = 'Alioune')),
((SELECT event_id FROM event WHERE event_name ILIKE '%softball%'),(SELECT group_id FROM group_for WHERE group_name ILIKE '%young%'),(select member_id from members where first_name = 'OUma'));

INSERT INTO attended_event (event_id, group_attended, member_attended) VALUES ((SELECT event_id FROM event WHERE event_name ILIKE '%soccer%'),(SELECT group_id FROM group_for WHERE group_name ILIKE '%freedom%'),(select member_id from members where first_name = 'Prancer')),
((SELECT event_id FROM event WHERE event_name ILIKE '%softball%'),(SELECT group_id FROM group_for WHERE group_name ILIKE '%freedom%'),(select member_id from members where first_name = 'Nellie'));

INSERT INTO attended_event (event_id, group_attended, member_attended) VALUES ((SELECT event_id FROM event WHERE event_name ILIKE '%soccer%'),
																			   (SELECT group_id FROM group_for WHERE group_name ILIKE '%young%'),
																			   (select member_id from members where first_name = 'Mouhamed'));

INSERT INTO attended_event (event_id, group_attended, member_attended) VALUES ((SELECT event_id FROM event WHERE event_name ILIKE '%software%'),
																			   (SELECT group_id FROM group_for WHERE group_name ILIKE '%freedom%'),
																			   (select member_id from members where first_name = 'Alioune'));
																			   
INSERT INTO attended_event (event_id, group_attended, member_attended) VALUES ((SELECT event_id FROM event WHERE event_name ILIKE '%software%'),
																			   (SELECT group_id FROM group_for WHERE group_name ILIKE '%freedom%'),
																			   (select member_id from members where first_name = 'Nellie'));
																			   
INSERT INTO attended_event (event_id, group_attended, member_attended) VALUES ((SELECT event_id FROM event WHERE event_name ILIKE '%software%'),
																			   (SELECT group_id FROM group_for WHERE group_name ILIKE '%freedom%'),
																			   (select member_id from members where first_name = 'Arame'));

INSERT INTO attended_event (event_id, group_attended, member_attended) VALUES ((SELECT event_id FROM event WHERE event_name ILIKE '%software%'),
																			   (SELECT group_id FROM group_for WHERE group_name ILIKE '%freedom%'),
																			   (select member_id from members where first_name = 'Amina'));
																			   
INSERT INTO attended_event (event_id, group_attended, member_attended) VALUES ((SELECT event_id FROM event WHERE event_name ILIKE '%softball%'),
																			   (SELECT group_id FROM group_for WHERE group_name ILIKE '%young%'),
																			   (select member_id from members where first_name = 'Diallo'));
