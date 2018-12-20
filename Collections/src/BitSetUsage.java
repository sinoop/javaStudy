import java.util.BitSet;

public class BitSetUsage {
    public static void main(String[] args) {
        BitSet bit = new BitSet(10);
        for(int i=0;i<bit.size();i++){
            System.out.println(bit.get(i));
        }
    }
}

