-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie.
-- Order the results by movie title (A-Z)
-- (73 rows)
SELECT title, k.person_name FROM movie AS m
JOIN movie_actor AS a ON  a.movie_id = m.movie_id
JOIN person as k On a.actor_id = k.person_id
WHERE a.actor_id = k.person_id AND m.director_id = a.actor_id
ORDER BY title ASC;

