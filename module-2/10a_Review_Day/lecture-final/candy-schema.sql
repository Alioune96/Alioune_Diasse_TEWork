START TRANSACTION;

-- competitorname,chocolate,fruity,caramel,peanutyalmondy,nougat,crispedricewafer,hard,bar,pluribus,sugarpercent,pricepercent,winpercent
CREATE TABLE candy (
	candy_id serial PRIMARY KEY,
	competitorname varchar(50) NOT NULL,
	chocolate boolean NOT NULL,
	fruity boolean NOT NULL,
	caramel boolean NOT NULL,
	peanutyalmondy boolean NOT NULL,
	nougat boolean NOT NULL,
	crispedricewafer boolean NOT NULL,
	hard boolean NOT NULL,
	bar boolean NOT NULL,
	pluribus boolean NOT NULL,
	sugarpercent numeric NOT NULL,
	pricepercent numeric NOT NULL,
	winpercent numeric NOT NULL
);


COMMIT;