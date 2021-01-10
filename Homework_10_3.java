package Homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Homework_10_3 {
	
	private String branch;

	public static void main(String[]args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
		Date date = null;
		String dString;
		int type;
		
		String regex = "^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})" //0001年到9999年
				+ "(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))" //大小月驗證,及2月28天驗證
				+ "|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229)$"; //閏年的2月29天驗證
		
		
		while(true) {
			
			try {
				if(date == null) {
					System.out.println("請輸入日期(年月日:20110131):");
				Integer d = sc.nextInt();
				dString = d.toString();
				if(!(dString.matches(regex)))
					throw new Homework_10_2Exception("請輸入正確的日期格格式(年月日:20210101)");
				date = sdf.parse(dString);
				}
				
				System.out.println("欲格式化成 (1)年/月/日 (2)月/日/年 (3)日/月/年 ");
				type = sc.nextInt();
				if(type < 1 || type >3)
					throw new Homework_10_2Exception("請輸入數字1~3");
				break;
			}catch(Homework_10_2Exception e) {
				System.out.println(e.getMessage());
			}catch(InputMismatchException e) {
				System.out.println("格式不正確,請照格式輸入數字");
				@SuppressWarnings("unused")
				String clear = sc.next();
			}
		}
		
		switch(type) {
		case 1:
			sdf.applyPattern("yyyy/mm/dd");
			System.out.println(sdf.format(date));
			break;
		case 2:
			sdf.applyPattern("mm/dd/yyyy");
			System.out.println(sdf.format(date));
			break;
		case 3:
			sdf.applyPattern("dd/mm/yyyy");
			System.out.println(sdf.format(date));
			break;
		}
		
	}

}
