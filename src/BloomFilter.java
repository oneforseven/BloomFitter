import java.util.BitSet;
import java.util.LinkedList;
import java.util.Objects;

public class BloomFilter {
    // 数组长度
    private int size = 107;
    private BitSet bitSet = new BitSet(size);
    // 演示定义3个哈希函数
    private String[] hashStrs = {"hash","ach","wsh"};

    public void add(Object obj) {
        LinkedList<Integer> list = new LinkedList<>();
        // 每次进行三次哈希运算
        for (int i = 0;i < 3;i++) {
             // 与哈希函数字符串拼接再哈希运算，保证运算出来的值不同
             int hash = Objects.hash(obj,hashStrs[i]);
             // 哈希如为负数转正数并对大小进行取模
             int idx = Math.abs(hash % size);
             list.add(idx);
             bitSet.set(idx);
        }
        System.out.println(list);
    }

    public boolean find(Object obj) {
        boolean res = true;
        for (int i = 0;i < 3;i++) {
            int hash = Objects.hash(obj,hashStrs);
            int idx = Math.abs(hash % size);
            res = res && bitSet.get(idx);
        }
        return res;
    }
}
