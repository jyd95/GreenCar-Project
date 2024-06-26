package calendar;

import java.util.Calendar;

import javax.swing.JButton;

import lombok.Data;
@Data
public class Diary {
	// 버튼 배치
	JButton[] buttons;

	// 자바 캘린더 사용
	private Calendar cal = Calendar.getInstance();

	// 날짜 받아오기
	private int year;
	private int month;
	private int day;

	private int startDay;

	String tenUnderM;
	String tenUnderD;

	public Diary() {
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
	}

	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}

	public String getCalText() {
		return year + "년" + month + "월";
	}

	public String getAllCal(String day) {
		if (month < 10) {
			tenUnderM = "0" + month;
		} else {
			tenUnderM = Integer.toString(month);
		}
		if (Integer.valueOf(day) < 10) {
			tenUnderD = "0" + day;
		} else {
			tenUnderD = day;
		}
		return year + "-" + tenUnderM + "-" + tenUnderD;
	}

	// 버튼 날짜 출력
	public void setCal() {
		// calendar 객체 날짜 1일 설정
		// 월의 범위는 0~11 이기 때문에 실제월 - 1
		// 일은 달력이 1일부터 시작하기 때문에 1일로 셋팅
		cal.set(year, month - 1, 1);

		// 그 달의 1일 요일 수
		startDay = cal.get(Calendar.DAY_OF_WEEK);
		// 요일 수 1일 시작, 배열 0부터 시작
		startDay--;

		for (int i = 1; i <= cal.getActualMaximum(cal.DATE); i++) {
			// buttons[0] ~ [6] : 일 ~ 토
			// buttons[7] ~ : 날짜 출력
			buttons[6 + startDay + i].setText(String.valueOf(i));
		}
	}

	// 달력 데이터 넣기
	public void initCalData(int gap) {
		// 버튼 날짜 지우기
		for (int i = 7; i < buttons.length; i++) {
			buttons[i].setText("");
		}
		month += gap;
		if (month <= 0) {
			year--;
			month = 12;
		} else if (month > 12) {
			year++;
			month = 1;
		}
		setCal();
	}

	public static void main(String[] args) {
		Diary dr = new Diary();

	}
}
