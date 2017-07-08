package magicSquare;

public class Process3 {

	public static void main(String[] args) {

		/*
		 *  Hunt Me Tryout 発表より、改訂版
		 */

		/*
		 * 候補が２つだけのマスで過程ループをまわしても、解答までたどり着かないことがある
		 * →その途中で止まったところから、さらに過程ループをまわせるようにするとよい！？
		 *
		 * →仮定ループをさらにメソッド化
		 *
		 * →仮定が間違っていてFirstLoopが最後までいかなかったのか、
		 * 	仮定はあっているけどFirstLoopが最後までいかなかったのか、
		 * 	見分けがつかない！！
		 */

	}


	// 仮定ループ
	public static int[][][] virtualLoop(int MagicSquare[][][]) {
		int n = MagicSquare.length;
		int sum = Process2.sum(MagicSquare);
		if( sum<405 ) {
			System.out.println();
			System.out.println();
			System.out.println("VirtualLoopに入ります。");
			System.out.println("sum= " + sum);

			// 残りの候補選び
			for(int possibility=2; possibility<10; possibility++) {
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						int count = 0;
						for(int k=1; k<n+1; k++) {
							if( MagicSquare[i][j][k]!=0 ) {
								count++;
							}
						}
						System.out.println("i: " + i + ", j: " + j +", count= " + count);
						if(count==possibility) {

							for(int k=1; k<n+1; k++) {
								if( MagicSquare[i][j][k]!=0 ) {

									int ifMagicSquare[][][] = new int[n][n][n+1];
									ifMagicSquare = virtualLoopCore(MagicSquare, n, i, j, k);

									// 成功し解が出たら取り出す
									sum = Process2.sum(ifMagicSquare);

									if( sum==405 ) {
										System.out.println();
										System.out.println("実験に成功しました。VirtualLoopをbreakします。");
										for(int i3=0; i3<n; i3++) {
											for(int j3=0; j3<n; j3++) {
												for(int k3=0; k3<n+1; k3++) {
													MagicSquare[i3][j3][k3] = ifMagicSquare[i3][j3][k3];
												}
											}
										}
									}
									if( sum<405 ) {
										System.out.println();
										System.out.println("解答に辿り着きませんでした。仮定を変更します。");

									}



								} // if 決定しているかいないか
								if( sum==405 ) {
									break;
								}
							} // k
						}
						if( sum==405 ) {
							break;
						}
					} // j
					if( sum==405 ) {
						break;
					}
				} // i
				if( sum==405 ) {
					break;
				}
			} // possibility
		} // if
		return MagicSquare;
	}



	static int[][][] virtualLoopCore(int MagicSquare[][][], int n, int i, int j, int k) {
		int VirtualMagicSquare[][][] = new int[n][n][n+1];
		// 候補を見つけたら仮定魔法陣を作成
		for(int i2=0; i2<n; i2++) {
			for(int j2=0; j2<n; j2++) {
				for(int k2=0; k2<n+1; k2++) {
					VirtualMagicSquare[i2][j2][k2] = MagicSquare[i2][j2][k2];
				}
			}
		}
		System.out.println();
		System.out.println("MagicSquare[" + (i+1) + "][" + (j+1) + "]でConsidered[" + k + "]を仮定しループを開始します。");
		VirtualMagicSquare[i][j][0] = VirtualMagicSquare[i][j][k];
		// 仮定に対しループ実行
		VirtualMagicSquare = Process2.firstLoop(VirtualMagicSquare);
		return VirtualMagicSquare;
	}



}
