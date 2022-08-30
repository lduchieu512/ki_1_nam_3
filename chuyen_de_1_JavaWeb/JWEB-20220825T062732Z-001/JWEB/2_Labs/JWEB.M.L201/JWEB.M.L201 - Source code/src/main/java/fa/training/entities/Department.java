package fa.training.entities;

public class Department {
    private int departmentId;
    private String departmentName;
    
    // Constructors and getters/setters

    public Department() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Department(int departmentId, String departmentName) {
        super();
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

}
