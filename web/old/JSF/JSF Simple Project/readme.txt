Simple JSF project ---------------
Using aproach "KISS" (Keep It Simple, Stupid)

Entities:
	- Product
 	- User <- (Client, Administrator)

Actors:
+ user:
	- adm
	  - CRUD products
	- client
	  - Join products to own products list
+ product

Requirements:
	- i18n (pt_br, en_us)
	- conversion
	- validation (Hibernate Validator)
	- Authentication & authorization (GlassFish)

Steps:
	- class diagram (ok)
	- wireframes
	- close features
	- model e jpa tests (crud)
	- GUI primefaces(1)
	- i18n
	- validation
	- GUI primefaces (2)
	- conversion
	- GUI primefaces (3)
	- Authentication & authorization
	- GUI primefaces (4)
	- End :)
	
	
		
Last update: 24/07 - 00:15