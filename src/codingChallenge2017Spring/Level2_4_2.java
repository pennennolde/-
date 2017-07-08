package codingChallenge2017Spring;

public class Level2_4_2 {

	public static void main(String[] args) {

		/*
		 *  Goodfind Engineer
		 *  Coding Challenge 2017 Spring
		 *
		 *  問題：Level 2
		 *  x ^ 2 = 1#2#3#4#5#6#7#8#9#0 のxの部分を求めるプログラムを作成せよ！
		 *  ※「#」は1桁の数字が何か入ることを意味します
		 */


		/*
		 *   x^2 はsqrt計算をするのにlong値からdouble値に変換される
		 *  sqrt計算で得られたdouble値をlong値にキャストするので、
		 *  残るのは整数部分の10桁のみ（最大最小でもxは10桁の数なので）
		 *  小数部分は切り捨てられる
		 *
		 *   今、x を整数と仮定すると、x^2 も整数
		 *   x^2 の次にsqrt計算結果が整数になるのは (x+1)^2
		 *   その差は、{(x+1)^2 - x^2} すなわち 2x+1
		 *   これは最小でも 2*1010101010+1 (キリよく2000000000とする)
		 *
		 *   よって、min+2000000000 = max とすれば、
		 *   min と max の間の範囲に x が整数になる x^2 が高々１つ存在する
		 *   得られたら、その数が条件を満たしているか詳しく見る
		 *
		 *   逆に言うと、x が整数の x^2 を見つけるには、上9桁までだけ考慮して計算すればよい
		 *   上9桁は条件に沿った指定をし、
		 *   下10桁は2000000000ずつ区切るので、条件は考慮しない
		 *
		 */


		/*
		 *  x^2 が上9桁までは条件に当てはまっている整数x を取り出し、
		 *  そのxを実際に2乗してみて条件に当てはまるか検証する
		 *
		 *
		 * min = 1020304050607080900L;    // x^2 の取り得る値の最小値
		 * max = 1929394959697989990L;    // x^2 の取り得る値の最大値
		 *
		 * √(min) = 1.0101010101010101E9  =(long)=> 1010101010
		 * √(max) = 1.3890266231062636E9  =(long)=> 1389026623
		 *
		 *
		 *     →      1020304050 000000000
		 *         ( < 1020304050 607080900      )     // x^2 の取り得る値の最小値
		 *                             ~
		 *          (    192939495 9697989990  < )    // x^2 の取り得る値の最大値
		 *                192939496 0000000000
		 *                                                                            の範囲で探す
		 *
		 *
		 * {(x+1)^2 - x^2} == 2x+1 ~ 2*1010101010 ~ 2000000000 単位でループをまわす
		 * x  と (x+1) とで2乗したときの差の最小約2000000000単位で探す
		 *   → 多くて1つ整数xが見つかる
		 *   → 見つからないループも極力少なくなってるはず
		 *
		 */


		double start = System.nanoTime();

		long answer = searchLoop();
		System.out.println("x= " + answer +",  x^2= " + answer*answer);
		System.out.println();
		System.out.println(System.nanoTime() - start);

	}



	static long searchLoop() {

		for(int a=0; a<10; a++) {
			for(int b=0; b<10; b++) {
				for(int c=0; c<10; c++) {
					for(int d=0; d<10; d++) {

						for(int e=0; e<9; e+=2) {

							long min_square = 1*(long)Math.pow(10, 18) + a*(long)Math.pow(10, 17) + 2*(long)Math.pow(10, 16) + b*(long)Math.pow(10, 15) + 3*(long)Math.pow(10, 14) + c*(long)Math.pow(10, 13) + 4*(long)Math.pow(10, 12) + d*(long)Math.pow(10, 11) + 5*(long)Math.pow(10, 10) + e*(long)Math.pow(10, 9) ;
							long max_square = min_square + 2000000000;

							long min = (long)Math.sqrt(min_square);
							long max = (long)Math.sqrt(max_square);

							if( max - min > 0 ) {
								if( max%10==0 ) {
									long answer = max;
									if( verify(answer)==true ) {
										return answer;
									}
								}
							}

						}

					}
				}
			}
		}
		return 0; //解となるxが見つからなかった場合0を返す

	}




	// x^2 の各位の数字を取り出して検証
	static boolean verify(long x) {
		long x_square = x*x;
		for(int i=0; i<19; i++) {
			if( i%2==0 ) {
				long position = x_square%10;
				if( ( i==0 && position!=0) || ( i!=0 && position!=10-(i/2) ) ) {
					return false;
				}
			}
			x_square = x_square/10;
		}
		return true;
	}

}

