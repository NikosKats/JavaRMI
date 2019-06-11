# JavaRMI

Remote Procedure Invocation (RMI) allows applications to call methods from remote objects to share resources and process load between systems. Unlike other remote execution systems that only allow the transport of simple data types or specific structures, the RMI allows any Java object to be used even if the server has not reconnected. RMI allows both the client and the server to dynamically load new types of objects.

RMI applications typically consist of two separate programs: the server and the client. A typical server application creates a few remote objects, references to them to be accessible, and awaits customers to call methods on them. A typical client application calls methods on remote objects through a remote reference. RMI provides the mechanism for communication between the server and the client. Such applications are also referred to as distributed object applications.

You should use the RMI communication mechanism to implement a client-server application. More specifically, the various clients who are logged on and registered on the central server should be notified of various events taking place there.

<img width="849" alt="Screenshot 2019-06-11 at 13 24 55" src="https://user-images.githubusercontent.com/26749680/59264711-661b9e80-8c4c-11e9-9a8a-1f1462251c2b.png">

<img width="851" alt="Screenshot 2019-06-11 at 13 25 02" src="https://user-images.githubusercontent.com/26749680/59264713-66b43500-8c4c-11e9-96ef-625dd8e41e08.png">


<img width="807" alt="Screenshot 2019-06-11 at 13 25 19" src="https://user-images.githubusercontent.com/26749680/59264717-66b43500-8c4c-11e9-829d-f90d2cd4d901.png">

<img width="799" alt="Screenshot 2019-06-11 at 13 25 08" src="https://user-images.githubusercontent.com/26749680/59264714-66b43500-8c4c-11e9-90ab-e0db3832f643.png">

<img width="804" alt="Screenshot 2019-06-11 at 13 25 25" src="https://user-images.githubusercontent.com/26749680/59264710-661b9e80-8c4c-11e9-80d5-c50bf0aeac63.png">



