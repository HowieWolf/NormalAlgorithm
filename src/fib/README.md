# 使用斐波那契数列解决的最优解

这种问题的典型提问方式就是"求最大或最小"。举例：
- 一段长 n 米的绳子，剪成 m 段，m、n 都是整数，每段长度分别是 k1, k2 ... km，求 k1 * k2 * k3 ... km 的最大值；
- 要凑齐 m 元钱，使用最少张的人民币，是多少张？如果不是人民币，他的货币是 1，5，11 元，请问又是多少张；
- 背包问题


## 思考
- 这种问题的本质不在于是递推或是递归，也不需要纠结是不是内存换时间。

## 解决思路
这种问题有三个方向：
- 穷举：不推荐，时间和空间比较浪费
- 局部最优：我们不需要找到全局最优，我们处于某一个阶段时只考虑当前阶段。例如凑钱问题，肯定是 100 元越多，相对总钱数就最少，所以如果超过 100 元，我就选择 100。
- 动态规划：穷举法不好是因为有很多方案一定不是最优，但仍然做了考虑。动态规划，尽量排除那些方案。而且动态规划最核心的是将大问题拆分成小问题，每个问题求最优解。