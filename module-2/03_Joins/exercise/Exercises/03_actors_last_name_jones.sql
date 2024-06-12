-- 3. For all actors with the last name of "Jones", display the actor's name and movie titles they appeared in.
-- Order the results by the actor names (A-Z) and then by movie title (A-Z).
-- (48 rows)

SELECT p.person_name, m.title FROM person as p
JOIN movie_actor as ma ON p.person_id = ma.actor_id
JOIN movie as m ON ma.movie_id = m.movie_id
WHERE p.person_name in (SELECT person_name from person
WHERE person_name ILIKE  '% Jones') 
ORDER BY p.person_name, m.title ;



