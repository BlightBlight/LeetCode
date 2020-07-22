/*
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:
输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

/*
 * G(n): 长度为n的序列的不同二叉搜索树个数。
 * F(i, n):以i为根的不同二叉搜索树个数(1 ≤ i ≤ n)。
 		i=1
 G(n)= 	∑ 	F(i,n)        (1)
 		n
 * 特别的，对于边界情况，当序列长度为1(只有根)或为0(空树)时，只有一种情况。亦即：
 * G(0)=1, G(1)=1
 * F(3,7)，以3为根的不同二叉搜索树个数
 * 为了以3为根从序列[1, 2, 3, 4, 5, 6, 7]构建二叉搜索树
 * 我们需要从左子序列[1, 2]构建左子树
 * 从右子序列[4, 5, 6, 7]构建右子树，然后将它们组合(即笛卡尔积)
 * 巧妙之处在于，我们可以将[1,2]构建不同左子树的数量表示为G(2)
 * 从[4, 5, 6, 7]构建不同右子树的数量表示为G(4)
 * 这是由于G(n)和序列的内容无关，只和序列的长度有关
 * 于是，F(3,7) = G(2) * G(4)
 * 概括而言，我们可以得到以下公式
 * F(i,n) = G(i−1) * G(n−i)    (2)
 * 将公式(1) ，(2) 结合，可以得到G(n)的递归表达公式
		i=1
 G(n)=	∑    G(i−1) * G(n−i)
		n
 */
public class Number96 {
	public int numTrees(int n) {
		int[] G = new int[n + 1];
		G[0] = 1;
		G[1] = 1;

		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j <= i; ++j) {
				G[i] += G[j - 1] * G[i - j];
			}
		}
		return G[n];
	}
    
	public static void main(String[] args) {
		int n1 = 3;
		Number96 n = new Number96();
		System.out.println(n.numTrees(n1));
	}
}