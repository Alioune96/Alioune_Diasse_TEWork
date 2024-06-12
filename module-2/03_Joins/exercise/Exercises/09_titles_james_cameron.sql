-- 9. The titles of movies directed by James Cameron, sorted alphabetically.
-- (6 rows)


SELECT m.title FROM movie as m
JOIN person AS p ON p.person_id = m.director_id
WHERE p.person_name = 'James Cameron'
ORDER BY m.title ASC;

