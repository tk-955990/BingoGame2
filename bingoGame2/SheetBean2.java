package bingoGame2;

import java.util.Random;
public class SheetBean2 {
	private int[] listB;
	private int[] listI;
	private int[] listN;
	private int[] listG;
	private int[] listO;

	public int[] getListB() {
		return listB;
	}
	public void setListB(int[] listB) {
		this.listB = listB;
	}

	public int[] getListI() {
		return listI;
	}
	public void setListI(int[] listI) {
		this.listI = listI;
	} 

	public int[] getListN() {
		return listN;
	}
	public void setListN(int[] listN) {
		this.listN = listN;
	}

	public int[] getListG() {
		return listG;
	}
	public void setListG(int[] listG) {
		this.listG = listG;
	}

	public int[] getListO() {
		return listO;
	}
	public void setListO(int[] listO) {
		this.listO = listO;
	} 


	// コンストラクタ
	public SheetBean2() {

		Random rand = new Random();
		boolean isUnique = true;

		listB = new int[5];
		listI = new int[5];
		listN = new int[5];
		listG = new int[5];
		listO = new int[5];  

		int count = 0;

		while (count < 5) {

			int valueB = rand.nextInt(15)+1;
			int valueI = rand.nextInt(15)+15;
			int valueN = rand.nextInt(15)+31;
			int valueG = rand.nextInt(15)+46;
			int valueO = rand.nextInt(15)+61;

			for (int i = 0; i < count; i++) {
				if( 
						(listB[i] != valueB)&&
						(listI[i] != valueI)&&
						(listN[i] != valueN)&&
						(listG[i] != valueG)&&
						(listO[i] != valueO)
						) {
					isUnique = true; 
				} else {
					isUnique = false; 
					break; 
				}
			}
			if (isUnique == true) {
				listB[count] = valueB;
				listI[count] = valueI;
				listN[count] = valueN;
				listG[count] = valueG;
				listO[count] = valueO;
				count++;
			}
		}	
		// 真ん中のマスの処理
		listN[2] = 99;
	}

	// 穴あけメソッド
	public boolean hit(int bingoNumber) {
		boolean hitFlag = true;
		int check = 0;
		for(int i = 0;i<5;i++) {
			if(listB[i] == bingoNumber) {
				listB[i] = 99;	
				check++;
			}else if(listI[i] == bingoNumber) {
				listI[i] = 99;
				check++;
			}else if(listG[i] == bingoNumber) {
				listG[i] = 99;	
				check++;
			}else if(listG[i] == bingoNumber) {
				listG[i] = 99;	
				check++;
			}else if(listG[i] == bingoNumber) {
				listG[i] = 99;	
				check++;
			}else if(listO[i] == bingoNumber) {
				listO[i] = 99;	
				check++;
			}
		}if(check >0) {
			hitFlag = true;
			System.out.println("☆☆☆☆   あたりです   ☆☆☆☆");

		}else {
			hitFlag = false;
			System.out.println("。。　残念… ハズレです   。。。");
		}
		return hitFlag;
	}

	// ビンゴ判定メソッド
	public boolean isBingo() {
		boolean bingoFlag = true;

		int[][] bingoSheet = new int[5][5];
		bingoSheet[0] = listB;
		bingoSheet[1] = listI;
		bingoSheet[2] = listN;
		bingoSheet[3] = listG;
		bingoSheet[4] = listO;

		// 縦のカウント
		int verticalCount = 0;
		// 横のカウント
		int sideCount = 0;

		for(int j = 0;j<bingoSheet[0].length;j++) {
			verticalCount = 0;
			sideCount = 0;
			for(int i = 0;i<bingoSheet.length;i++) {
				if(bingoSheet[i][j] == 99) {
					sideCount++;			
				}if(bingoSheet[j][i] == 99) {
					verticalCount++;
				}
			}
			// 横のビンゴ判定
			if(sideCount == 5) {
				bingoFlag = true;
				bingoView();
				return bingoFlag;
			}
			// 縦のビンゴ判定
			if(verticalCount == 5) {
				bingoFlag = true;
				bingoView();
				return bingoFlag;
			}
			// クロスのビンゴ判定
		}if(((bingoSheet[0][0] == 99)&&
				(bingoSheet[1][1] == 99)&&
				(bingoSheet[2][2] == 99)&&
				(bingoSheet[3][3] == 99)&&
				(bingoSheet[4][4] == 99)
				) ||
				((bingoSheet[0][4] == 99)&&
						(bingoSheet[1][3] == 99)&&
						(bingoSheet[2][2] == 99)&&
						(bingoSheet[3][1] == 99)&&
						(bingoSheet[4][0] == 99))
				) {
			bingoFlag = true; 
			bingoView();
			return bingoFlag;
		}else {
			bingoFlag = false;
		}
		return bingoFlag;
	}	

