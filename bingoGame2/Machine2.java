package bingoGame2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Machine2 {
	// １から７５までのランダム配列
	private Integer[] numbers;

	// 抽選回数７５回までのカウント
	private int index = 0;


	// コンストラクタ（numbersの初期化）
	public Machine2() {

		List<Integer> numberList = new ArrayList<Integer>();

		for(int i = 1 ; i <= 75 ; i++) {
			numberList.add(i);
		}	

		Collections.shuffle(numberList);

		// リストから配列に格納
		numbers = numberList.toArray(new Integer[numberList.size()]);

	}

	// 抽選回数７５回以下かどうかの判定メソッド
	public boolean hasNext( ) {

		return index < 75;

	}

	// 抽選メソッド
	public int next() {

		return numbers[index++];

	}

}