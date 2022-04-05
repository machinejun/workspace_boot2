package lotto_game;

import java.util.Arrays;
import java.util.Random;

public class LottoSuffile {
	
	final static int lottoCount = 6;
	
	public LottoSuffile() {
		// TODO Auto-generated constructor stub
	}
	
	public int[] getLotto() {
		int[] lotto = new int[lottoCount];
		Random random = new Random();
		for(int i = 0 ; i < lotto.length ; i++) {
			int j = random.nextInt(45) + 1;
			lotto[i] = j;
			for(int e = 0; e < i; e++) {
				if(lotto[i] == lotto[e]) {
					i = i - 1;
					break;
				}
			}
		}
		//정렬 문제 해결
		Arrays.sort(lotto);
		for (int i : lotto) {
			System.out.println(i);
		}
		return lotto;
		
	}
}
