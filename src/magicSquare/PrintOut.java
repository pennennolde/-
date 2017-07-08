package magicSquare;

public class PrintOut {

	/*
	 *  いろいろと出力する
	 */

	// 魔法陣の出力
	public static void printMagicSquare(int x[][][]) {
		int n = x.length;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if( x[i][j][0]==0 ) {
					System.out.print("  ");
				} else {
					System.out.printf("%2d", x[i][j][0]);
				}
				if( j==n-1 ) {
					break;
				}
				if( j%3==2 ) {
					System.out.print(" |");
				}
			}
			System.out.println();
			if( i==n-1 ) {
				break;
			}
			if( i%3==2 ) {
				System.out.println("-------+-------+------");
			}
		}
	}


	// 各マスの候補の出力
	public static void printConsidered(int x[][][]) {
		int n = x.length;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print("MagicSquare["+(i+1)+"]["+(j+1)+"]= ");
				System.out.print(x[i][j][0] + " ");
				for(int k=1; k<n+1; k++) {
					System.out.print(" "+x[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}


}
