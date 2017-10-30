package service;

public class CalculateService {
//	Model : Business Service(사용자가 요청한 업무를 처리)
	private static CalculateService instance;

	private CalculateService() {

	}

	public static CalculateService getInstance() {
		if (instance == null)
			instance = new CalculateService();
		return instance;
	}
//	사칙연산 계산을 처리하는 메소드.
//	UI하고 BL을 분리
	public String calculate(int num1, String operator, int num2) {
		int sum = 0;
		String op = null;
		
		switch(operator) {
		case "더하기" :
			sum = num1 + num2;
			op = "+";
			break;
		case "빼기" :
			sum = num1 - num2;
			op = "-";
			break;
		case "곱하기" :
			sum = num1 * num2;
			op = "*";
			break;
		case "나누기" :
			sum = num1 / num2;
			op = "/";
			break;
	}
	return String.format("%d %s %d = %d", num1, op, num2, sum);
	}
}
