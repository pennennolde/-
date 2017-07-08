package codingChallenge2017Spring;

public class Level2_Answer {

	//public static void main(String[] args) {


	//}

//}



/**
 * Coding Challenge 2
 * x ^ 2 = 1#2#3#4#5#6#7#8#9#0 となる整数xを当てる（「#」は1桁の整数）
 */
//public class CodingChallenge2 {

	/*
	 * 模範解答（自分のやつのほうが速い！？）
	 */

    /**
     * main method.
     */
    public static void main(String[] args) {

    	double start = System.nanoTime();

	// 上3桁が「1#2」であることから、nの範囲はある程度まで絞れる。
	// また、下1桁は確実に「0」なので、10ずつインクリメントすれば良い。
	for (long n = 1000000000L; n <= 1400000000L; n += 10) {
	    long sq = n * n;
	    if (isValid(sq)) {
		System.out.println(n);
	    }
	}

	System.out.println(System.nanoTime() - start);

    }

    /**
     * 判定ロジック
     *
     * @param n 整数
     * @return 条件に合致していればtrue, 合致しなければfalse
     */
    private static boolean isValid(long n) {
	String ns = Long.toString(n);
	for (int i = 0; i < 10; i++) {
	    // 明かされている数字が一致しているかをチェックし、不一致ならfalseを返す
	    if (ns.length() < 2*i
		    || Character.getNumericValue(ns.charAt(2*i)) != (i + 1) % 10) {
		return false;
	    }
	}
	return true;
    }
}