package singleton;

public class LazySingleton {
    private static volatile LazySingleton instance;

    private LazySingleton() {
        // Prevent instantiation
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}