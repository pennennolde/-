package magicSquare;

public class Process1 {

	/*
	 *  操作のメソッド
	 */


	// 魔法陣&候補の初期設定
	public static int[][][] firstSetting(int Input[][]) {
		int MagicSquare[][][] = new int[Input.length][Input.length][Input.length+1];
		for(int i=0; i<Input.length; i++) {
			for(int j=0; j<Input.length; j++) {
				for(int k=1; k<Input.length+1; k++) {
					MagicSquare[i][j][0] = Input[i][j];
					MagicSquare[i][j][k] = k;
				}
			}
		}
		return MagicSquare;
	}



	// sumを計算
	public static int sum(int MagicSquare[][][]) {
		int sum = 0;
		for(int i=0; i<MagicSquare.length; i++) {
			for(int j=0; j<MagicSquare.length; j++) {
				sum += MagicSquare[i][j][0];
			}
		}
		return sum;
	}



	// 決定している魔法陣の値に対して
	// (1)決定したそのマス自身の候補をすべて0にする
	// (2)まわりのマスの候補からその数をなくしていく
	public static int[][][] consideredRefining(int MagicSquare[][][]) {
		for(int i=0; i<MagicSquare.length; i++) {
			for(int j=0; j<MagicSquare.length; j++) {
				if( MagicSquare[i][j][0]!=0 ) {
					// (1)決定したそのマス自身の候補をすべて0にする
					for(int k=1; k<MagicSquare.length+1; k++) {
						MagicSquare[i][j][k] = 0;
					}
					// (2)まわりのマスに対して、決定されたその数を候補から外していく
					// (i)四角、i, j を3で割ったあまりで区別
					for(int p=(i-(i%3)); p<((i-(i%3))+3); p++) {
						for(int q=(j-(j%3)); q<((j-(j%3))+3); q++) {
							MagicSquare[p][q][ MagicSquare[i][j][0] ] = 0;
						}
					}
					// (ii)縦列
					for(int p=0; p<MagicSquare.length; p++) {
						MagicSquare[p][j][ MagicSquare[i][j][0] ] = 0;
					}
					// (iii)横列
					for(int q=0; q<MagicSquare.length; q++) {
						MagicSquare[i][q][ MagicSquare[i][j][0] ] = 0;
					}
				}
			}
		}
		return MagicSquare;
	}



	// 候補が一つに絞られたら魔法陣に代入
	public static int[][][] define(int MagicSquare[][][]) {
		int count;
		int k_result = 0;
		for(int i=0; i<MagicSquare.length; i++) {
			for(int j=0; j<MagicSquare.length; j++) {
				count = 0;
				for(int k=1; k<MagicSquare.length+1; k++) {
					if( MagicSquare[i][j][k]!=0) {
						count++;
						k_result = k;
					}
				}
				if( count==1 ) {
					MagicSquare[i][j][0] = MagicSquare[i][j][k_result];
				}
			}
		}
		return MagicSquare;
	}



	// そのマスの候補が一つに絞られなくても、
	// 大マスやその行, 列にその数の候補がそれしかなかったら確定
	public static int[][][] alreadyOK(int MagicSquare[][][]) {
		int count;
		for(int i=0; i<MagicSquare.length; i++) {
			for(int j=0; j<MagicSquare.length; j++) {
				for(int k=1; k<MagicSquare.length+1; k++) {
					if( MagicSquare[i][j][k]!=0 ) {
						// 四角
						count = 0;
						for(int p=(i-(i%3)); p<((i-(i%3))+3); p++) {
							for(int q=(j-(j%3)); q<((j-(j%3))+3); q++) {
								if( (p!=i | q!=j) & MagicSquare[p][q][k]==MagicSquare[i][j][k] ) {
									count++;
								}
							}
						}
						if( count==0 ) {
							MagicSquare[i][j][0] = MagicSquare[i][j][k];
							break;
						}
						// 縦列
						count = 0;
						for(int p=0; p<MagicSquare.length; p++) {
							if( p!=i & MagicSquare[p][j][k]==MagicSquare[i][j][k] ) {
								count++;
							}
						}
						if( count==0 ) {
							MagicSquare[i][j][0] = MagicSquare[i][j][k];
							break;
						}
						// 横列
						count = 0;
						for(int q=0; q<MagicSquare.length; q++) {
							if( q!=j & MagicSquare[i][q][k]==MagicSquare[i][j][k] ) {
								count++;
							}
						}
						if( count==0 ) {
							MagicSquare[i][j][0] = MagicSquare[i][j][k];
							break;
						}
					}
				}
			}
		}
		return MagicSquare;
	}



	// 初期ループ
	public static int[][][] firstLoop(int MagicSquare[][][]) {
		int sum = Process1.sum(MagicSquare);
		while( sum<405 ) {
			int sum2 = sum;

			/* →なくてよい
			// 決定している魔法陣の値に対して
			// (1)決定したそのマス自身の候補をすべて0にする
			// (2)まわりのマスの候補からその数をなくしていく
			MagicSquare = Process.consideredRefining(MagicSquare);
			// 候補が一つに絞られたら魔法陣に代入
			MagicSquare = Process.define(MagicSquare);
			*/

			// 決定している魔法陣の値に対して
			// (1)決定したそのマス自身の候補をすべて0にする
			// (2)まわりのマスの候補からその数をなくしていく
			MagicSquare = Process1.consideredRefining(MagicSquare);
			// そのマスの候補が一つに絞られなくても、
			// 大マスやその行, 列にその数の候補がそれしかなかったら確定
			MagicSquare = Process1.alreadyOK(MagicSquare);
			// sumを計算
			sum = Process1.sum(MagicSquare);
			if( sum2==sum ) {
				break;
			}
		}
		return MagicSquare;
	}



	// 仮定ループ
	public static int[][][] virtualLoop(int MagicSquare[][][]) {
		int n = MagicSquare.length;
		int sum = Process1.sum(MagicSquare);
		if( sum<405 ) {
			int VirtualMagicSquare[][][] = new int[n][n][n+1];
			// 残りの候補選び
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					for(int k=1; k<n+1; k++) {
						if( MagicSquare[i][j][k]!=0 ) {
							// 候補を見つけたら仮定魔法陣を作成
							for(int i2=0; i2<n; i2++) {
								for(int j2=0; j2<n; j2++) {
									for(int k2=0; k2<n+1; k2++) {
										VirtualMagicSquare[i2][j2][k2] = MagicSquare[i2][j2][k2];
									}
								}
							}
							VirtualMagicSquare[i][j][0] = VirtualMagicSquare[i][j][k];
							// 仮定に対しループ実行
							VirtualMagicSquare = Process1.firstLoop(VirtualMagicSquare);
							// 成功し解が出たら取り出す
							sum = Process1.sum(VirtualMagicSquare);
							if( sum==405 ) {
								// System.out.println("実験に成功しました。");
								for(int i3=0; i3<n; i3++) {
									for(int j3=0; j3<n; j3++) {
										for(int k3=0; k3<n+1; k3++) {
											MagicSquare[i3][j3][k3] = VirtualMagicSquare[i3][j3][k3];
										}
									}
								}
							}
						} // if 決定しているかいないか
						if( sum==405 ) {
							break;
						}
					} // k
					if( sum==405 ) {
						break;
					}
				} // j
				if( sum==405 ) {
					break;
				}
			} // i
		} // if
		return MagicSquare;
	}



}
