package codingChallenge2017Spring;

public class Level3_4 {

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
		 *     16√(7) → √(4*7)
		 *     √の中を大きくして、y を小さくする
		 */


		// (a + b√7)
		long a = 3;
		long b = 1;

		// 初期設定  (x[] + y[]√7)
		long x[] = new long[10000];
		long y[] = new long[10000];
		x[0] = a;
		y[0] = b;

		long x2[] = new long[10000];
		long y2[] = new long[10000];




		for(int n=0; n<17; n++) {

			x2 = exponent20x(x, y);
			y2 = exponent20y(x, y);

			for(int i=0; i<10000; i++) {
				x[i] = x2[i];
				y[i] = y2[i];
			}

		}




		// 出力
		for(int i=9999; i>=0; i--) {
			System.out.print(x[i] + ", ");
		}
		System.out.println();
		for(int i=9999; i>=0; i--) {
			System.out.print(y[i] + ", ");
		}
		System.out.println();

		System.out.println(Math.pow(1000,1000));

	}




















	static long[] exponent20x(long[] x, long y[]) {

		long x1[] = new long[10000];
		long y1[] = new long[10000];
		for(int i=0; i<10000; i++) {
			x1[i] = x[i];
			y1[i] = y[i];
		}

		long next_x[] = new long[10000];
		long next_y[] = new long[10000];
		long x4[] = new long[10000];
		long y4[] = new long[10000];

		// (x[]+y[]√7)^16 を計算
		for(int n=0; n<4; n++) {

			// (x[] + y[]√7)^2 = (x^2 + 7*y^2) + (2*x*y) * √7  を計算
			for(int i=0; i<5000; i++) {
				//if( x1[i]!=0 ) {
					for(int j=0; j<5000; j++) {
						//if( x1[j]!=0 ) {
							next_x[i+j] += x1[i] * x1[j];
							next_x[i+j] += 7 * y1[i] * y1[j];
							next_y[i+j] += 2 * x1[i] * y1[j];
						//}
					}
				//}
			}

			// ならす
			next_x = narasu(next_x);
			next_y = narasu(next_y);

			// 次のループ準備
			for(int i=0; i<10000; i++) {
				x1[i] = next_x[i];
				y1[i] = next_y[i];
				next_x[i] = 0;
				next_y[i] = 0;
			}

			// 4乗の結果を保存
			if( n==1 ) {
				for(int i=0; i<10000; i++) {
					x4[i] = x1[i];
					y4[i] = y1[i];
				}
			}

		}

		// {(x[]+y[]√7)^16}*{(x[]+y[]√7)^4}  を計算
		for(int i=0; i<5000; i++) {
			//if( x1[i]!=0 ) {
				for(int j=0; j<5000; j++) {
					//if( x4[j]!=0 ) {
						next_x[i+j] += x1[i] * x4[j];
						next_x[i+j] += 7 * y1[i] * y4[j];
						next_y[i+j] += x1[i] * y4[j];
						next_y[i+j] += x4[i] * y1[j];
					//}
				}
			//}
		}
		// ならす
		next_x = narasu(next_x);
		next_y = narasu(next_y);

		// 次のループ準備
		for(int i=0; i<10000; i++) {
			x1[i] = next_x[i];
			y1[i] = next_y[i];
			next_x[i] = 0;
			next_y[i] = 0;
		}

		return x1;
	}





	static long[] exponent20y(long[] x, long y[]) {

		long x1[] = new long[10000];
		long y1[] = new long[10000];
		for(int i=0; i<10000; i++) {
			x1[i] = x[i];
			y1[i] = y[i];
		}

		long next_x[] = new long[10000];
		long next_y[] = new long[10000];
		long x4[] = new long[10000];
		long y4[] = new long[10000];

		// (x[]+y[]√7)^16 を計算
		for(int n=0; n<4; n++) {

			// (x[] + y[]√7)^2 = (x^2 + 7*y^2) + (2*x*y) * √7  を計算
			for(int i=0; i<5000; i++) {
				//if( x1[i]!=0 ) {
					for(int j=0; j<5000; j++) {
						//if( x1[j]!=0 ) {
							next_x[i+j] += x1[i] * x1[j];
							next_x[i+j] += 7 * y1[i] * y1[j];
							next_y[i+j] += 2 * x1[i] * y1[j];
						//}
					}
				//}
			}

			// ならす
			next_x = narasu(next_x);
			next_y = narasu(next_y);

			// 次のループ準備
			for(int i=0; i<10000; i++) {
				x1[i] = next_x[i];
				y1[i] = next_y[i];
				next_x[i] = 0;
				next_y[i] = 0;
			}

			// 4乗の結果を保存
			if( n==1 ) {
				for(int i=0; i<10000; i++) {
					x4[i] = x1[i];
					y4[i] = y1[i];
				}
			}

		}

		// {(x[]+y[]√7)^16}*{(x[]+y[]√7)^4}  を計算
		for(int i=0; i<5000; i++) {
			//if( x1[i]!=0 ) {
				for(int j=0; j<5000; j++) {
					//if( x4[j]!=0 ) {
						next_x[i+j] += x1[i] * x4[j];
						next_x[i+j] += 7 * y1[i] * y4[j];
						next_y[i+j] += x1[i] * y4[j];
						next_y[i+j] += x4[i] * y1[j];
					//}
				}
			//}
		}
		// ならす
		next_x = narasu(next_x);
		next_y = narasu(next_y);

		// 次のループ準備
		for(int i=0; i<10000; i++) {
			x1[i] = next_x[i];
			y1[i] = next_y[i];
			next_x[i] = 0;
			next_y[i] = 0;
		}

		return y1;
	}






	// ならす
	static long[] narasu(long[] x) {
		for(int i=0; i<9999; i++) {
			if( x[i]>=10000) {
				long over = (long)(x[i]/10000);
				x[i] -= over*10000;
				x[i+1] += over;
			}
		}
		return x;
	}



}
