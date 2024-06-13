-- 11. Hollywood is remaking the classic movie "The Blob" and doesn't have a director yet. Add yourself to the person
--     table, and assign yourself as the director of "The Blob" (the movie is already in the movie table). (1 record each)



INSERT INTO person(person_id,person_name,birthday)
VALUES(1996,'Alioune Diasse','12/10/1996');
UPDATE movie SET director_id = (SELECT person_id FROM person WHERE person_name ='Alioune Diasse') WHERE movie_id = (SELECT movie_id FROM movie
WHERE title = 'The Blob');

