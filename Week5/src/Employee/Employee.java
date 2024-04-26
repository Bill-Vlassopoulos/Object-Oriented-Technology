package Employee;

import java.util.HashMap;
import java.util.LinkedList;

abstract public class Employee {
    static LinkedList<Employee> linkedlist = new LinkedList<Employee>();
    static HashMap<Integer, Employee> hashmaplist = new HashMap<Integer, Employee>();


    abstract public int getEmployeeID();

    abstract public void printInfo();

    public static void addEmployeeNode(Employee x) {
        linkedlist.add(x);
        hashmaplist.put(x.getEmployeeID(), x);
    }

    public static Employee search_with_HashMap(int id) {
        long start_time, estimated_time;
        start_time = System.currentTimeMillis();
        Employee x = hashmaplist.get(id);
        estimated_time = System.currentTimeMillis() - start_time;
        System.out.println("The estimated time for the hash map is:" + estimated_time+"ms");
        return x;
    }

    public static Employee search_with_linkedList(int id) {
        long start_time, estimated_time;
        start_time = System.currentTimeMillis();
        for (Employee emp : linkedlist) {
            if (emp.getEmployeeID() == id) {
                estimated_time = System.currentTimeMillis() - start_time;
                System.out.println("The estimated time for the linked list is:" + estimated_time+"ms");
                return emp;

            }
        }
        return null;
    }
}
