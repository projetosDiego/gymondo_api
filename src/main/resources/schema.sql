DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS userapi;
DROP TABLE IF EXISTS subscriptionplan;

CREATE TABLE product(productId BIGINT PRIMARY KEY AUTO_INCREMENT, 
                     productName VARCHAR(255));
					 
CREATE TABLE userapi(userId BIGINT PRIMARY KEY AUTO_INCREMENT,
                     userName VARCHAR(255),
					 userCode VARCHAR(4),
					 subscriptionPlanId BIGINT,
					 subscriptionStatus VARCHAR(20),
					 dateIni TIMESTAMP,
					 dateFin TIMESTAMP,
					 pauseDateIni TIMESTAMP);
					 
CREATE TABLE subscriptionplan(planId BIGINT PRIMARY KEY AUTO_INCREMENT,
                              planName VARCHAR(255),
							  productId BIGINT,
							  duration INTEGER,
							  price DECIMAL,
							  tax DECIMAL);					 