DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS userapi;
DROP TABLE IF EXISTS subscriptionplan;
DROP TABLE IF EXISTS voucher;
DROP TABLE IF EXISTS usersubscription;

CREATE TABLE product(productId BIGINT PRIMARY KEY AUTO_INCREMENT, productName VARCHAR(255));
					 
CREATE TABLE userapi(userId BIGINT PRIMARY KEY AUTO_INCREMENT, userName VARCHAR(255));
					 
CREATE TABLE subscriptionplan(planId BIGINT PRIMARY KEY AUTO_INCREMENT,
                              planName VARCHAR(255),
							  productId BIGINT,
							  duration INTEGER,
							  price DECIMAL,
							  tax DECIMAL);	

CREATE TABLE voucher(voucherId BIGINT PRIMARY KEY AUTO_INCREMENT, voucherCode VARCHAR(255), priceDescount DECIMAL, percentDescount DECIMAL);			

CREATE TABLE usersubscription(userSubscriptionId BIGINT PRIMARY KEY AUTO_INCREMENT, 
                              userId BIGINT,
							  userName VARCHAR(255),
							  planId BIGINT,
							  planName VARCHAR(255),
							  price DECIMAL,
							  tax DECIMAL,
							  dateIni TIMESTAMP,
							  dateFin TIMESTAMP,
							  duration INTEGER,
							  subscriptionStatus VARCHAR(10),
							  pauseDate TIMESTAMP);				  