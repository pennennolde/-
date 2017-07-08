package codingChallenge2017Spring;

public class Level1_3 {

	public static void main(String[] args) {

		/*
		 *  Goodfind Engineer
		 *  Coding Challenge 2017 Spring
		 *
		 *  問題：Level 1
		 *  3乗根の有効数字10桁の各位の数字が互いに重複しない最小の自然数を求めるプログラムを作成せよ！
		 */


		int answer_num = 1;

		while( true ) {
			if( answer_num!=repeatedOrNot(answer_num) ) {
				answer_num = repeatedOrNot(answer_num);
			} else {
				break;
			}
		}
		System.out.println("求める自然数は:" + answer_num + ", その3乗根は:" + Math.pow(answer_num, 1.0/3.0));
	}




	static int repeatedOrNot(int answer_num) {
		double cubic_mantissa = makeCubicMantissa(answer_num);  // ３乗根の指数表記の仮数mantissaを求める
		int position_num[] = new int[10];
		// 1桁ずつ取り出して、重複がないか調べる
		for(int i=0; i<10; i++) {
			position_num[i] = (int)cubic_mantissa;
			for(int j=0; j<i; j++) {
				if( position_num[j]==position_num[i] ) {  // 重複を検出、次の数へ
					answer_num++;
					return answer_num;
				}
			}
			cubic_mantissa -= position_num[i];
			cubic_mantissa *= 10;
		}
		return answer_num;
	}




	static double makeCubicMantissa(double natural_num) {
		double cubic_root = Math.pow(natural_num, 1.0/3.0);
		int order = 0;
		while( cubic_root - Math.pow(10, order) >= 0 ) {
			order++;
		}
		return cubic_root/Math.pow(10, order-1);
	}

}

