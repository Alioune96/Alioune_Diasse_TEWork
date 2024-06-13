-- 3. Did you know Eric Stoltz was originally cast as Marty McFly in "Back to the Future"? Add Eric Stoltz to the list of actors for "Back to the Future" (1 row)

INSERT INTO movie_actor (actor_id,movie_id)
VALUES ((SELECT person_id FROM person WHERE person_name = 'Eric Stoltz'),(SELECT DISTINCT m.movie_id FROM movie AS m
Join movie_actor AS ma ON m.movie_id = ma.movie_id
WHERE m.title = 'Back to the Future'));


