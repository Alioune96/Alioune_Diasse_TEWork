-- 21. For every person in the person table with the first name of "George", list the number of movies they've been in. Name the count column 'num_of_movies'.
-- Include all Georges, even those that have not appeared in any movies. Display the names in alphabetical order.
-- (59 rows)
-- TIP: This one can be a little tricky. If you're off by one, look closer at each clause of your statement. There's something you can change to get a different result set.
SELECT COUNT(m.title) AS num_of_movies, p.person_name FROM person AS p
FULL OUTER JOIN movie_actor AS ma ON  p.person_id = ma.actor_id
FULL OUTER JOIN movie as m ON m.movie_id = ma.movie_id
WHERE p.person_name ILIKE 'George %'
GROUP BY p.person_name;


