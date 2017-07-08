package codingChallenge2017Spring;

//public class Level1_Answer {

	//public static void main(String[] args) {


	//}

//}

/*
 *
 */


import java.util.HashSet;
import java.util.Set;

/**
 * Coding Challenge 1
 * 3乗根の上10桁の数字が重複していない(0〜9が1つずつ出現する)
 *
 * 有効数字10桁（11桁目を四捨五入して計算）と、上10桁（11桁目を切り捨てて計算）の
 * どちらで処理した場合でも正解としています。
 * （下記は、11桁目を切り捨てた場合の例）
 */

/*
 * 模範解答（自分でつくったやつのほうが速い！？）
 */

	// public class CodingChallenge1 {
	public class Level1_Answer {

    /**
     * main method.
     */
    public static void main(String[] args) {

    	double start = System.nanoTime();

	for (int i = 1; ; i++) {
	    if (is_komachi(i)) {
		System.out.println(i);
		break;
	    }
	}

	System.out.println(System.nanoTime() - start);

    }

    /**
     * nの3乗根を計算し、上10桁の重複の有無をチェック
     *
     * @param n 整数
     * @return 上10桁の数字が重複すればfalse, 重複しなければtrue
     */
    private static boolean is_komachi(int n) {
	double cr = Math.cbrt(n);
	while (cr >= 10) {
	    cr /= 10;
	}
	Set<Integer> s = new HashSet<Integer>();
	for (int i = 0; i < 10; i++) {
	    int j = (int)cr;
	    if (s.contains(j)) {
		return false;
	    }
	    s.add(j);
	    cr = (cr - j) * 10;
	}
	return true;
    }
}
