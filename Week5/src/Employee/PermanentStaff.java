package Employee;

import Enumeration.*;
import randomize.Randomize;

public class PermanentStaff extends Academic {
    Bathmida rank;
    int monthlySalary;

    public PermanentStaff(int id) {
        super(id);
        rank= Randomize.Bathmida();
    }

    @Override
    public int CalculateMonthlySalary() {
        switch (rank) {
            case Lecturer:
                return baseMonthlysalary + 1000;
            case Assistant:
                return baseMonthlysalary + 1200;
            case Associate:
                return baseMonthlysalary + 1400;
            case Professor:
                return baseMonthlysalary + 1500;
            default:
                return baseMonthlysalary;
        }
    }

    public void printInfo(){
        System.out.println("AcademicID:"+super.getEmployeeID());
        System.out.println("Rank:"+rank);
        System.out.println("Monthly Salary:"+this.CalculateMonthlySalary());

    }

}
