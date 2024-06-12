-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas, sorted alphabetically.
-- (5 rows)
SELECT m.title FROM movie AS m
JOIN person AS p on p.person_id = m.director_id
JOIN collection AS c on c.collection_id = m.collection_id
WHERE c.collection_name = 'Star Wars Collection' AND p.person_name != 'George Lucas'
ORDER BY m.title ASC;


