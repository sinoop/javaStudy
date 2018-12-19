package singleton.firstImplementation;

public class FirstImplementation {
    private static FirstImplementation instance;

    private FirstImplementation() {

    }

    public static FirstImplementation getInstance(){
        if(instance == null){
            instance = new FirstImplementation();
        }
        return instance;
    }

}
