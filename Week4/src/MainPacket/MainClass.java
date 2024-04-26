package MainPacket;

import Employee.*;
import Enumeration.*;
import randomize.*;

public class MainClass {
    public static void main(String[] args) {
        createRandomizedEmployees(100);
    }

    public static void createRandomizedEmployees(int k) {
        for (int i = 1; i < k; i++) {
            StaffType staff = Randomize.Staff();
            if (staff == StaffType.Permanent) {
                PermanentStaff pstaff = new PermanentStaff(i);
                pstaff.CalculateMonthlySalary();
                pstaff.printInfo();
                System.out.println("");
            }
            if (staff == StaffType.HourlyBased) {
                HourlyStaff hstaff = new HourlyStaff(i);
                hstaff.CalculateMonthlySalary();
                hstaff.printInfo();
                System.out.println("");
            }
        }
    }


}
