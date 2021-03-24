package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * An invocation handler that prints out the method name and parameters,
 * then invokes the original method
 */
public class TraceHandler implements InvocationHandler {
    private Object target;

    /**
     * Construct a TranceHandler
     * @param t the implicit parameter of the method call
     */
    public TraceHandler(Object t) {
        target = t;
    }

    @Override
    public Object invoke(Object o, Method m, Object[] args) throws Throwable {
        // print implicit argument, i.e. 567
        System.out.print(target);
        // print method name, i.e .compareTo
        System.out.print("."+m.getName()+"(");
        // print explicit arguments
        if(args !=null){
            for (int i = 0; i < args.length; i++) {
                // i.e. 551
                System.out.print(args[i]);
                if(i<args.length-1){
                    System.out.print(",");
                }
            }
        }
        System.out.println(")");
        // invoke actual method with wrapped object(target) , i.e. target.compareTo(args)
        return m.invoke(target, args);
    }
}
