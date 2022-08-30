package fa.training.entities;

import java.util.Date;

public class Employee {
    private int employeeId;
    private String employeeName;
    private byte gender;
    private Date dateOfBirth;
    private int departmentId;

    public Employee(int employeeId, String employeeName, byte gender, Date dateOfBirth, int departmentId) {
        super();
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.departmentId = departmentId;
    }

    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public Employee(String employeeName, byte gender, Date dateOfBirth, int departmentId) {
        super();
        this.employeeName = employeeName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.departmentId = departmentId;
    }

}
