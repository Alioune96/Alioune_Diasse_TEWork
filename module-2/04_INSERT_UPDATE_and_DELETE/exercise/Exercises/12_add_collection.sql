-- 12. Create a "Bill Murray Collection" in the collection table. For the movies that have Bill Murray in them, set
--     their collection ID to the "Bill Murray Collection". (1 row, 6 rows)


INSERT INTO collection (collection_id,collection_name)
VALUES(1234,'Bill Murray Collection');
UPDATE movie SET collection_id = 1234 WHERE movie_id in((SELECT movie_id FROM movie_actor Where actor_id = (SELECT person_id From person WHERE person_name = 'Bill Murray')));