	// リーチ判定メソッド
	public boolean isReach() {
		boolean reachFlag = true;

		int[][] bingoSheet = new int[5][5];
		bingoSheet[0] = listB;
		bingoSheet[1] = listI;
		bingoSheet[2] = listN;
		bingoSheet[3] = listG;
		bingoSheet[4] = listO;

		// 縦のカウント
		int verticalCount = 0;
		// 横のカウント
		int sideCount = 0;

		// クロスのカウント
		int crossCountA = 0;
		int crossCountB = 0;

		int viewCount = 0;

		for(int j = 0;j<bingoSheet[0].length;j++) {
			verticalCount = 0;
			sideCount = 0;
			viewCount = 0;
			for(int i = 0;i<bingoSheet.length;i++) {
				viewCount = 0;
				if(bingoSheet[i][j] == 99) {
					sideCount++;			
				}if(bingoSheet[j][i] == 99) {
					verticalCount++;
				}
			}
			// 横のリーチ判定
			if(sideCount == 4) {
				reachFlag = true;
				if(viewCount == 0) {
					reachView();
					viewCount++;
				}
				return reachFlag;
			}
			// 縦のリーチ判定
			if(verticalCount == 4) {
				reachFlag = true;
				if(viewCount == 0) {
					reachView();
					viewCount++;
				}
				return reachFlag;
			}
		// クロスのリーチ判定
		}if(bingoSheet[0][0] == 99) {
			for(int i =0;i<bingoSheet.length;i++) {
				// 右斜め下のカウント
				int nextA = bingoSheet[0+i][0+i];
				if(nextA == 99) {
					crossCountA++;
				}
			}
		}if(bingoSheet[0][4] == 99) {
			for(int i =0;i<bingoSheet.length;i++) {
				// 右斜め上のカウント
				int nextB = bingoSheet[0+i][4-i];
				if(nextB == 99) {
					crossCountB++;
				}
			}
			// リーチ判定
			if((crossCountA == 4)||
					(crossCountB == 4)) {
				reachFlag = true;
				if(viewCount == 0) {
					reachView();
					viewCount++;
				}
				return reachFlag;
			}
		}else {
			reachFlag = false;
		}
		return reachFlag;
	}	

	//　ビンゴ表示
	public void bingoView() {
		System.out.println("☆☆☆☆☆   BINGO!!   ☆☆☆☆☆");
		System.out.println("　　　　　　　　　　　　　　　　");
		System.out.println("☆☆☆☆☆   BINGO!!   ☆☆☆☆☆");
		System.out.println("　　　　　　　　　　　　　　　　");
		System.out.println("☆☆☆☆☆   BINGO!!   ☆☆☆☆☆");
		System.out.println("　　　　　　　　　　　　　　　　");
	}

	//　リーチ表示
	public void reachView() {
		System.out.println("☆☆☆☆☆   リーチ中  ☆☆☆☆☆");
		System.out.println("　　　　　　　　　　　　　　　　");
		System.out.println("☆☆☆☆☆   リーチ中  ☆☆☆☆☆");
		System.out.println("　　　　　　　　　　　　　　　　");
		System.out.println("☆☆☆☆☆   リーチ中  ☆☆☆☆☆");
		System.out.println("　　　　　　　　　　　　　　　　");
	}

	// ビンゴシート表示メソッド
	public void print() {
		System.out.println("   B   I   N   G   O ");
		System.out.println(" ┏━┳━┳━┳━┳━┓");

		for(int j = 0;j<5;j++) {
			System.out.print(" ┃");
			if(listB[j] == 99) {
				System.out.print("★");
			}else {
				String str = String.format("%2d", this.listB[j]);
				System.out.print(str);
			}System.out.print("┃");
			if(listI[j] == 99) {
				System.out.print("★");
			}else {
				System.out.print(this.listI[j]);
			}System.out.print("┃");
			if(listN[j] == 99) {
				System.out.print("★");
			}else {
				System.out.print(this.listN[j]);
			}System.out.print("┃");
			if(listG[j] == 99) {
				System.out.print("★");
			}else {
				System.out.print(this.listG[j]);
			}System.out.print("┃");
			if(listO[j] == 99) {
				System.out.print("★");
			}else {
				System.out.print(this.listO[j]);
			}System.out.print("┃");
			System.out.println("");
			if(j<4) {
				System.out.println(" ┣━╋━╋━╋━╋━┫");	
			}else{
				System.out.println(" ┗━┻━┻━┻━┻━┛");
			}
		}
	}


}