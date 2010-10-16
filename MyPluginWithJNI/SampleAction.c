#include "mypluginwithjni_actions_SampleAction.h"
int count=0;

JNIEXPORT jstring JNICALL Java_mypluginwithjni_actions_SampleAction_getNativeMessage
  (JNIEnv * env, jobject obj)
{
    return (*env)->NewStringUTF(env, "Here's a native string in UTF8!");
}
JNIEXPORT jint JNICALL Java_mypluginwithjni_actions_SampleAction_getNativeint(JNIEnv *env, jobject obj, jint i)
{
  return myfunc();
}


int myfunc(void)
{
  return count++;
}
