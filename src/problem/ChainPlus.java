package problem;

/**
 * 连加 1+2+3+...+n
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 */
public class ChainPlus {

    public int plus(int n) {
        int c = 0;
        boolean b = n > 0 && ((c = plus(n - 1)) == 0);
        return n + c;
    }

    public static void main(String[] args){
        ChainPlus test = new ChainPlus();
        int result = test.plus(4);
        System.out.println(result);
    }
}
