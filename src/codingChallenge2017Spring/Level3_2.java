package codingChallenge2017Spring;

public class Level3_2 {

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



//		// (a + b√7)
//		long a = 3;
//		long b = 1;
//
//		// 初期設定  (x + y√7)
//		long x = a;
//		long y = b;
//		long next_x = x;
//		long next_y = y;
//
//
//		// n乗を計算
//		for(int n=2; n<100; n++) {
//			next_x = a*x + 7*b*y;
//			next_y = a*y + b*x;
//			System.out.println(n + ": " + next_x + " + " + next_y + "√7");
//
//			if( next_x>=10000000000L) {  // 11桁以上あるなら
//				long over = (long)next_x/10000000000L;  // 11桁以上だけ取り出す
//				next_x = next_x - over*10000000000L;
//			}
//			if( next_y>=10000000000L) {  // 11桁以上あるなら
//				long over = (long)next_y/10000000000L;
//				next_y = next_y - over*10000000000L;
//			}
//			System.out.println(n + ": " + next_x + " + " + next_y + "√7  ←10桁に直した");
//
//			x = next_x;
//			y = next_y;
//		}


		// (a + b√7)
				double a = 3;
				double b = 1;

				// 初期設定  (x + y√7)
				double x = a;
				double y[] = new double[20];
				y[0] = b;
				double next_x = x;
				double next_y[] = new double[20];
				for(int i=0; i<20; i++) {
					next_y[i] = y[i];
				}

				// n乗を計算  (a + b√7) * (x + y√7)
				for(int n=2; n<101; n++) {

					next_x = a*x + 7*b*y[0];       // + 7*b*y[1]・・・;
					next_y[0] = a*y[0] + b*x;
					for(int i=1; i<20; i++) {
						next_y[i] = a*y[i];
					}
					System.out.print(n + ": " + next_x + " + (");
					for(int i=19; i>=0; i--) {
						System.out.print(" + " + next_y[i]);
					}
					System.out.println(" )√7");

					if( next_x>=10000000000L) {  // 11桁以上あるなら
						long over = (long)next_x/10000000000L;  // 11桁以上だけ取り出す
						next_x = next_x - over*10000000000L;
					}
					for(int i=0; i<19; i++) {
						if( next_y[i]>=Math.pow(10000000000L, (i+1))) {  // 11桁以上あるなら
							long over = (long)(next_y[i]/Math.pow(10000000000L, (i+1)));
							next_y[i] -= over*Math.pow(10000000000L, (i+1));
							next_y[i+1] += over*Math.pow(10000000000L, (i+1));
						}
					}

					System.out.print(n + ": " + next_x + " + (");
					for(int i=19; i>=0; i--) {
						System.out.print(" + " + next_y[i]);
					}
					System.out.println(" )√7  ←10桁に直した");
					System.out.println();

					x = next_x;
					for(int i=0; i<20; i++) {
						y[i] = next_y[i];
					}

				}



				for(int i=0; i<20; i++) {
					y[i] *= Math.sqrt(7);
				}
				for(int i=0; i<20; i++) {
					if( next_y[i]>=Math.pow(10000000000L, (i+1))) {  // 11桁以上あるなら
						long over = (long)(next_y[i]/Math.pow(10000000000L, (i+1)));
						next_y[i] -= over*Math.pow(10000000000L, (i+1));
						next_y[i+1] += over*Math.pow(10000000000L, (i+1));
					}
				}
				System.out.println();
				System.out.println("Answer");
				System.out.println(x+y[0]+y[1]*Math.sqrt(7)+y[2]*Math.sqrt(7)+y[3]*Math.sqrt(7)+y[4]*Math.sqrt(7)+y[5]*Math.sqrt(7) );

				System.out.println(Math.sqrt(7));





	}

}
