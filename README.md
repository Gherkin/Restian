# Restian
A simple REST Lab 

##Layout

- **api**
  - *PersonResource*
  - *ClubResource*
  - **data**
    - *Data*
    - *Person*
    - *Club*
- **config**
  - *Application*
- **persistence**
  - *DAO*
  - *GenericDAO*
  - *PersonDAO*
  - *ClubDAO*
- **Service**
  - *GenericService*
  - *PersonService*
  - *PersonServiceImpl*
  - *ClubService*
  - *ClubServiceImpl*
 
####Packages
- **api** - contains resources
- **data** - contains the resources handled by said servlets
- **config** - contains the Jersey Configuration i.e injection binds
- **persistence** - contains the Data Access Objects that work with the JPA
- **service** - contains the services that intermediate between the servlets and the Data Access Objects
