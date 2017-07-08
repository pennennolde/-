package codingChallenge2017Spring;

public class Level2_4 {

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
		 *  有効桁数を超える数字は”切り捨て”（あるいは丸められる）
		 *  sqrt, powなどのライブラリの返り値はdouble → 丸められて返ってくる
		 *  ルートを計算 → 小さい方の位が丸められて、正しい答えかどうかわからない
		 *                           → 小数か整数か判断できない
		 *          → 2乗を計算するアルゴリズムを使う
		 *
		 * double → 15桁までなら有効っぽい
		 * 15桁までなら Math.sqrt を使ったり、結果を信用していい
		 *    → 15桁以降の正確さは、実際に2乗してみて確かめる
		 *
		 *  double から int に変換のとき、小数点以下は切り捨て
		 *
		 */


		/*
		 *  long min1 = 1020304050607080900L;
		 *  long max1 = 1929394959697989990L;
		 *
		 *  System.out.println(Math.sqrt(min1));
		 *      →  1.0101010101010101E9
		 *  System.out.println(Math.sqrt(max1));
		 *      →  1.3890266231062636E9
		 *
		 *  System.out.println((long)Math.sqrt(min1));
		 *      →  1010101010
		 *  System.out.println((long)Math.sqrt(max1));
		 *      →  1389026623
		 *
		 *  →
		 *  引数はdoubleに変換されて計算される
		 *  sqrtの結果のdouble値は15桁まで有効と考え
		 *  答えとなりうるのは10桁の数
		 *
		 *  答えは1の位が0の数なんだから、もう少しうまくやれる？
		 *
		 */

		/*
		 *  x^2 の範囲から解xの存在範囲を絞る
		 *  sqrt計算のときx^2はdouble値に変換される→ 17桁は正確っぽい
		 *  （double: 正の値は 4.94065645841246544E-324 ～ 1.79769313486231570E+308）
		 *  sqrt計算の結果のdouble値は15桁までなら信じてもいいらしい
		 *  答えとなるxは10桁の数でしかも1の位は0
		 *
		 *  long min1 = 1020304050607080900L;
		 *  long max1 = 1929394959697989990L;
		 *                                                                        ↑ ↑ ↑
		 *                                                            ここはdoubleでは正確でない
		 */

		long min1 = 1020304050607080900L;
		long max1 = 1929394959697989990L;
		System.out.println((double)min1);
		System.out.println((double)max1);
		System.out.println();

		long min2 = 1020304050607080000L;
		long max2 = 1929394959697989000L;
		System.out.println((double)min2);
		System.out.println((double)max2);
		System.out.println();

		System.out.println(1010101010L * 1010101010L);
		System.out.println(1010101011L * 1010101011L);
		System.out.println(1389026623L * 1389026623L);




		double start = System.nanoTime();

		long answer = searchLoop();

		System.out.println("x= " + answer +",  x^2= " + answer*answer);
		System.out.println();
		System.out.println(System.nanoTime() - start);

	}



	static long searchLoop() {

		// doubleにしても正確さが保たれる範囲で変数を動かす、それ以上の範囲は0か9
		for(int a=0; a<10; a++) {
			for(int b=0; b<10; b++) {
				for(int c=0; c<10; c++) {
					for(int d=0; d<10; d++) {
						for(int e=0; e<10; e++) {
							for(int f=0; f<10; f++) {
								for(int g=0; g<10; g++) {

									// double変換して正確さが保たれる16桁まで指定、あとは最小最大値
									// root計算が正確に求まる有効桁のうちでのminとmaxの数
									// rootした結果、少なくとも1の位までは正しい数がかえってくるはず                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ここまでdoubleに反映される
									long min_square = 1*(long)Math.pow(10, 18) + a*(long)Math.pow(10, 17) + 2*(long)Math.pow(10, 16) + b*(long)Math.pow(10, 15) + 3*(long)Math.pow(10, 14) + c*(long)Math.pow(10, 13) + 4*(long)Math.pow(10, 12) + d*(long)Math.pow(10, 11) + 5*(long)Math.pow(10, 10) + e*(long)Math.pow(10, 9) + 6*(long)Math.pow(10, 8) + f*(long)Math.pow(10, 7) + 7*(long)Math.pow(10, 6) + g*(long)Math.pow(10, 5) + 8*(long)Math.pow(10, 4) + 0*(long)Math.pow(10, 3) + 9*(long)Math.pow(10, 2) + 0*(long)Math.pow(10, 1) + 0;
									long max_square = 1*(long)Math.pow(10, 18) + a*(long)Math.pow(10, 17) + 2*(long)Math.pow(10, 16) + b*(long)Math.pow(10, 15) + 3*(long)Math.pow(10, 14) + c*(long)Math.pow(10, 13) + 4*(long)Math.pow(10, 12) + d*(long)Math.pow(10, 11) + 5*(long)Math.pow(10, 10) + e*(long)Math.pow(10, 9) + 6*(long)Math.pow(10, 8) + f*(long)Math.pow(10, 7) + 7*(long)Math.pow(10, 6) + g*(long)Math.pow(10, 5) + 8*(long)Math.pow(10, 4) + 9*(long)Math.pow(10, 3) + 9*(long)Math.pow(10, 2) + 9*(long)Math.pow(10, 1) + 0;

									// 少なくとも1の位までは正確なはず、整数部分だけ取り出す
									long min = (long)Math.pow(min_square, 1.0/2.0);
									long max = (long)Math.pow(max_square, 1.0/2.0) + 1;  //情報落ちなどを考慮して+1
									//System.out.println(min);
									//System.out.println(max);
									//System.out.println();

									if( max - min > 0 ) {  // この範囲に整数の平方根があるかも
										while( min<=max ) {
											long answer = min;
											if( answer%10==0 ) {
												if( verify(answer)==true ) {
													System.out.println("検証");
													return answer;
												}
											}
											min++;
										}
									}

								}
							}
						}
					}
				}
			}
		}
		return 0;

	}




	static boolean verify(long num) {
		long num_sq = num*num;
		// 各位の数字を取り出して検証
		for(int i=0; i<19; i++) {
			long position_num = (num_sq)%10;
			if( i%2==0 ) {
				if( ( i==0 && position_num!=0) || (position_num!=10-(i/2) ) ) {
					return false;
				}
			}
			num_sq = num_sq/10;
		}
		return true;
	}

}

