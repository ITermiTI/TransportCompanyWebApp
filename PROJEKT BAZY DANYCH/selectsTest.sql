use systransport;

##########################################
############# Selects test ###############
##########################################

SELECT p.package_id, count(v.review_id) as 'Ilosc recenzji' , avg(v.stars) as 'Srednia ocena'
FROM packages p
JOIN reviews v USING(package_id)
GROUP BY p.package_date
HAVING count(v.review_id)>1;