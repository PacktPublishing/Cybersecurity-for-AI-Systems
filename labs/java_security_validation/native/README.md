In this folder You can see the native code file setTemperature.c written in C
The shared object file in this folder will be loaded in Java code during run time.

Procedure for .so(shared object) file creation:

		****Note: The libsetTemperature.so file was already created and loaded.These steps should be followed only if you want to make changes to the C code.***

Step 1: Create the java header file
			javah -jni -d native/headers -classpath target security.BoilerManagerWithValidation
			
		The header files will be created under the directory native/headers. These files must be included in C program to build a .so file.

Step 2: Get into the native directory, Compile the C code using command,
			gcc -c -m64 setTemperature.c -I $JAVA_HOME/include/ -I $JAVA_HOME/include/linux/ -fPIC
		Compilation should have the "include and include/linux" folders in java path to import the header jni.h in C code
		
		Note: Replace $JAVA_HOME with appropriate path

Step 3: Create the shared object file using command,
			gcc -m64 setTemperature.c -I $JAVA_HOME/include/ -I $JAVA_HOME/include/linux/ -shared -fPIC -o libsetTemperature.so
			
		Note: Replace $JAVA_HOME with appropriate path. The name of the .so file should start with "lib".But no need to use lib in java code "setTemperature" is enough
