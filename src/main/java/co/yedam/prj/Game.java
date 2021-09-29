package co.yedam.prj;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
	private int coin;
	Scanner sc = new Scanner(System.in);
	private int strike[] = new int[6];

	private int readInt(String msg) {
		System.out.println(msg);
		int num = 0;
		while (true) {
			String sth = sc.nextLine();
			try {
				num = Integer.parseInt(sth);
				break;
			} catch (Exception e) {
				System.out.println("숫자로 입력하여주세요.");
			}
		}
		return num;
	}

	private void lottoNum() {
		for (int i = 0; i < strike.length; i++) {
			strike[i] = (int) (Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) {
				if (strike[i] == strike[j]) {
					i--;
				}
			}
		}
//		for (int i = 0; i < strike.length; i++) {
//			for (int j = i + 1; j < strike.length; j++) {
//				if (strike[i] > strike[j]) {
//					int k = strike[j];
//					strike[j] = strike[i];
//					strike[i] = k;
//					
//				}
//			}
//		}
		Arrays.sort(strike);
		System.out.print("로또 번호는 : ");
		for (int i = 0; i < strike.length; i++) {
			System.out.print(strike[i] + " ");
		}
		System.out.println("");

	}

	private int insertMenu() {
		System.out.println("=========================");
		int i = readInt("사용하실 금액을 입력하여주세요.");
		System.out.println("=========================");
		System.out.println(i + "원을 사용하였습니다.");
		if (i % 1000 != 0) {
			System.out.println(i % 1000 + "원을 거슬러드렸습니다.");
		}
		int j = (i - i % 1000) / 1000;
		return coin = j;
	}

	private void playMenu() {
		System.out.println("자동 생성된 로또 번호는....");
		sc.nextLine();
		for (int i = 0; i < coin; i++) {
			if (i % 5 == 0) {
				System.out.println("===============================");
			}
			lottoNum();
		}
		System.out.println("===============================");
	}

	public void roll() {
		System.out.println("==========Lotto==========");
		insertMenu();
		playMenu();
		System.out.println(coin + "개의 로또가 생성되었습니다.");
	}

}
