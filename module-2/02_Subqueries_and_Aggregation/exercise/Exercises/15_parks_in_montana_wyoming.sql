-- 15. The park name, date established, and area for parks in Montana and Wyoming.
-- Order the results by park name alphabetically.
-- (3 rows)
SELECT park_name, date_established, area FROM park
WHERE park_id in(SELECT park_id FROM park_state
WHERE state_abbreviation in(SELECT state_abbreviation FROM state
WHERE state_name in ('Montana', 'Wyoming')))
ORDER BY park_name;