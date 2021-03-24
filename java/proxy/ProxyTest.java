package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * 6.5 Proxies
 */
public class ProxyTest {

    public static void main(String[] args) {
        Object[] elements = new Object[1000];
        // fill elements with proxies for the integers 1 ... 1000
        for (int i = 0; i < 1000; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            // create a proxy object, with
            // 1st param=null(default class loader, see Chapter 9 of Volume II),
            // 2nd param=Class objects(implemented interface)
            // 3rd param= invocation handler
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }

        // Construct a random integer
        Integer key = new Random().nextInt(elements.length) + 1;
        // Search for the key, binarySearch will call compareTo.
        // Since elements are filled with proxy objects, the compareTo calls call the invoke method of TraceHandler class,
        // invoke method of TraceHandler prints the method name and parameters and then invokes compareTo on the wrapped Integer object.
        int result = Arrays.binarySearch(elements, key);
        // Print match if found
        if (result >= 0) {
            // println method calls toString on the proxy object, and that call is also redirected to the invocation handler (even though it does not belong to Comparable interface).
            System.out.println("Finding "+elements[result]);
        }
    }

}
