-- 2. The names and birthdays of actors in "The Fifth Element"
-- Order the results alphabetically (A-Z) by name.
-- (15 rows)
SELECT p.person_name, p.birthday FROM person AS p
JOIN movie_actor AS ma ON  p.person_id = ma.actor_id
JOIN movie AS m On ma.movie_id = m.movie_id
WHERE m.title = 'The Fifth Element'
ORDER BY p.person_name;

