-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985.
-- Order the results by actor from oldest to youngest.
-- (20 rows)

SELECT DISTINCT person_name, birthday FROM person AS p
JOIN movie_actor AS ma ON p.person_id = ma.actor_id
JOIN movie as m ON ma.movie_id = m.movie_id
WHERE p.birthday>'1950-01-01' AND p.birthday < '1959-12-30' AND m.release_date > '1985-01-01' AND m.release_date < '1985-12-30'
ORDER BY birthday ;

