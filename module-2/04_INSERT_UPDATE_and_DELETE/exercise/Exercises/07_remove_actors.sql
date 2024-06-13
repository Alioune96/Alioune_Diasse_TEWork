-- 7. Remove the actor appearances in "Avengers: Infinity War" (14 rows)
-- Note: Don't remove the actors themeselves, just make it so it seems no one appeared in the movie.



UPDATE movie_actor 
SET actor_id = null
WHERE actor_id in (SELECT actor_id FROM movie_actor as ma
JOIN movie AS m ON ma.movie_id = m.movie_id
WHERE m.title = 'Avengers: Infinity War');

