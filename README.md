# Sample code for establishing SSL connection to Aurora MySQL DB from Java

## Pre-requisites
-  JDK 11
- Java Key Store file (JKS)



## Steps to execute

### Setup JKS 
Optional step. JKS file is already created based on RDS CA and included in this example. The following steps were followed to setup the JKS file. 

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
2.  [Optional] If new keystore is generated, then add the file to classpath
3.  Update the DB credentials in DemoApplication.java
4.  Build the application
    ```
    .\mvnw.cmd clean install
    ```
5. Run the application. 
