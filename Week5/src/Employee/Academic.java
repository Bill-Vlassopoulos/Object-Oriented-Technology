package Employee;

public class Academic extends Employee{
    final static int baseMonthlysalary=500;
    int id;
    Academic(int id){
        this.id=id;
    }
    public int CalculateMonthlySalary(){
        return Academic.baseMonthlysalary;

    }
    public int getEmployeeID(){
        return this.id;
    }

    @Override
    public void printInfo() {

    }
}
