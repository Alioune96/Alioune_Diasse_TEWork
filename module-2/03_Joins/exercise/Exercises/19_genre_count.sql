-- 19. The genre name and the number of movies in each genre. Name the count column 'num_of_movies'.
-- Order the results from the highest movie count to the lowest.
-- (19 rows, the highest expected count is around 400).

SELECT genre_name, COUNT(*) AS num_of_movies FROM genre AS g
JOIN movie_genre AS mg ON g.genre_id = mg.genre_id
GROUP BY genre_name 
ORDER BY num_of_movies DESC;