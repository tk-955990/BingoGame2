package bingoGame2;

import java.util.Scanner;

public class Game2 {

	static Machine2 machine = new Machine2();

	public static void main(String args[]) {
		SheetBean2   sheetBean   = new SheetBean2();
		Machine2 machine = new Machine2();
		int bingoNumber = 0 ;

		System.out.println("                                ");
		System.out.println("------ BingoGame Start !! ------");
		System.out.println("                                ");

		while(machine.hasNext()) {
			int nextflag = 0;
			sheetBean.print();
			bingoNumber = machine.next();

			String str = String.format("%2d", bingoNumber);
			System.out.println("☆☆☆　当選番号は " + str + " です☆☆☆");
			if(sheetBean.hit(bingoNumber) == true) {
				if(sheetBean.isBingo() == true) {
					
					sheetBean.print();
					break;
				}
				sheetBean.isReach();
			}  
			sheetBean.print();
			while(true ) {
				System.out.println("ゲームを続けますか？");
				System.out.println("　はい : 1   いいえ : 2 ");
				Scanner scanner = new Scanner(System.in);
				String next = scanner.next();

				// 入力文字数の判定
				if(next.length() != 1) {
					continue;
				}

				// ゲーム続行及び終了の判定
				char charNext = next.charAt(0);
				if((charNext =='1')||(charNext =='１')) {
					nextflag =1;
					break;
				}else if((charNext =='2')||(charNext =='２')) {
					nextflag =2;
					break;
				}else {
					continue;
				}
			}
			if(nextflag ==2) {
				break;
			}
		}
		System.out.println("-------- ゲーム終了です --------");
		System.out.println("                                ");
		System.out.println("                                ");
	}
}