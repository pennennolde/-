package codingChallenge2017Spring;

public class Level3_3 {


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
		 *     (3+√7)*(3+√7)
		 *     =   9 + 6√7 + 7
		 *     = 16 + 6√7                 を利用
		 *
		 */


		// (a + b√7)
		double a = 3.0;
		double b = 1.0;

		// 初期設定  (x + y√7)
		double x[] = new double[20];
		x[0] = a;
		double y[] = new double[20];
		y[0] = b;
		double next_x[] = new double[20];
		double next_y[] = new double[20];


		// n乗を計算  (a + b√7) * (x + y√7)
		for(int n=2; n<101; n++) {

			for(int i=0; i<20; i++) {
				next_x[i] = a*x[i] + 7*b*y[i];
				next_y[i] = a*y[i] + b*x[i];
			}

			// 出力
			System.out.print(n + ": ");
			for(int i=19; i>=0; i--) {
				System.out.print(" + " + next_x[i]);
			}
			System.out.print(" + ( ");
			for(int i=19; i>=0; i--) {
				System.out.print(" + " + next_y[i]);
			}
			System.out.println(" )√7");

			// 桁訂正
			for(int i=0; i<19; i++) {
				if( next_x[i]>=Math.pow(10000000000L, (i+1))) {  // 11桁以上あるなら
					long over = (long)(next_x[i]/Math.pow(10000000000L, (i+1)));
					next_x[i] -= over*Math.pow(10000000000L, (i+1));
					next_x[i+1] += over*Math.pow(10000000000L, (i+1));
				}
			}
			for(int i=0; i<19; i++) {
				if( next_y[i]>=Math.pow(10000000000L, (i+1))) {  // 11桁以上あるなら
					long over = (long)(next_y[i]/Math.pow(10000000000L, (i+1)));
					next_y[i] -= over*Math.pow(10000000000L, (i+1));
					next_y[i+1] += over*Math.pow(10000000000L, (i+1));
				}
			}

			// 出力
			System.out.print(n + ": ");
			for(int i=19; i>=0; i--) {
				System.out.print(" + " + next_x[i]);
			}
			System.out.print(" + ( ");
			for(int i=19; i>=0; i--) {
				System.out.print(" + " + next_y[i]);
			}
			System.out.println(" )√7  ←10桁に直した");
			System.out.println();


			for(int i=0; i<20; i++) {
				x[i] = next_x[i];
				y[i] = next_y[i];
			}

		}



		System.out.println("Answer");
		System.out.println(x[0] + "+");

		for(int i=0; i<20; i++) {
			y[i] *= Math.sqrt(7.0);
		}
		for(int i=0; i<19; i++) {
			if( y[i]>=Math.pow(10000000000L, (i+1))) {  // 11桁以上あるなら
				long over = (long)(y[i]/Math.pow(10000000000L, (i+1)));
				y[i] -= over*Math.pow(10000000000L, (i+1));
				y[i+1] += over*Math.pow(10000000000L, (i+1));
			}
		}
		for(int i=0; i<20; i++) {
			if( y[i]>=10000000000L) {
				long over = (long)(y[i]/10000000000L);
				y[i] -= over*10000000000L;
			}
		}
		System.out.println(y[0]);
		System.out.println(y[1]);
		System.out.println(y[2]);

		System.out.println();
		System.out.println(Math.sqrt(7));
		System.out.println(Math.sqrt(7)*10000000000L);





	}

}
