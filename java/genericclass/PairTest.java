package generic.genericclass;

public class PairTest {

    public static void main(String[] args) {
        String[] words = {"Mary", "has", "a", "little","lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min="+mm.getFirst());
        System.out.println("max="+mm.getSecond());
    }
}
