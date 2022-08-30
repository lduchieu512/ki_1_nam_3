package fa.training.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fa.training.entities.Employee;
import fa.training.utils.DBUtil;
import fa.training.utils.DateUtils;

public class EmployeeDao {
    public boolean addEmployee(Employee employee) throws ClassNotFoundException, IOException, SQLException {
        Connection connection = DBUtil.getConnection();
        CallableStatement callableStatement = connection.prepareCall("{call usp_addEmployee(?,?,?,?)}");
        int param = 0;
        callableStatement.setString(++param, employee.getEmployeeName());
        callableStatement.setByte(++param, employee.getGender());
        callableStatement.setDate(++param, DateUtils.convertJavaDateToSqlDate(employee.getDateOfBirth()));
        callableStatement.setInt(++param, employee.getDepartmentId());
        int result = callableStatement.executeUpdate();
        DBUtil.closeConnection(connection);
        if (result > 0) {
            return true;
        }
        return false;
    }

    public List<Employee> findAllEmployee() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = DBUtil.getConnection();
        CallableStatement callableStatement = connection.prepareCall("{call usp_findAllEmployee}");
        ResultSet resultSet = callableStatement.executeQuery();
        List<Employee> listOfEmployee = new ArrayList<>();
        while (resultSet.next()) {
            int empId = resultSet.getInt(1);
            String empName = resultSet.getString(2);
            byte gender = resultSet.getByte(3);
            Date birthDate = resultSet.getDate(4);
            int deptId = resultSet.getInt(5);

            Employee employee = new Employee(empId, empName, gender, birthDate, deptId);
            listOfEmployee.add(employee);
        }
        DBUtil.closeConnection(connection);
        return listOfEmployee;
    }
}
