package MainPacket;

import Employee.*;
import Enumeration.*;
import randomize.*;

public class MainClass {
    public static void main(String[] args) {
        createRandomizedEmployees(100000);
        int searchemployeeID = 50000;
        System.out.println("\n\nSearch with linked list for Employee with id:" + searchemployeeID);
        Employee x = Employee.search_with_linkedList(searchemployeeID);
        x.printInfo();
        System.out.println("\nSearch with Hash Map for Employee with id:" + searchemployeeID);
        x = Employee.search_with_HashMap(searchemployeeID);
        x.printInfo();
    }

    public static void createRandomizedEmployees(int k) {
        for (int i = 1; i < k; i++) {
            StaffType staff = Randomize.Staff();
            if (staff == StaffType.Permanent) {
                PermanentStaff pstaff = new PermanentStaff(i);
                pstaff.CalculateMonthlySalary();
                pstaff.printInfo();
                Employee.addEmployeeNode((Employee) pstaff);
                System.out.println("");
            }
            if (staff == StaffType.HourlyBased) {
                HourlyStaff hstaff = new HourlyStaff(i);
                hstaff.CalculateMonthlySalary();
                Employee.addEmployeeNode((Employee) hstaff);
                hstaff.printInfo();
                System.out.println("");
            }
        }
    }


}
