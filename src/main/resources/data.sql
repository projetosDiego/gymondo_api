
INSERT INTO userapi(USERNAME, 
                    USERCODE, 
					SUBSCRIPTIONPLANID, 
					SUBSCRIPTIONSTATUS,
     				INI, 
					FIN) 
					VALUES('Diego Rodrigues Gomes', 
					       '123', 
						   0, 
						   null, 
						   null, 
						   null);
	
INSERT INTO userapi(USERNAME, 
                    USERCODE, 
					SUBSCRIPTIONPLANID, 
					SUBSCRIPTIONSTATUS, 
    				INI, 
					FIN) 
					VALUES('Thatiana de Andrade Saldanha', 
					       '321', 
						   0, 
						   null, 
						   null, 
						   null);	
	
	
INSERT INTO product(PRODUCTNAME) VALUES('Basic Product');
INSERT INTO product(PRODUCTNAME) VALUES('Medium Product');	
INSERT INTO product(PRODUCTNAME) VALUES('Full Product');

INSERT INTO subscriptionplan(planName, 
                             productId, 
							 duration, 
							 price, 
							 tax) 
							 VALUES('Basic Plan',
                                    select productid from product where productname = 'Basic Product',
									3,
								    0,
									0);	
																			  
INSERT INTO subscriptionplan(planName, 
                             productId, 
							 duration, 
							 price, 
							 tax) 
							 VALUES('Medium Plan',
                                    select productid from product where productname = 'Medium Product',
									3,
								    0,
									0);	

INSERT INTO subscriptionplan(planName, 
                             productId, 
							 duration, 
							 price, 
							 tax) 
							 VALUES('Full Plan',
                                    select productid from product where productname = 'Full Product',
									3,
								    0,
									0);																			  

				 