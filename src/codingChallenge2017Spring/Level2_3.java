package codingChallenge2017Spring;

public class Level2_3 {

	public static void main(String[] args) {


		//int[] answer = new int[10];
		int[] square = new int[19];

		//									     a       b       c        d       e           f           g           h           i
		//int[] square_min = {1, 0, 2, 0, 3, 0, 4, 0, 5,  0,  6,   0,   7,   0,   8,   0,   9,  0,  0};
		//int[] square_max = {1, 9, 2, 9, 3, 9, 4, 9, 5,  9,  6,   9,   7,   9,   8,   9,   9,  9,  0};
		//									 1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19

		double min = 1.0;
		double max = 1.0;

		loop1:
		for(int a=0; a<10; a++) {
			for(int b=0; b<10; b++) {
				for(int c=0; c<10; c++) {
					for(int d=0; d<10; d++) {
						for(int e=0; e<10; e++) {
							for(int f=0; f<10; f++) {
								for(int g=0; g<10; g++) {


									min = 1 + a*Math.pow(10, -1) + 2*Math.pow(10, -2) + b*Math.pow(10, -3) + 3*Math.pow(10, -4) + c*Math.pow(10, -5) + 4*Math.pow(10, -6) + d*Math.pow(10, -7) + 5*Math.pow(10, -8) + e*Math.pow(10, -9) + 6*Math.pow(10, -10) + f*Math.pow(10, -11) + 7*Math.pow(10, -12) + g*Math.pow(10, -13) + 8*Math.pow(10, -14);
									min = Math.pow(min, 1.0/2.0);

									max = 1 + a*Math.pow(10, -1) + 2*Math.pow(10, -2) + b*Math.pow(10, -3) + 3*Math.pow(10, -4) + c*Math.pow(10, -5) + 4*Math.pow(10, -6) + d*Math.pow(10, -7) + 5*Math.pow(10, -8) + e*Math.pow(10, -9) + 6*Math.pow(10, -10) + f*Math.pow(10, -11) + 7*Math.pow(10, -12) + g*Math.pow(10, -13) + 8*Math.pow(10, -14) + 9*Math.pow(10, -15) + 9*Math.pow(10,  -16);
									//max = Math.pow(max, 1.0/2.0);

									// 初期値に min を設定
									int[] answer = new int[10];
									answer[0] = 0;
									for(int i=answer.length-1; i>0; i--) {
										answer[i] = (int)min;  // 先頭の数字だけ取り出して格納
										min -= answer[i];
										min *= 10;
									}



									loop:
										while( true ) {
											System.out.println();
											System.out.print("answer= ");
											print(answer);

											// square を初期化
											for(int n=0; n<square.length; n++) {
												square[n] = 0;
											}


											for(int i=0; i<answer.length; i++) {
												for(int j=0; j<answer.length; j++) {
													square[i+j] += answer[i]*answer[j];
												}
											}

											square = definition(square);

											// 出力
											System.out.print("square= ");
											print(square);

											if( square[18]>1) {
												System.out.println( square[18] );
												System.out.println("見つかりませんでした。");
												break;
											}


											int Max[] = new int[10];
											for(int i=0; i<10; i++) {
												Max[i] = (int)max;  // 先頭の数字だけ取り出して格納
												max -= Max[i];
												max *= 10;
											}

											double comp = square[18] + square[17]*Math.pow(10, -1) + square[16]*Math.pow(10, -2) + square[15]*Math.pow(10, -3) + square[14]*Math.pow(10, -4) + square[13]*Math.pow(10, -5) + square[12]*Math.pow(10, -6) + square[11]*Math.pow(10, -7) + square[10]*Math.pow(10, -8) + square[9]*Math.pow(10, -9) + square[8]*Math.pow(10, -10) +square[7]*Math.pow(10, -11) + square[6]*Math.pow(10, -12) + square[5]*Math.pow(10, -13) + square[4]*Math.pow(10, -14) + square[3]*Math.pow(10, -15) + square[2]*Math.pow(10,  -16);
											if( max<=comp) {
												System.out.println("次のターゲット枠に入ります。");
												break;
											}



											if( (square[0]!=0) || (square[2]!=9) || (square[4]!=8) || (square[6]!=7) || (square[8]!=6) || (square[10]!=5) || (square[12]!=4) || (square[14]!=3) || (square[16]!=2) || (square[18]!=1) ) {
												System.out.println("解ではありません。");
												answer = answerPlus(answer);
												continue loop;
											}

											System.out.println("成功です。");
											System.out.print("Answer= ");
											print(answer);
											break loop1;
										}






								}
							}
						}
					}
				}
			}
		}

		//System.out.println(Math.pow(2,1.0/2.0));




	}



	// answer に +10 して返す
	static int[] answerPlus(int[] answer) {
		answer[1]++;
		return definition(answer);
	}



	// 配列の中身を一桁の数にならして返す
	static int[] definition(int[] numbox) {
		for(int i=0; i<numbox.length-1; i++) {
			while( numbox[i]>9 ) {
				numbox[i] -= 10;
				numbox[i+1]++;
			}
		}
		return numbox;
	}



	// 配列を数字として出力
	static void print(int[] num) {
		for(int k=num.length-1; k>=0; k--) {
			System.out.print(num[k] + " ");
		}
		System.out.println();
	}

}
