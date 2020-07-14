# COVID-19-VforU-Java-Desktop-Application

Project Partner: Jayavardhini Kathika

I.  Brief Description:
VforU is an aggregator Desktop application which matches ‘requester’ to ‘volunteer’ for short-term healthcare
assistance. When deployed in a real time environment, people can use this application by signing up as
1)Requester or, 2)Volunteer. In the current pandemic scenario, a lot of people are falling sick and may need
1)immediate medical assistance, 2)essential groceries, or 3)medicines. This is causing a heavy surge on
healthcare infrastructure like ambulance and online delivery services. Therefore, we came across this idea to
design an application which can provide three types of healthcare-related services – 1)Medical Assistance,
2)pharmacy, 3)groceries. Medical Assistance covers services like picking the sick person, staying with them
until diagnosis, dropping them back home (if required), etc. Pharmacy service includes picking medicines on
the behalf of the requester. Grocery service can provide door-step delivery of groceries. Once the type of
service is requested, the application will notify volunteers in the same city about the request. When a volunteer
selects a request then the application provides contact details of the volunteer to the requester and vice versa.
The requester can then text/call the volunteer to explain the service requested in more detail

II. Requirements:
To run the application you should have following setup ready:
- Java JDK installed
- Docker installed
- Run and establish connection with Oracle Database (oracle-xe-11g)

III. Assumptions:
- It is assumed that Application will be run on Java supported platforms.
- For the current version of application it is assumed that Volunteers and Requesters will not misuse the
Application. They will use it for the purpose it is designed for.

IV. Design Pattern Used:
- Creational Patterns:Factory Method, Singleton, Builder
- Structural Patterns: Composite, Facade, Decorator
- Behavioral Patterns: Mediator, Iterator, NullObject, Strategy, Observer


V. Limitations :
- Our application is single threaded therefore, some part of the code like Singleton might not be suitable
for a multithreaded environment
- We could not implement networking or RPC APIs to show our end users(different machines) getting
alerts, but we tried to implement the functionality using Database queries


