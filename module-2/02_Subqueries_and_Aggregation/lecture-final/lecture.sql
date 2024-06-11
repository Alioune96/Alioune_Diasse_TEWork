-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT city_name || ', ' || state_abbreviation AS city_comma_state
FROM city
;

-- The all parks by name and date established.
SELECT park_name || ' (Est: ' || date_established || ')'
FROM park
;


-- The census region and state name of all states in the West & Midwest sorted in ascending order.
SELECT state_name || ': ' || census_region AS state_and_census
FROM state
WHERE census_region ILIKE '%west'
ORDER BY state_and_census
;



-- SUBQUERIES

-- List all cities in the western census region
SELECT city_name
FROM city
WHERE state_abbreviation IN (SELECT state_abbreviation FROM state WHERE census_region = 'West' LIMIT 1)
;


SELECT state_abbreviation FROM state WHERE census_region = 'West';


-- List all cities in states with "garden" in their nickname
SELECT city_name
FROM city
WHERE state_abbreviation IN (SELECT state_abbreviation FROM state WHERE state_nickname ILIKE '%garden%');


-- Get the parks with the smallest and largest areas
SELECT park_name, area 
FROM park
WHERE area = (SELECT MAX(area) FROM park) 
   OR area = (SELECT MIN(area) FROM park)
;



-- Get the state name and census region for all states with a national park
SELECT *
FROM park;

-- park_state is an Association Table (many-to-many relationships)
SELECT DISTINCT state_abbreviation FROM park_state;

SELECT state_name, census_region
FROM state
WHERE state_abbreviation IN (
	SELECT DISTINCT state_abbreviation FROM park_state
);


-- Subqueries aren't limited to WHERE clauses, can appear in SELECT list (must return only 1 result)
-- Include state name rather than the state abbreviation while counting the number of cities in each state,
--   ordered from most cities to least.




-- AGGREGATE FUNCTIONS
-- COUNT, SUM, MIN, MAX, AVG
-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT ROUND(AVG(population), -3) AS avg_pop
FROM state
;


-- Total population in the West and South census regions
SELECT SUM(population) AS western_and_southern_populations 
FROM state
WHERE census_region IN ('West', 'South');


-- The number of cities with populations greater than 1 million
SELECT COUNT(*)
FROM city
WHERE population >= 1000000
;

-- The number of state nicknames.
SELECT COUNT(state_nickname)
FROM state
;

-- The area of the smallest and largest parks.
SELECT MIN(area) AS smallest_number, MAX(area) AS largest_number
FROM park
;


-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT state_abbreviation, COUNT(*) AS number_of_cities
FROM city
GROUP BY state_abbreviation
ORDER BY number_of_cities DESC
;


-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, SUM(area), COUNT(*), ROUND(AVG(area), 0) AS avg_area
FROM park
GROUP BY has_camping
;


-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation, SUM(population) AS total_pop
FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation
;


-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation, MIN(population) AS population_of_smallest_city
FROM city
GROUP BY state_abbreviation
ORDER BY population_of_smallest_city DESC
;
