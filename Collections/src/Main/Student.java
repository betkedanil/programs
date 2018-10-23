package Main;

public class Student extends Human {
    private String departmentName;

    public Student(String firstName, String lastName, String middleName, int age, String departmentName) {
        super(firstName, lastName, middleName, age);
        setDepartmentName(departmentName);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
