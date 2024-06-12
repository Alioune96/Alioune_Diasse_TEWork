-- INNER JOIN

-- Write a query to retrieve the name and state abbreviation for the 2 cities named "Columbus" in the database
SELECT city_name, state_abbreviation
FROM city
WHERE city_name = 'Columbus'
;


-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).
-- table_name.column_name
SELECT city.city_name, state.state_name
FROM city 
INNER JOIN state ON city.state_abbreviation = state.state_abbreviation
;



-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)
SELECT park.park_name, park_state.state_abbreviation 
FROM park_state
INNER JOIN park ON park_state.park_id = park.park_id;


-- The park_state table is an associative table that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names of the states rather than their abbreviations.
SELECT park.park_name, state.state_name 
FROM park_state
INNER JOIN park ON park_state.park_id = park.park_id
INNER JOIN state ON park_state.state_abbreviation = state.state_abbreviation
;

-- Modify the previous query to include the name of the state's capital city.
SELECT park.park_name, state.state_name, city.city_name 
FROM park_state
INNER JOIN park ON park_state.park_id = park.park_id
INNER JOIN state ON park_state.state_abbreviation = state.state_abbreviation
INNER JOIN city ON state.capital = city.city_id
;



-- Modify the previous query to include the area of each park.
SELECT park.park_name, state.state_name, city.city_name, park.area 
--SELECT * --park_name, state_name, city_name
FROM park_state
INNER JOIN park ON park_state.park_id = park.park_id
INNER JOIN state ON park_state.state_abbreviation = state.state_abbreviation
INNER JOIN city ON state.capital = city.city_id
;


SELECT * --park.park_name, state.state_name, city.city_name, park.area 
FROM city
INNER JOIN state ON state.capital = city.city_id
INNER JOIN park_state ON park_state.state_abbreviation = state.state_abbreviation
INNER JOIN park ON park.park_id = park_state.park_id
;


SELECT p.park_name, s.state_name, c.city_name, p.area
FROM park p
JOIN park_state ps USING(park_id)
JOIN state s USING(state_abbreviation)
JOIN city c ON s.capital = c.city_id
;


-- Write a query to retrieve the names and populations of all the cities in the Midwest census region.
SELECT c.city_name, c.population
FROM state s
JOIN city c USING(state_abbreviation)
WHERE s.census_region = 'Midwest'
ORDER BY s.state_name, c.city_name
;




-- Write a query to retrieve the number of cities in the city table for each state in the Midwest census region.
SELECT state_abbreviation, COUNT(*) AS number_of_cities
FROM city
JOIN state USING(state_abbreviation)
WHERE census_region = 'Midwest'
GROUP BY state_abbreviation
ORDER BY number_of_cities DESC
;


-- Modify the previous query to sort the results by the number of cities in descending order.


-- LEFT JOIN

-- Write a query to retrieve the state name and the earliest date a park was established in that state (or territory) for every record in the state table that has park records associated with it.
SELECT state.state_abbreviation, MIN(park.date_established)
FROM state
LEFT JOIN park_state ON park_state.state_abbreviation = state.state_abbreviation
LEFT JOIN park USING(park_id)
GROUP BY state.state_abbreviation
ORDER BY state.state_abbreviation

;


-- Modify the previous query so the results include entries for all the records in the state table, even if they have no park records associated with them.



-- MovieDB
-- After creating the MovieDB database and running the setup script, make sure it is selected in pgAdmin and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres
SELECT * FROM genre;


-- The titles of all the Comedy movies
SELECT movie.title, genre.genre_name 
FROM movie
INNER JOIN movie_genre USING(movie_id)
INNER JOIN genre USING(genre_id)
WHERE genre_name = 'Comedy'
;


