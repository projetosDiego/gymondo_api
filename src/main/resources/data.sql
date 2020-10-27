
INSERT INTO userapi(USERNAME)VALUES('Diego Rodrigues Gomes');
	
INSERT INTO userapi(USERNAME) VALUES('Thatiana de Andrade Saldanha'	);	
	
	
INSERT INTO product(PRODUCTNAME) VALUES('Basic Product');
INSERT INTO product(PRODUCTNAME) VALUES('Medium Product');	
INSERT INTO product(PRODUCTNAME) VALUES('Full Product');

INSERT INTO subscriptionplan(planName, productId, duration, price, tax) 
VALUES('Basic Plan', select productid from product where productname = 'Basic Product', 3, 50.00, 25.00);	
																			  
INSERT INTO subscriptionplan(planName, productId, duration, price, tax) 
VALUES('Medium Plan',select productid from product where productname = 'Medium Product',6,100.00,50.00);	

INSERT INTO subscriptionplan(planName, productId, duration, price, tax) 
VALUES('Full Plan',select productid from product where productname = 'Full Product',12,200.00,100.00);	

	
INSERT INTO voucher(voucherCode, priceDescount, percentDescount) 
VALUES('1989', 10.0, 5.0);		
																  

				 