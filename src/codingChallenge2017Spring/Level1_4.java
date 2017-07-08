package codingChallenge2017Spring;

public class Level1_4 {

	public static void main(String[] args) {

		/*
		 *  Goodfind Engineer
		 *  Coding Challenge 2017 Spring
		 *
		 *  問題：Level 1
		 *  3乗根の有効数字10桁の各位の数字が互いに重複しない最小の自然数を求めるプログラムを作成せよ！
		 */

		/*
		 * これが最終回答
		 */


		double start = System.nanoTime();


		int answer_num = 1;

		while( true ) {
			if( answer_num<next_num(answer_num) ) {
				answer_num = next_num(answer_num);
			} else {
				break;
			}
		}


		System.out.println(System.nanoTime() - start);

		System.out.println("求める自然数は:" + answer_num + ", その3乗根は:" + Math.pow(answer_num, 1.0/3.0));

	}



	static int next_num(int answer_num) {
		double cubic_mantissa = makeCubicMantissa(answer_num);
		int position_num[] = new int[10];
		for(int i=0; i<10; i++) {
			position_num[i] = (int)cubic_mantissa;  // 先頭の数字だけ取り出して格納
			if( repeated(position_num, i)==true ) {
				answer_num++;
				return answer_num;
			}
			cubic_mantissa -= position_num[i];
			cubic_mantissa *= 10;
		}
		return answer_num;
	}


	// ３乗根の指数表記の仮数を求めて返す
	static double makeCubicMantissa(double natural_num) {
		double cubic_root = Math.pow(natural_num, 1.0/3.0);
		int order = 0;
		while( cubic_root - Math.pow(10, order) >= 0 ) {
			order++;
		}
		return cubic_root/Math.pow(10, order-1);
	}


	static boolean repeated(int[] position_num, int i) {
		for(int j=0; j<i; j++) {
			if( position_num[j]==position_num[i] ) {  // 重複を検出
				return true;
			}
		}
		return false;
	}

}

