public class Main {
    public static void main(String[] args) {
        BloomFilter filter = new BloomFilter();
        filter.add("bilibili.com");
        filter.add("baidu.com");
        System.out.println(filter.find("wadsdas"));
    }
}
