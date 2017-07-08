package magicSquare;

public class MagicSquare2 {

	public static void main(String[] args) {

		/*
		 *  操作出力型
		 */

		/*
		 *   このプログラムが最新の大元
		 *   全体図
		 */


		double start = System.nanoTime();


		/* 魔法陣の定義 */

		// 9×9の魔法陣の場合
		int n = 9;
		// 魔法陣定義
		int MagicSquare[][][] = new int[n][n][n+1];

		// ここに入力
		int Input[][] = {{2,0,0,0,0,0,0,0,6},
				{0,9,6,3,0,8,7,5,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,6,0,4,0,0,0},
				{0,0,0,0,8,0,0,0,0},
				{0,3,0,1,0,5,0,8,0},
				{0,2,4,7,0,1,8,9,0},
				{0,5,0,8,9,3,0,1,0},
				{0,0,0,5,0,2,0,0,0}};

		// 初期設定
		MagicSquare = Process2.firstSetting(Input);
		System.out.println("MagicSquareの入力を確認しました。");
		System.out.println();
		System.out.println("before MagicSquare=");
		PrintOut.printMagicSquare(MagicSquare);
		System.out.println();
		//PrintOut.printConsidered(MagicSquare);

		System.out.println("start_sum= " + Process2.sum(MagicSquare));



		/* 魔法陣を解く */

		System.out.println();
		System.out.println();
		System.out.println("MagicSquareの解答を開始します。");

		System.out.println();
		System.out.println("FirstLoopを開始します。");
		MagicSquare = Process2.firstLoop(MagicSquare);
		System.out.println();
		PrintOut.printMagicSquare(MagicSquare);


		// 仮定実験
		MagicSquare = Process2.virtualLoop(MagicSquare);

		if( Process2.sum(MagicSquare)==405 ) {
			System.out.println();
			System.out.println("MagicSquareが完成しました。");
		}else{
			System.out.println();
			System.out.println("MagicSquareの解答に失敗しました。");
		}

		System.out.println();
		System.out.println("after MagicSquare=");
		PrintOut.printMagicSquare(MagicSquare);
		//System.out.println();
		//PrintOut.printConsidered(MagicSquare);


		System.out.println(System.nanoTime() - start);


	}
}
