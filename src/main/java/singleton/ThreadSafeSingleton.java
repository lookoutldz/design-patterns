package singleton;

/**
 * 带 DCL (Double-Check Lock) 的懒汉式线程安全单例
 */
public final class ThreadSafeSingleton {
    private ThreadSafeSingleton() {}
    private static volatile ThreadSafeSingleton instance;

    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    // 若单例类中无变量/方法，则 IDEA 会将其视为工具类，编译器会警告 Instantiation of utility class xxx
    public void printId() {
        System.out.println(System.identityHashCode(this));
    }

}
