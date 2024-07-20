public class TestTask {
    public static void main(String[] args) {
        SimpleWordDictionary dic = new SimpleWordDictionary();
        dic.addtoDic("Gaza");
        dic.addtoDic("zamalek");
        dic.printWords('f');
        dic.addtoDic("Ball");
        dic.addtoDic("abdelrahman");
        dic.printAll();
    }
}
