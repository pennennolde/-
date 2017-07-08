package magicSquare;

public class MagicSquareOrigin {

	public static void main(String[] args) {

		/*
		 * 魔法陣の定義
		 */

		int n = 9; // 9×9の魔法陣の場合

		int sum; // 終了判定のための
		// 魔法陣のすべてのマスが埋まったら終了(魔法陣の数の合計が405になったら)

		// 概形
		int MagicSquare[][][] = new int[n][n][n+1];




		int Input[][] = {{2,0,0,0,0,0,0,0,6},
				{0,9,6,3,0,8,7,5,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,6,0,4,0,0,0},
				{0,0,0,0,8,0,0,0,0},
				{0,3,0,1,0,5,0,8,0},
				{0,2,4,7,0,1,8,9,0},
				{0,5,0,8,9,3,0,1,0},
				{0,0,0,5,0,2,0,0,0}};

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				MagicSquare[i][j][0] = Input[i][j];
			}
		}



		/*
		MagicSquare[0][0][0]= 1;
		MagicSquare[0][1][0]= 6;
		MagicSquare[0][2][0]= 2;
		MagicSquare[0][3][0]= 4;
		MagicSquare[0][4][0]= 3;
		MagicSquare[0][5][0]= 9;
		MagicSquare[0][6][0]= 0;
		MagicSquare[0][7][0]= 0;
		MagicSquare[0][8][0]= 5;

		MagicSquare[1][0][0]= 0;
		MagicSquare[1][1][0]= 0;
		MagicSquare[1][2][0]= 7;
		MagicSquare[1][3][0]= 0;
		MagicSquare[1][4][0]= 0;
		MagicSquare[1][5][0]= 2;
		MagicSquare[1][6][0]= 0;
		MagicSquare[1][7][0]= 0;
		MagicSquare[1][8][0]= 4;

		MagicSquare[2][0][0]= 0;
		MagicSquare[2][1][0]= 0;
		MagicSquare[2][2][0]= 4;
		MagicSquare[2][3][0]= 0;
		MagicSquare[2][4][0]= 0;
		MagicSquare[2][5][0]= 0;
		MagicSquare[2][6][0]= 6;
		MagicSquare[2][7][0]= 2;
		MagicSquare[2][8][0]= 0;

		MagicSquare[3][0][0]= 0;
		MagicSquare[3][1][0]= 0;
		MagicSquare[3][2][0]= 0;
		MagicSquare[3][3][0]= 3;
		MagicSquare[3][4][0]= 0;
		MagicSquare[3][5][0]= 0;
		MagicSquare[3][6][0]= 0;
		MagicSquare[3][7][0]= 8;
		MagicSquare[3][8][0]= 0;

		MagicSquare[4][0][0]= 6;
		MagicSquare[4][1][0]= 0;
		MagicSquare[4][2][0]= 0;
		MagicSquare[4][3][0]= 0;
		MagicSquare[4][4][0]= 0;
		MagicSquare[4][5][0]= 0;
		MagicSquare[4][6][0]= 0;
		MagicSquare[4][7][0]= 0;
		MagicSquare[4][8][0]= 1;

		MagicSquare[5][0][0]= 0;
		MagicSquare[5][1][0]= 7;
		MagicSquare[5][2][0]= 0;
		MagicSquare[5][3][0]= 0;
		MagicSquare[5][4][0]= 0;
		MagicSquare[5][5][0]= 4;
		MagicSquare[5][6][0]= 0;
		MagicSquare[5][7][0]= 0;
		MagicSquare[5][8][0]= 0;

		MagicSquare[6][0][0]= 0;
		MagicSquare[6][1][0]= 1;
		MagicSquare[6][2][0]= 8;
		MagicSquare[6][3][0]= 0;
		MagicSquare[6][4][0]= 0;
		MagicSquare[6][5][0]= 0;
		MagicSquare[6][6][0]= 5;
		MagicSquare[6][7][0]= 0;
		MagicSquare[6][8][0]= 0;

		MagicSquare[7][0][0]= 2;
		MagicSquare[7][1][0]= 0;
		MagicSquare[7][2][0]= 0;
		MagicSquare[7][3][0]= 5;
		MagicSquare[7][4][0]= 0;
		MagicSquare[7][5][0]= 0;
		MagicSquare[7][6][0]= 7;
		MagicSquare[7][7][0]= 0;
		MagicSquare[7][8][0]= 0;

		MagicSquare[8][0][0]= 4;
		MagicSquare[8][1][0]= 0;
		MagicSquare[8][2][0]= 0;
		MagicSquare[8][3][0]= 7;
		MagicSquare[8][4][0]= 1;
		MagicSquare[8][5][0]= 8;
		MagicSquare[8][6][0]= 2;
		MagicSquare[8][7][0]= 9;
		MagicSquare[8][8][0]= 3;
		*/



		// MagicSquare[*][*][0] にはそのマスの実際の値、なしのとき0
		// MagicSquare[*][*][1] ~ [*][*][9] はそのマスの候補1~9、あり得ないとき0

		// 数の候補群、初期設定
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k=1; k<n+1; k++) {
					MagicSquare[i][j][k] = k;
				}
			}
		}



		System.out.println("before MagicSquare=");
		PrintOut.printMagicSquare(MagicSquare);
		System.out.println();
		PrintOut.printConsidered(MagicSquare);





		/*
		 *  魔法陣を解く
		 */


		// sumを計算
		sum = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sum += MagicSquare[i][j][0];
			}
		}
		System.out.println("start_sum= " + sum);


		int loop = 1;

		while( sum<405 ) {


			System.out.println();
			System.out.println("初期ループ : " + loop);
			loop++;

			int sum2 = sum;

			// 決定している魔法陣の値に対して
			// (1)決定したそのマス自身の候補をすべて0にする
			// (2)まわりのマスの候補からその数をなくしていく
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if( MagicSquare[i][j][0]!=0 ) {
						// (1)決定したそのマス自身の候補をすべて0にする
						for(int k=1; k<n+1; k++) {
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
						for(int p=0; p<n; p++) {
							MagicSquare[p][j][ MagicSquare[i][j][0] ] = 0;
						}
						// (iii)横列
						for(int q=0; q<n; q++) {
							MagicSquare[i][q][ MagicSquare[i][j][0] ] = 0;
						}
					}
				}
			}



			System.out.println();
			PrintOut.printMagicSquare(MagicSquare);
			System.out.println();
			PrintOut.printConsidered(MagicSquare);




			// 候補が一つに絞られたら魔法陣に代入
			int count;
			int k_result = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					count = 0;
					for(int k=1; k<n+1; k++) {
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

			// sumを計算
			sum = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					sum += MagicSquare[i][j][0];
				}
			}


			// 決定している魔法陣の値に対して
			// (1)決定したそのマス自身の候補をすべて0にする
			// (2)まわりのマスの候補からその数をなくしていく
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if( MagicSquare[i][j][0]!=0 ) {
						// (1)決定したそのマス自身の候補をすべて0にする
						for(int k=1; k<n+1; k++) {
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
						for(int p=0; p<n; p++) {
							MagicSquare[p][j][ MagicSquare[i][j][0] ] = 0;
						}
						// (iii)横列
						for(int q=0; q<n; q++) {
							MagicSquare[i][q][ MagicSquare[i][j][0] ] = 0;
						}
					}
				}
			}



			System.out.println();
			PrintOut.printMagicSquare(MagicSquare);
			System.out.println();
			PrintOut.printConsidered(MagicSquare);




			// そのマスの候補が一つに絞られなくても、
			// 大マスやその行, 列にその数の候補がそれしかなかったら確定
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					for(int k=1; k<n+1; k++) {
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
							for(int p=0; p<n; p++) {
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
							for(int q=0; q<n; q++) {
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


			// sumを計算
			sum = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					sum += MagicSquare[i][j][0];
				}
			}


			if( sum2==sum ) {
				System.out.println();
				System.out.println("break;  今回のループで操作は行われませんでした。終了します。");
				break;
			}

		}













		/*
		 *  いずれかのマスを候補から選んで仮定して実験
		 *  →成功したらそれが結果
		 */

		if( sum<405 ) {


			System.out.println();
			PrintOut.printMagicSquare(MagicSquare);
			System.out.println();
			PrintOut.printConsidered(MagicSquare);





			// 実験用にコピーをとる
			int VirtualMagicSquare[][][] = new int[n][n][n+1];



			// 仮定
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					for(int k=1; k<n+1; k++) {
						if( MagicSquare[i][j][k]!=0 ) {
							int sum3 = sum;
							for(int i3=0; i3<n; i3++) {
								for(int j3=0; j3<n; j3++) {
									for(int k3=0; k3<n+1; k3++) {
										VirtualMagicSquare[i3][j3][k3] = MagicSquare[i3][j3][k3];
									}
								}
							}
							VirtualMagicSquare[i][j][0] = VirtualMagicSquare[i][j][k];
							sum3 += VirtualMagicSquare[i][j][0];

							System.out.println();
							System.out.println("仮定ループ : [" + (i+1) + "][" + (j+1) + "][" + k + "]");




							// ここからループのコピー

							while( sum3<405 ) {

								int sum2 = sum3;

								// 決定している魔法陣の値に対して
								// (1)決定したそのマス自身の候補をすべて0にする
								// (2)まわりのマスの候補からその数をなくしていく
								for(int i1=0; i1<n; i1++) {
									for(int j1=0; j1<n; j1++) {
										if( VirtualMagicSquare[i1][j1][0]!=0 ) {
											// (1)決定したそのマス自身の候補をすべて0にする
											for(int k1=1; k1<n+1; k1++) {
												VirtualMagicSquare[i1][j1][k1] = 0;
											}
											// (2)まわりのマスに対して、決定されたその数を候補から外していく
											// (i)四角、i, j を3で割ったあまりで区別
											for(int p=(i1-(i1%3)); p<((i1-(i1%3))+3); p++) {
												for(int q=(j1-(j1%3)); q<((j1-(j1%3))+3); q++) {
													VirtualMagicSquare[p][q][ VirtualMagicSquare[i1][j1][0] ] = 0;
												}
											}
											// (ii)縦列
											for(int p=0; p<n; p++) {
												VirtualMagicSquare[p][j1][ VirtualMagicSquare[i1][j1][0] ] = 0;
											}
											// (iii)横列
											for(int q=0; q<n; q++) {
												VirtualMagicSquare[i1][q][ VirtualMagicSquare[i1][j1][0] ] = 0;
											}
										}
									}
								}


								/*
							System.out.println();
							PrintOut.printMagicSquare(VirtualMagicSquare);
							System.out.println();
							PrintOut.printConsidered(VirtualMagicSquare);
								 */



								// 候補が一つに絞られたら魔法陣に代入
								int count;
								int k_result = 0;
								for(int i1=0; i1<n; i1++) {
									for(int j1=0; j1<n; j1++) {
										count = 0;
										for(int k1=1; k1<n+1; k1++) {
											if( VirtualMagicSquare[i1][j1][k1]!=0) {
												count++;
												k_result = k1;
											}
										}
										if( count==1 ) {
											VirtualMagicSquare[i1][j1][0] = VirtualMagicSquare[i1][j1][k_result];
											sum3 += VirtualMagicSquare[i1][j1][0];
										}
									}
								}


								// 決定している魔法陣の値に対して
								// (1)決定したそのマス自身の候補をすべて0にする
								// (2)まわりのマスの候補からその数をなくしていく
								for(int i1=0; i1<n; i1++) {
									for(int j1=0; j1<n; j1++) {
										if( VirtualMagicSquare[i1][j1][0]!=0 ) {
											// (1)決定したそのマス自身の候補をすべて0にする
											for(int k1=1; k1<n+1; k1++) {
												VirtualMagicSquare[i1][j1][k1] = 0;
											}
											// (2)まわりのマスに対して、決定されたその数を候補から外していく
											// (i)四角、i, j を3で割ったあまりで区別
											for(int p=(i1-(i1%3)); p<((i1-(i1%3))+3); p++) {
												for(int q=(j1-(j1%3)); q<((j1-(j1%3))+3); q++) {
													VirtualMagicSquare[p][q][ VirtualMagicSquare[i1][j1][0] ] = 0;
												}
											}
											// (ii)縦列
											for(int p=0; p<n; p++) {
												VirtualMagicSquare[p][j1][ VirtualMagicSquare[i1][j1][0] ] = 0;
											}
											// (iii)横列
											for(int q=0; q<n; q++) {
												VirtualMagicSquare[i1][q][ VirtualMagicSquare[i1][j1][0] ] = 0;
											}
										}
									}
								}


								/*
							System.out.println();
							PrintOut.printMagicSquare(VirtualMagicSquare);
							System.out.println();
							PrintOut.printConsidered(VirtualMagicSquare);
								 */



								// そのマスの候補が一つに絞られなくても、
								// 大マスやその行, 列にその数の候補がそれしかなかったら確定
								for(int i1=0; i1<n; i1++) {
									for(int j1=0; j1<n; j1++) {
										for(int k1=1; k1<n+1; k1++) {
											if( VirtualMagicSquare[i1][j1][k1]!=0 ) {
												// 四角
												count = 0;
												for(int p=(i1-(i1%3)); p<((i1-(i1%3))+3); p++) {
													for(int q=(j1-(j1%3)); q<((j1-(j1%3))+3); q++) {
														if( (p!=i1 | q!=j1) & VirtualMagicSquare[p][q][k1]==VirtualMagicSquare[i1][j1][k1] ) {
															count++;
														}
													}
												}
												if( count==0 ) {
													VirtualMagicSquare[i1][j1][0] = VirtualMagicSquare[i1][j1][k1];
													sum3 += VirtualMagicSquare[i1][j1][0];
													break;
												}
												// 縦列
												count = 0;
												for(int p=0; p<n; p++) {
													if( p!=i1 & VirtualMagicSquare[p][j1][k1]==VirtualMagicSquare[i1][j1][k1] ) {
														count++;
													}
												}
												if( count==0 ) {
													VirtualMagicSquare[i1][j1][0] = VirtualMagicSquare[i1][j1][k1];
													sum3 += VirtualMagicSquare[i1][j1][0];
													break;
												}
												// 横列
												count = 0;
												for(int q=0; q<n; q++) {
													if( q!=j1 & VirtualMagicSquare[i1][q][k1]==VirtualMagicSquare[i1][j1][k1] ) {
														count++;
													}
												}
												if( count==0 ) {
													VirtualMagicSquare[i1][j1][0] = VirtualMagicSquare[i1][j1][k1];
													sum3 += VirtualMagicSquare[i1][j1][0];
													break;
												}
											}
										}
									}
								}


								if( sum2==sum3 ) {
									System.out.println();
									System.out.println("break;  今回のループで操作は行われませんでした。終了します。");
									break;
								}

								if( sum3==405 ) {
									System.out.println();
									System.out.println("実験に成功しました。");
									sum = sum3;
									for(int i2=0; i2<n; i2++) {
										for(int j2=0; j2<n; j2++) {
											for(int k2=0; k2<n+1; k2++) {
												MagicSquare[i2][j2][k2] = VirtualMagicSquare[i2][j2][k2];
											}
										}
									}
									break;
								}

							} // while




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










		System.out.println();
		System.out.println("end_sum= " + sum);

		System.out.println();
		System.out.println("after MagicSquare=");
		PrintOut.printMagicSquare(MagicSquare);
		System.out.println();
		PrintOut.printConsidered(MagicSquare);



	}
}
