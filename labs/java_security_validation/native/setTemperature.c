#include <jni.h>
#include "headers/security_BoilerManagerWithValidation.h"
#include <stdio.h>

JNIEXPORT void JNICALL Java_security_BoilerManagerWithValidation_setTemperature(JNIEnv *env, jobject obj,jstring boilerId,jint temperature)
{
	const char *id= (*env)->GetStringUTFChars(env,boilerId,0);

	printf("Temperature %d C updated for %s\n",temperature,id);
	printf("Status: Normal");


}

JNIEXPORT void JNICALL Java_security_BoilerManagerWithoutValidation_setTemperature(JNIEnv *env, jobject obj,jstring boilerId,jint temperature)
{
const char *id= (*env)->GetStringUTFChars(env,boilerId,0);

if(temperature>300){
	printf("Temperature %d C updated for %s\n",temperature,id);
	printf("Status: Boiler burnt");
}
else if(temperature<100){
	printf("Temperature %d C updated for %s\n",temperature,id);
	printf("Status: Boiler frozen");

}else{
	printf("Temperature %d C updated for %s\n",temperature,id);
	printf("Status: Normal");
}

}
