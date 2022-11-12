package bingoGame2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class Machine2 {
	// １から７５までのランダム配列
	private int[] numbers;

	// 抽選回数７５回までのカウント
	private int index = 0;

	int bingoNumber = 0;

	// コンストラクタ（numbersの初期化）
	public Machine2() {
		ArrayList<Integer> bingoNumber = new ArrayList<Integer>();

		for(int i = 1 ; i <= 75 ; i++) {
			bingoNumber.add(i);
		}	

		Collections.shuffle(bingoNumber);

		// リストから配列に格納
		numbers = new int[bingoNumber.size()];
		bingoNumber.toArray();

	}
	// 抽選回数７５回以下かどうかの判定メソッド
	public boolean hasNext( ) {

		return index < 75;

	}

	// 抽選メソッド
	public int next() {
		bingoNumber = numbers[index];

		return index;

	}

}