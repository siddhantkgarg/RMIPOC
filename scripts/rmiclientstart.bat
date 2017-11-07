@echo off
set CLASSPATH=

cd C:\Users\sigarg\ecworkspace\RMIClient\src

IF EXIST C:\Users\sigarg\ecworkspace\clientbuild (
rmdir /s C:\Users\sigarg\ecworkspace\clientbuild
echo "client build folder deleted"
)
mkdir C:\Users\sigarg\ecworkspace\clientbuild
echo "compiling code to clientbuild folder ..."
 javac -cp ".;C:\Users\sigarg\ecworkspace\commonbuild\common.jar" -d C:\Users\sigarg\ecworkspace\clientbuild   *.java
cd C:\Users\sigarg\ecworkspace\clientbuild
 echo "Creating jar ... "
jar cvf client.jar *
echo "Running java command..."
java -cp C:\Users\sigarg\ecworkspace\clientbuild;C:\Users\sigarg\ecworkspace\clientbuild\client.jar;C:\Users\sigarg\ecworkspace\commonbuild\common.jar; -Djava.rmi.server.codebase=file:\\\C:\Users\sigarg\ecworkspace\clientbuild\client.jar -Djava.security.policy=file:\\\C:\Users\sigarg\ecworkspace\RMIClient\src\client.policy   Client MININT-SRV47SP.fareast.corp.microsoft.com


rem -Djava.security.debug=access,failure