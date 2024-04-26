package Employee;

import Enumeration.*;
import randomize.Randomize;


public class HourlyStaff extends Academic {
    WorkingExperience experience;
    int workedhours;
    int monthlySalary;

    public HourlyStaff(int id) {
        super(id);
        experience= Randomize.WorkingExperience();
        workedhours=Randomize.MonthlyWorkingHours();
    }

    @Override
    public int CalculateMonthlySalary() {
        switch (experience) {
            case uptoFiveYears:
                return baseMonthlysalary + workedhours * 10;
            case FiveToTenYears:
                return baseMonthlysalary + workedhours * 20;
            case morethanTenYears:
                return baseMonthlysalary + workedhours * 30;
            default:
                return baseMonthlysalary;
        }
    }

    public void printInfo() {
        System.out.println("AcademicID:" + super.getEmployeeID());
        System.out.println("Experience:" + experience);
        System.out.println("Monthly Salary:" + this.CalculateMonthlySalary());
    }
}
