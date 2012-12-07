ojdbc-weave
===========

enable AOP with AspectJ on Oracle JDBC Drivers

Install Oracle dependencies
===========================

This build depends on some proprietary Oracle jars that are not available in a public repo. You need to download and install these dependencies into you local Maven repository following the instructions below.

Download from Oracle Technology Network (registration is required) and then install the downloaded jars into your local Maven repository.
(The versions used are the ones that we use for building and testing - you should be able to substitute for more recent versions, especially when building your own applications)


Oracle JDBC driver version 11.2.0.3 -- com.oracle.jdbc:oracle.jdbc:jar:11.2.0.3

Download from: http://download.oracle.com/otn/utilities_drivers/jdbc/11203/ojdbc6.jar

Then, install it using the command: 
      mvn install:install-file -DgroupId=com.oracle.jdbc -DartifactId=oracle.jdbc -Dversion=11.2.0.3 -Dpackaging=jar -Dfile=/path/to/ojdbc6.jar