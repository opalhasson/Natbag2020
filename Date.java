
public class Date {
	private int year;
	private int day;
	private int month;
	
	public Date(int day, int month, int year) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	public int getYear() {
		return year;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public void setYear(int year) {
		if (year <= 2020 && year >= 1900) {
			this.year = year;
		}

		else {
			this.year = 2020;
		}
	}

	public void setMonth(int month) {
		if (month >= 1 && month <= 12) {
			this.month = month;
		} else {
			this.month = 1;
		}
	}

	public void setDay(int day) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			if (day <= 31 && day >= 1) {
				this.day = day;
			} else {
				this.day = 1;
			}
		} else if (month == 2) {
			if (day <= 28 && day >= 1) {
				this.day = day;

			} else {
				this.day = 1;
			}
		} else {
			if (day <= 30 && day >= 1) {
				this.day = day;
			} else {
				this.day = 1;
			}

		}
	}

	@Override
	public String toString() {
		return day + "/" + month + "/" + year;
	}

	

}
