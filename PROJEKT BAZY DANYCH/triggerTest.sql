use systransport;

##########################################
############# Trigger test ###############
##########################################
drop trigger if exists trigger_status;


select * from transports
where transport_id=4; 

-- transport status should be "Zakonczone"

select * from cars
where car_id=4;
-- car status should be 'Przydzielono transport'

update transports set transport_status='Oczekuje'
where transport_id=4;

select * from cars
where car_id=4;
-- car status should be 'Oczekuje na przydzielenie'


##########################################
############# Selects test ###############
##########################################

SELECT count(review_id) as 'Ilosc recenzji' , avg(stars) as 'Srednia ocena'
FROM reviews;



SELECT c.client_id, count(p.package_id)
FROM packages p
JOIN clients c USING(client_id)
GROUP BY c.client_id;


SELECT review_id,content
FROM reviews 
JOIN packages  USING(package_id)
JOIN clients  USING(client_id)
JOIN user_accounts  USING(account_id)
WHERE is_enabled='1';
##########################################
############# DELETE test ################
##########################################

DELETE FROM user_accounts
WHERE account_id=10;

SELECT * 
FROM user_accounts;

SELECT *
FROM clients;
-- without client_id=10
SELECT *
FROM reviews;
-- without reviews_id=10
SELECT *
FROM packages;
-- without package_id={10,110,210}


##########################################
############# INSERT test ################
##########################################

INSERT INTO reviews(review_id, stars,content,package_id)
VALUES(null,'5','Super firma polecam cieplutko', 50);


SELECT *
FROM reviews;
-- with reviews_id=21 

-- testy do indeksow

SELECT client_email
FROM clients;

SELECT client_surname
FROM clients;

SELECT is_enabled
FROM user_accounts
JOIN clients USING(account_id)
WHERE client_city='Mayermouth';

-- testy nulla
INSERT INTO transports(transport_id,transport_city, transport_status,driver_id)
 VALUES(null,null,'Zakonczone', 5);