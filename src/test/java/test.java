import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tan Lianwang
 * @title: test
 * @date 2022/1/20 13:58
 */
public class test {

//        public static void main(String[] args) {

//            Map<String,String> map = new HashMap<String, String>();
//
//            map.put("xiaocui1","gongchen");
//            map.put("xiaocui2","daima");
//            map.put("xiaocui3","xuexi");
//            map.put("xiaocui4","dagong");
//
//            System.out.println(map.keySet());
//
//            System.out.println("-----分割线-----");
//            for(String map1 : map.keySet()){
//                System.out.println(map1);
//
//
//            }


//        }

    /**
     * 这个问题可以通过动态规划来解决，实际上它与斐波那契数列非常相似。当你站在第`n`阶台阶时，你可以从第`n-1`阶一步走到，或者从第`n-2`阶两步走到。因此，到达第`n`阶的方法数等于到达第`n-1`阶的方法数加上到达第`n-2`阶的方法数。
     * 我们可以定义一个递推公式如下：
     * - `f(n) = f(n-1) + f(n-2)` 其中 `n > 1`
     * - `f(0) = 1` （假设有一个方法可以“走”0步）
     * - `f(1) = 1` （只有一种方法走到第一级台阶）
     * @param n
     * @return
     */
    // 使用较少的空间复杂度计算n阶台阶有多少种走法
    public static int countWaysOptimized(int n) {
        if (n <= 1) {
            return 1;
        }

        int prev = 1, curr = 1; // 初始化前两个状态
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr; // 更新当前状态
            prev = temp; // 更新前一个状态
        }

        return curr;
    }

    public static void main(String[] args) {
        int n = 5; // 假设我们要计算5阶台阶的走法
        System.out.println("Number of ways to reach " + n + " steps: " + countWaysOptimized(n));

        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();


        stringThreadLocal.set("hello");
        System.out.println(stringThreadLocal.get());
        stringThreadLocal.remove();
        System.out.println(stringThreadLocal.get());

    }



}
