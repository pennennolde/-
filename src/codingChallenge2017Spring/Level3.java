package codingChallenge2017Spring;

public class Level3 {

	public static void main(String[] args) {

		/*
		 *  Goodfind Engineer
		 *  Coding Challenge 2017 Spring
		 *
		 *  問題：Level3
		 *  (3+√7)^(20^17) の整数部分の下10桁を求めるプログラムを作成せよ！
		 *
		 */

		/*
		 *   x.y * 5.645...  ← yは1桁だけで十分(くり上がりによる変化は起きない)
		 *   next_x.y = (x*5) + (x*0.645...) + (0.y*5) + (0.y*0.645...)
		 *   最後の小数部分の同士の足し算でくり上がるかも!?
		 *
		 *     a. (x*5) の下10桁を取り出す
		 *     b. (x*0,645...) の整数部分下10桁を取り出す
		 *     c. (0.y*5) の整数部分(1桁)を取り出す ← yは1桁だけで十分(くり上がりによる変化は起きない)
		 *     ＊ (0.y*0.645...) の整数部分は 0 なので無視
		 *
		 *
		 */



		double α = 3.0 + Math.sqrt(7.0);

		double a = 5;
		double b = α - a;

		double x = a;
		double y = b;
		double next_x = a;
		double next_y = b;


		// a. (x*5) の下10桁を取り出す
		next_x = under10(x*a);

		// b. (x*0,645...) の整数部分下10桁を取り出す
		next_x += under10(x*b);


	}



	// 整数部分の下10桁を取り出す
	static double under10(double n) {
		double under10 = 0.0;
		double over10 = 0;
		if( n>9999999999L ) {
			over10 = n/10000000000L;
			under10 = n - (over10*10000000000L);
			return under10;
		}
		return n;
	}

	// 小数部分の下1桁を取り出す
	static double decimal1(double x) {
		double y = (int)(10*x);
		return y/10;
	}


}
