package magicSquare;

public class MagicSquare1 {

	public static void main(String[] args) {

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
		MagicSquare = Process1.firstSetting(Input);

		System.out.println("before MagicSquare=");
		PrintOut.printMagicSquare(MagicSquare);
		System.out.println();
		//PrintOut.printConsidered(MagicSquare);



		/* 魔法陣を解く */

		MagicSquare = Process1.firstLoop(MagicSquare);

		// 仮定実験
		MagicSquare = Process1.virtualLoop(MagicSquare);


		System.out.println("after MagicSquare=");
		PrintOut.printMagicSquare(MagicSquare);
		//System.out.println();
		//PrintOut.printConsidered(MagicSquare);


	}
}
