## Procedure to Create jar:

### Step 1: Move to the root directory of the project

### Step 2: Compile the java classes in the package security and store the output class files in target/security folder
	
			javac src/security/*.java -d target 
	
* This will create the class files in the folder target/security
		
### Step 3: Move to target folder using "cd target" command where output files are copied 

### Step 4: Create jar by using the class files created by compiler
	
	
			jar cvf security.jar security/*.class

### Step 5: The jar file will be created in the same directory
			
## Procedure to run the code without input Validation:

*	*** Note: In the run.sh file,change the native variable to the absolute path of the native folder in your machine/vm.***

### Step 1: Run the sh file using command
	
* Test 1:	

	sh run.sh security.BoilerManagerWithoutValidation B0908 650

		Output: Temperature 650 C updated for B0908
			Status: Boiler burnt

* Test 2: sh run.sh security.BoilerManagerWithoutValidation B0208 200
			
		Output: Temperature 200 C updated for B0208
			Status: Normal

				
## Procedure to run the code with input Validation:


### Step 1: Run the sh file using command
	
* Test 1: 
	
	sh run.sh security.BoilerManagerWithValidation B4308 650
		
		Output: Temperature must between 100 and 300. (or) Boiler Id must be in the format of B followed by any digits
		
* Test 2: 

    sh run.sh security.BoilerManagerWithValidation B0001 150
		
		Output: Temperature 150 C updated for B0001
			Status: Normal
