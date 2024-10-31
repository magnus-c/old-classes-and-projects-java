public class Employee {
	private String employeeName;
	private char employeeClass;

	// constructor
	public Employee() {
	}

	// getters and settters
	public String getEmployeeName() {
		return this.employeeName;
	}

	public char getEmployeeClass() {
		return employeeClass;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setEmployeeClass(char employeeClass) {
		this.employeeClass = employeeClass;
	}

	public static class SalariedEmployee extends Employee {
		private double monthlyRate;
		private boolean bonus;

		// constructor
		public SalariedEmployee() {
		}

		// getters and setters
		public double getMonthlyRate() {
			return monthlyRate;
		}

		public boolean getBonus() {
			return bonus;
		}

		public void setMonthlyRate(double monthlyRate) {
			this.monthlyRate = monthlyRate;
		}

		public void setBonus(boolean bonus) {
			this.bonus = bonus;
		}

	}

	public static class HourlyEmployee extends Employee {
		private int hoursWeek;
		private double hourlyRate;

		// constructor
		public HourlyEmployee() {
		}

		// getters and setters
		public int getHoursWeek() {
			return hoursWeek;
		}

		public double getHourlyRate() {
			return hourlyRate;
		}

		public void setHoursWeek(int hoursWeek) {
			this.hoursWeek = hoursWeek;
		}

		public void setHourlyRate(double hourlyRate) {
			this.hourlyRate = hourlyRate;
		}
	}

	public static class CommissionedEmployee extends Employee {

		private double sales;

		// constructor
		public CommissionedEmployee() {
		}

		// getters and setters
		public double getSales() {
			return sales;
		}

		public void setSales(double sales) {
			this.sales = sales;
		}

	}
}