DROP DATABASE IF EXISTS systransport;
CREATE DATABASE systransport CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE systransport;

CREATE TABLE user_accounts
(
	 account_id INT AUTO_INCREMENT NOT NULL,
     login_email NVARCHAR(255) NOT NULL UNIQUE,
     is_enabled CHAR(1) NOT NULL,
     password_hash NVARCHAR(255) NOT NULL UNIQUE,
     date_created DATETIME DEFAULT CURRENT_TIMESTAMP,
     PRIMARY KEY (account_id)
);

CREATE TABLE clients
(
    client_id INT AUTO_INCREMENT NOT NULL,
    client_name NVARCHAR(255) NOT NULL,
    client_surname NVARCHAR(255) NOT NULL,
    client_email NVARCHAR(255) NOT NULL UNIQUE,
    client_address NVARCHAR(255) NOT NULL,
    client_PESEL NVARCHAR(11) NOT NULL UNIQUE,
    client_phone_number NVARCHAR(255) NOT NULL UNIQUE,
    client_city NVARCHAR(255) NOT NULL,
    account_id INT NOT NULL,
    PRIMARY KEY (client_id),
     FOREIGN KEY (account_id)
        REFERENCES user_accounts(account_id)
        ON DELETE CASCADE
);
 
 CREATE TABLE drivers
(
	driver_id INT AUTO_INCREMENT NOT NULL,
    driver_name NVARCHAR(255) NOT NULL,
    driver_surname NVARCHAR(255) NOT NULL,
    driver_email NVARCHAR(255) NOT NULL UNIQUE,
    driver_PESEL NVARCHAR(11) NOT NULL UNIQUE,
    driver_phone_number NVARCHAR(255) NOT NULL UNIQUE,
    account_id INT NOT NULL,
    PRIMARY KEY (driver_id),
     FOREIGN KEY (account_id)
        REFERENCES user_accounts(account_id)
        ON DELETE CASCADE
);


CREATE TABLE cars
(
	car_id INT AUTO_INCREMENT NOT NULL,
    car_reg_number NVARCHAR(255) NOT NULL UNIQUE,
    carrying_capacity DECIMAL(6,2) NOT NULL,
    car_type ENUM ('Kruche','Normalne','Niebezpieczne') NOT NULL,
    car_status ENUM ('Oczekuje na przydzielenie','Przydzielono transport') NOT NULL,
    driver_id INT,
    PRIMARY KEY (car_id),
    FOREIGN KEY (driver_id)
        REFERENCES drivers(driver_id)
        ON DELETE CASCADE
);


CREATE TABLE recipients
(
	recipient_id INT AUTO_INCREMENT NOT NULL,
    recipient_name NVARCHAR(255) NOT NULL,
    recipient_surname NVARCHAR(255) NOT NULL,
    recipient_address NVARCHAR(255) NOT NULL,
    recipient_phone_number NVARCHAR(255) NOT NULL UNIQUE,
    recipient_city NVARCHAR(255) NOT NULL,
    PRIMARY KEY (recipient_id)
);

CREATE TABLE transports
(
    transport_id INT AUTO_INCREMENT NOT NULL,
    transport_city NVARCHAR(255) NOT NULL,
    transport_status ENUM ('W trasie','Zakonczone','Oczekuje') NOT NULL,
    driver_id INT,
    PRIMARY KEY (transport_id),
	FOREIGN KEY (driver_id)
        REFERENCES drivers(driver_id)
);

CREATE TABLE packages
(
	package_id INT AUTO_INCREMENT NOT NULL,
	package_type ENUM ('Kruche','Normalne','Niebezpieczne') NOT NULL,
    package_status ENUM ('Dostarczone','Odebrane','Nieodebrane') NOT NULL,
    package_weight DECIMAL(6,2) NOT NULL,
    package_price DECIMAL(6,2) NOT NULL,
    package_priority CHAR(1) NOT NULL,
    package_date DATETIME,
    client_id INT NOT NULL,
    recipient_id INT NOT NULL,
    transport_id INT NOT NULL,
    PRIMARY KEY (package_id),
    FOREIGN KEY (client_id)
        REFERENCES clients(client_id)
        ON DELETE CASCADE,
	FOREIGN KEY (recipient_id)
        REFERENCES recipients(recipient_id)
        ON DELETE CASCADE,
	FOREIGN KEY (transport_id)
        REFERENCES transports(transport_id)
        ON DELETE CASCADE
);


CREATE TABLE reviews
(
    review_id INT AUTO_INCREMENT NOT NULL,
    stars ENUM ('1','2','3','4','5') NOT NULL,
    content NVARCHAR(255) NOT NULL,
    package_id INT NOT NULL,
    PRIMARY KEY (review_id),
    FOREIGN KEY (package_id)
        REFERENCES packages(package_id)
        ON DELETE CASCADE
);
 
delimiter &&
create trigger trigger_status
after update on transports
for each row
begin 
	if(old.transport_status= 'Zakonczone' AND new.transport_status='Oczekuje') THEN
		update cars as c
        inner join drivers as d on d.driver_id = c.driver_id
        inner join transports as t on t.driver_id = c.driver_id
        set car_status='Oczekuje na przydzielenie' 
        where t.transport_id = old.transport_id;
	end if;
end&&
delimiter ;

CREATE INDEX client_index
ON clients(client_email,client_city);

CREATE INDEX user_accounts_index
ON user_accounts(login_email);

CREATE INDEX driver_index
ON drivers(driver_email);

CREATE INDEX cars_index
ON cars(car_reg_number);

CREATE INDEX transports_index
ON transports(transport_city);

CREATE INDEX packages_index
ON packages(package_date,package_weight);

CREATE INDEX recipient_index
ON recipients(recipient_address,recipient_city);
