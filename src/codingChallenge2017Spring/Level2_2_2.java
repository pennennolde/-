package codingChallenge2017Spring;

public class Level2_2_2 {
	public static void main(String[] args) {

		/*
		 *  Goodfind Engineer
		 *  Coding Challenge 2017 Spring
		 *
		 *  問題：Level 2
		 *  x ^ 2 = 1#2#3#4#5#6#7#8#9#0 のxの部分を求めるプログラムを作成せよ！
		 *  ※「#」は1桁の数字が何か入ることを意味します
		 */



		double start =System.nanoTime();


		// 10桁の数 1の位->10の位の順で格納
		int answer[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
		// 初期値 1000000000 からスタート


		int square[] = new int[19];

		loop:
		while( true ) {
			System.out.println();
			System.out.print("answer= ");
			print(answer);

			// square を初期化
			for(int n=0; n<square.length; n++) {
				square[n] = 0;
			}
			System.out.print("square= ");
			print(square);

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

			if( (square[0]!=0) || (square[2]!=9) || (square[4]!=8) || (square[6]!=7) || (square[8]!=6) || (square[10]!=5) || (square[12]!=4) || (square[14]!=3) || (square[16]!=2) || (square[18]!=1) ) {
				System.out.println("判断");
				answer = answerPlus(answer);
				continue loop;
			}

			break;
		}


		System.out.println();
		for(int i=answer.length-1; i>=0; i--) {
			System.out.print(answer[i]);
		}
		System.out.print("^2 = ");
		for(int i=square.length-1; i>=0; i--) {
			System.out.print(square[i]);
		}



		System.out.println();
		System.out.println(System.nanoTime() - start);

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
