all : mypluginwithjni_actions_SampleAction.h

mypluginwithjni_actions_SampleAction.h : bin/mypluginwithjni/actions/SampleAction.class SampleAction.c
	javah -classpath bin -jni mypluginwithjni.actions.SampleAction
	gcc -shared -I /usr/lib/jvm/java-6-sun/include -I /usr/lib/jvm/java-6-sun/include/linux   SampleAction.c -o libsampleaction.so


clean :
	rm mypluginwithjni_actions_SampleAction.h 
	rm -rf *~
