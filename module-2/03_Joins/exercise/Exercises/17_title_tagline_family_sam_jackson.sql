-- 17. The titles and taglines of movies that are in the "Family" genre that Samuel L. Jackson has acted in.
-- Order the results alphabetically by movie title.
-- (4 rows)
SELECT title,tagline FROM movie AS m
JOIN movie_actor as ma ON m.movie_id=ma.movie_id
JOIN person as p ON p.person_id = ma.actor_id
JOIN movie_genre AS mg on ma.movie_id = mg.movie_id
JOIN genre as g ON mg.genre_id = g.genre_id
WHERE p.person_name = 'Samuel L. Jackson' AND g.genre_name ='Family'
Order by title;

