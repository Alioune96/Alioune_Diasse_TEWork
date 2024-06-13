-- 4. Add a "Sports" genre to the genre table. Add the movie "Coach Carter" to the newly created genre. (1 row each)
SELECT * FROM movie_genre;
SELECT * FROM genre;

INSERT INTO genre(genre_id,genre_name)
VALUES(10, 'Sports');


INSERT INTO movie_genre (movie_id, genre_id)
VALUES ((SELECT movie_id FROM movie
WHERE title ='Coach Carter'),(SELECT genre_id FROM genre
WHERE genre_name = 'Sports'))





