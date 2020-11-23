package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		double num1=10.1;
		Double num2=10.2;
		
		double result1=num2+10;
		double result2=num1+num2;
		Double result3=num1+num2;
		
		// 10.2 => "10.2"
		String result4=num2.toString();
		// "99.9" => 99.9
		double result5=Double.parseDouble("99.9");
	}
}

// Integer.parseInt(); | Double.parseDouble(); 
// 가변배열을 쓰려면 기본 데이터 type으로는 들어가지 않음 (참조값만 들어가기 때문에, 그렇기 때문에 필요)