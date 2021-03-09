# Sample code for establishing SSL connection to Aurora MySQL DB from Java

## Pre-requisites
-  JDK 11
- Java Key Store file (JKS)



## Steps to execute

### Setup JKS 
Optional step. This step is not required to be executed for this example. This can be used as reference when creating a new JKS file.
JKS file is already created based on RDS CA and included in this example. The following steps were followed to setup the JKS file. 

1. Download RDS CA certificate (rds-ca-2019-root.pem) from https://s3.amazonaws.com/rds-downloads/rds-ca-2019-root.pem
2. Convert the certificate to .der format
    ```
    openssl x509 -outform der -in rds-ca-2019-root.pem -out rds-ca-2019-root.der
    ```
3. Import the certificate into the keystore. Set the password for keystore and trust the certificate
    ```
    keytool -import -alias rds-root -keystore clientkeystore.jks -file rds-ca-2019-root.der                    
    ```

### Setup application

1. Checkout code
    ```
    git clone https://github.com/abhishekjawali/java-mysql-ssl.git
    ```
2.  [Optional] If new keystore is generated, then add the file to classpath. For this example, this step can be skipped.
3.  Update the DB credentials in DemoApplication.java (src/main/java/com/example/demo/DemoApplication.java)
    >    a. Replace DB-USER-NAME with the database user name
    
    >    b. Replace DB-PASSWORD with the database password
    
    >    c. Replace DB_URL with the database URL.
5.  Build the application
    ```
    .\mvnw.cmd clean install
    ```
5. Run the application. 
    ```
    java -jar target\demo-0.0.1-SNAPSHOT.jar
    ```
