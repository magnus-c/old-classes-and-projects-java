import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class Report {
	private ArrayList<String> employees;
	private ArrayList<Double> weeklyRates;
	private boolean employeeBonus;

	public Report() {
		employees = new ArrayList<>();
		weeklyRates = new ArrayList<>();
		employeeBonus = false;
	}

	public boolean isTypeCorrect(String type) {
		if (type.length() != 1) {
			return false;
		} else {
			if (type.equals("c") || type.equals("C") || type.equals("h") || type.equals("H") || type.equals("s")
					|| type.equals("S")) {
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean isBonusCorrect(String bonus) {
		if (bonus.length() != 1) {
			return false;
		} else {
			if (bonus.equals("Y") || bonus.equals("y") || bonus.equals("N") || bonus.equals("n")) {
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean isNameNotEmpty(String name) {
		if (name.length() < 1) {
			return false;
		} else
			return true;
	}
	
	public void addReportLineSalaried(Employee.SalariedEmployee anEmployee) {
		String s = ListItem.formatSalaried(anEmployee, ListItem.computeSalaryForSalariedEmployee(anEmployee));
		this.employees.add(s);
		this.weeklyRates.add(ListItem.computeSalaryForSalariedEmployee(anEmployee));
	}
	
	public void addReportLineHourly(Employee.HourlyEmployee anEmployee) {
		String s = ListItem.formatHourly(anEmployee, ListItem.computeSalaryForHourlyEmployee(anEmployee));
		this.employees.add(s);
		this.weeklyRates.add(ListItem.computeSalaryForHourlyEmployee(anEmployee));
	}

	public void addReportLineCommissioned(Employee.CommissionedEmployee anEmployee) {
		String s = ListItem.formatCommissioned(anEmployee, ListItem.computeSalaryForCommissionedEmployee(anEmployee));
		this.employees.add(s);
		this.weeklyRates.add(ListItem.computeSalaryForCommissionedEmployee(anEmployee));
	}

	public void print(Report report) {
		System.out.printf("%s\s%15s\s%10s\s%9s\s%7s\s%15s\n","Name", "Class", "Hours", "Sales", "Rate", "Weekly Pay");
		System.out.println("=================================================================");
		for (String s : report.employees
	             ) {
	            System.out.println(s);
	        }
		System.out.println("=================================================================");
		System.out.println(Total.formatTotal(Total.getTotal(report.weeklyRates)));
		if (report.employeeBonus) {
			System.out.println("*A 10% bonus is awarded");
		}
	}
	
	public static void main(String[] args) throws IllegalFormatException {
		Scanner scanner = new Scanner(System.in);
		Report report = new Report();
		System.out.println("How many employees you would like to input?");
		int number = scanner.nextInt();
		for (int i = 1; i <= number; i++) {
			System.out.println("Please enter name of the " + i + " employee");
			String name = scanner.nextLine();
			while (!report.isNameNotEmpty(name)) {
				name = scanner.nextLine();
			}
			System.out.println("Please enter class of the this employee. (S - salaried, H - hourly, C - commissioned)");
			String type = scanner.nextLine();
			type = type.toUpperCase();
			while (!report.isTypeCorrect(type)) {
				System.out.println("Invalid type! Try again! (S - salaried, H - hourly, C - commissioned)");
				type = scanner.nextLine();
				type = type.toUpperCase();
			}

			if (type.equals("S")) {
				Employee.SalariedEmployee anEmployee = new Employee.SalariedEmployee();
				anEmployee.setEmployeeName(name);
				anEmployee.setEmployeeClass('S');
				System.out.println("Please enter monthly salary for this employee");
				double monthlyRate = scanner.nextDouble();
				anEmployee.setMonthlyRate(monthlyRate);
				System.out.println("Would you like to give 10% bonus for this employee? (Y/N)");
				String bonus = scanner.nextLine();
				while (!report.isBonusCorrect(bonus)) {
					bonus = scanner.nextLine();
				}
				if (bonus.equals("Y") || bonus.equals("y")) {
					anEmployee.setBonus(true);
					report.employeeBonus = true;
				} else {
					anEmployee.setBonus(false);
				}
				report.addReportLineSalaried(anEmployee);
			}

			else if (type.equals("H")) {
				Employee.HourlyEmployee anEmployee = new Employee.HourlyEmployee();
				anEmployee.setEmployeeName(name);
				anEmployee.setEmployeeClass('H');
				System.out.println("Please enter number of hours this employee was working");
				int hoursWeek = scanner.nextInt();
				anEmployee.setHoursWeek(hoursWeek);
				System.out.println("Please enter hourly rate for this employee");
				double hourlyRate = scanner.nextDouble();
				anEmployee.setHourlyRate(hourlyRate);
				report.addReportLineHourly(anEmployee);
			}

			else if (type.equals("C")) {
				Employee.CommissionedEmployee anEmployee = new Employee.CommissionedEmployee();
				anEmployee.setEmployeeName(name);
				anEmployee.setEmployeeClass('C');
				System.out.println("Please enter sales of this employee in $");
				double sales = scanner.nextDouble();
				anEmployee.setSales(sales);
				report.addReportLineCommissioned(anEmployee);
			}
		}
		report.print(report);
	}
}