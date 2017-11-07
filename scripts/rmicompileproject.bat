@echo off
set CLASSPATH=


cd C:\Users\sigarg\ecworkspace\RMICourseSystem\src
echo hello
IF EXIST C:\Users\sigarg\ecworkspace\build (
rmdir /s C:\Users\sigarg\ecworkspace\build
echo "build folder deleted"
)
mkdir C:\Users\sigarg\ecworkspace\build
echo "compiling code to build folder ..."
 javac -cp ".;C:\Users\sigarg\ecworkspace\commonbuild\common.jar" -d C:\Users\sigarg\ecworkspace\build   Servants/*.java Server/*.java
cd C:\Users\sigarg\ecworkspace\build
 echo "Creating jar ... "
jar cvf Server123.jar *
echo "Running Java Command ..."
java -cp C:\Users\sigarg\ecworkspace\build\;C:\Users\sigarg\ecworkspace\build\Server123.jar;C:\Users\sigarg\ecworkspace\commonbuild\common.jar; -Djava.rmi.server.codebase=file:\\\C:\Users\sigarg\ecworkspace\build\Server123.jar -Djava.rmi.server.hostname=MININT-SRV47SP.fareast.corp.microsoft.com -Djava.security.policy=file:\\\C:\Users\sigarg\ecworkspace\RMICourseSystem\src\server.policy Server.Server



