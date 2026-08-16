# Write your MySQL query statement below
select id
from Weather t
where t.temperature > (
    select y.temperature
    from Weather y
    where datediff(t.recordDate, y.recordDate) = 1
);