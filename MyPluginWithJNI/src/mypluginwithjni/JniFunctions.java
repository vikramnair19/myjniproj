package mypluginwithjni;

public class JniFunctions {
	 
    // volatile is needed so that multiple thread can reconcile the instance
    // semantics for volatile changed in Java 5.
    private volatile static JniFunctions singleton;

    
    public native int getNativeint(); 
	
    
    
    
    
    
    private JniFunctions() {
		System.out.println("JniFuntions is up! \n");
    }
 
    // synchronized keyword has been removed from here
    public static JniFunctions getJniFunctions() {
        // needed because once there is singleton available no need to acquire
        // monitor again & again as it is costly
        if(singleton==null) {
            synchronized(JniFunctions.class){
            // this is needed if two threads are waiting at the monitor at the
            // time when JniFunctions was getting instantiated
                if(singleton == null) {
                    singleton = new JniFunctions();
                }
            }
        }
        return singleton;
    }
 
}


