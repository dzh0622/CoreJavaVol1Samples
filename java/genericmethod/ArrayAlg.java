package generic.genericmethod;

public class ArrayAlg {
    public static <T> T getMiddle(T... a){
        return a[a.length/2];
    }
}
