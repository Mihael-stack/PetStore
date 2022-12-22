Assumption: A user is going to buy one pet per Buy operation ( user can have many pets )
Assumption: History log for buy-transactions will be kept in database;
Restrictions: create-users budget will be bound between 0 and 25 $, to avoid big numbers. ( all attributes are random )
Restrictions: create-pets age of pets will be bound between 0 and 20 years. ( all attributes are random, except price which is calculated )

Starting Project: mvn clean compile package
Build And Run PetStoreApplication.class

Database used: H2 database as a file, i suggest you remove the database file and run the REST endpoints,
or you could run the REST endpoints with the already existing data.