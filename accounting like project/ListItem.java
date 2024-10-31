import java.text.NumberFormat;

public class ListItem {
	
    public static double computeSalaryForSalariedEmployee(Employee.SalariedEmployee employee){
        double weeklySalary = (employee.getMonthlyRate()/30) *7;    //Suppose that every month equals to 30 days
        if (employee.getBonus()){
            weeklySalary = weeklySalary*1.1;
        }
        return weeklySalary;
    }
    public static double computeSalaryForHourlyEmployee(Employee.HourlyEmployee employee){
        double weeklySalary;
        if (employee.getHoursWeek() <= 40){
            weeklySalary = employee.getHourlyRate()*employee.getHoursWeek();
        } else {
            weeklySalary = (40 * employee.getHourlyRate() + (employee.getHoursWeek() - 40) * 2 * employee.getHourlyRate());
        }
        return weeklySalary;
    }
    public static double computeSalaryForCommissionedEmployee(Employee.CommissionedEmployee employee){
        double weeklySalary = employee.getSales()*0.2;
        return weeklySalary;
    }
    public static String formatSalaried(Employee.SalariedEmployee employee, double weeklySalary){
        String listItem = String.format("%-15s%-40s%s%-4.2f", employee.getEmployeeName(),"Salaried", "$", weeklySalary);
        if (employee.getBonus()){
            listItem = listItem + "*";
        }
        return listItem;
    }

    public static String formatHourly(Employee.HourlyEmployee employee, double weeklySalary){
    	String listItem = String.format("%-15s%-11s%-19d%s%-9.2f%s%-4.2f", employee.getEmployeeName(), "Hourly", employee.getHoursWeek(),"$", employee.getHourlyRate(), "$", weeklySalary);
        return listItem;
    }
    public static String formatCommissioned(Employee.CommissionedEmployee employee, double weeklySalary){
    	String listItem = String.format("%-15s%-21s%s%-18.2f%s%-4.2f", employee.getEmployeeName(), "Commissioned", "$", employee.getSales(), "$" , weeklySalary);
        return listItem;
    }

}