use systransport;

##########################################
############# Views test #################
##########################################
drop view if exists packages_last_ten_days;
drop view if exists free_car;

create view packages_last_ten_days
as
select * from packages
where package_date > DATE_SUB(NOW(), INTERVAL 40 DAY) AND package_status = 'Nieodebrane';

select * from packages_last_ten_days;


create view free_car
as
select * from cars
where car_status = 'Oczekuje na przydzielenie';

select * from free_car;
