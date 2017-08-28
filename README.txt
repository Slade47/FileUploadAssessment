* File Upload Spring Boot Application

This is a spring boot web application, which provides REST web services and web page views for the following functionalities:
I. Upload files and store them in the local machine
II. Store the meta data of that file to a local database.  


* Software Requirments

Java 8
Oracle 12c Database
Any browser 


* Note

I. This application stores uploaded files in a local folder on the running machine. Feel free to alter the folder directory to fit your runtime environment. 
II. This application connectes to Oracle 12c database with Hibernate framework, feel free to alter the configurations in application.properties file to connect to your own database


* Running

I. Run the spring boot application. Open up your browser and type in the proper url for your runtime environment with the server port 8080.
II. Click the Select Files button to select the file to upload, and feel free to add description to this file if needed, then click Upload button. 
III. A record will appear in the Upload Records aera. 


* Testing

This application includes two unit tests, one is for the upload controller test, the other is for the file-storage method test.   


* Author

Michael Fan, all rights reserved, Aug 2017 