package com.yu.dao;

import com.yu.pojo.Department;
import com.yu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工Dao
@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null; //创建一个员工表
    //员工所属部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<>();
        employees.put(1001, new Employee(1001, "小明", "A123@qq.com", 0, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "小李", "B123@qq.com", 1, new Department(102, "运营部")));
        employees.put(1003, new Employee(1003, "小王", "C123@qq.com", 0, new Department(103, "市场部")));
        employees.put(1004, new Employee(1004, "小华", "D123@qq.com", 1, new Department(104, "营销部")));
        employees.put(1005, new Employee(1005, "小王", "E123@qq.com", 0, new Department(105, "后勤部")));
    }

    //主键自增
    private static Integer initId= 1006;

    //增加员工
    public void addEmployee(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    //查询全部员工信息
    public Collection<Employee> getEmployee(){
        return employees.values();
    }

    //通过ID查询员工信息
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //根据ID删除员工信息
    public void removeEmployee(Integer id){
        employees.remove(id);
    }

}
