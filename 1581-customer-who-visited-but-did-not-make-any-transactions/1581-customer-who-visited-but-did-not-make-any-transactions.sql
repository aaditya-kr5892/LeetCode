# Write your MySQL query statement below
select customer_id, count(visit_id) as count_no_trans
from visits
where visits.visit_id not in (
    select visits.visit_id
    from visits
    inner join transactions
    on visits.visit_id = transactions.visit_id
) 
group by customer_id
;