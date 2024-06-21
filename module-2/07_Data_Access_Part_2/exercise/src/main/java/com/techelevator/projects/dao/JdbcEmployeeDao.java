package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Employee;
import org.w3c.dom.DOMException;

public class JdbcEmployeeDao implements EmployeeDao {

	private final String EMPLOYEE_SELECT = "SELECT e.employee_id, e.department_id, e.first_name, e.last_name, " +
				"e.birth_date, e.hire_date FROM employee e ";

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = null;
		String sql = EMPLOYEE_SELECT +
				" WHERE e.employee_id=?";
		try {


			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
			if (results.next()) {
				employee = mapRowToEmployee(results);
			}
		}catch (CannotGetJdbcConnectionException e){
			throw new DaoException("funny guy"+e);
		}catch (DataIntegrityViolationException e){
			throw new DaoException("fyyy"+e);
		}
		return employee;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> allEmployees = new ArrayList<>();
		String sql = EMPLOYEE_SELECT;
		try {


			SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
			while (results.next()) {
				Employee employeeResult = mapRowToEmployee(results);
				allEmployees.add(employeeResult);
			}
		}catch (CannotGetJdbcConnectionException e){
			throw new DaoException("das"+e);
		}catch (DataIntegrityViolationException e){
			throw new DaoException("sdas"+e);
		}
		return allEmployees;
	}

	@Override
	public List<Employee> getEmployeesByFirstNameLastName(String firstName, String lastName) {
		List<Employee> allEmployees = new ArrayList<>();
		String sql = EMPLOYEE_SELECT +
				" WHERE e.first_name ILIKE ? AND e.last_name ILIKE ?";
		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + firstName + "%", "%" + lastName + "%");
			while (results.next()) {
				Employee employeeResult = mapRowToEmployee(results);
				allEmployees.add(employeeResult);
			}
		}catch (CannotGetJdbcConnectionException e){
			throw new DaoException("Hello"+e);
		}catch (DataIntegrityViolationException e){
			throw new DaoException("kitkat"+e);
		}

		return allEmployees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(int projectId) {
		List<Employee> allEmployees = new ArrayList<>();
		String sql =  EMPLOYEE_SELECT +
				"JOIN project_employee pe ON e.employee_id = pe.employee_id " +
				"WHERE pe.project_id = ?";
		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
			while (results.next()) {
				Employee employeeResult = mapRowToEmployee(results);
				allEmployees.add(employeeResult);
			}
		}catch (CannotGetJdbcConnectionException e){
			throw new DaoException("Hello Darkeness" + e);
		}catch (DataIntegrityViolationException e){
			throw new DaoException("man"+ e);
		}
		return allEmployees;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> allEmployees = new ArrayList<>();
		String sql = EMPLOYEE_SELECT +
				" WHERE e.employee_id NOT IN (SELECT DISTINCT employee_id FROM project_employee)";
		try {

			SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
			while (results.next()) {
				Employee employeeResult = mapRowToEmployee(results);
				allEmployees.add(employeeResult);
			}
		}catch(CannotGetJdbcConnectionException e){
			throw new DaoException("My guy"+e);
		}catch (DataIntegrityViolationException e){
			throw new DaoException("MY king"+e);
		}
		return allEmployees;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		Employee meeeTo = null;
		String sqlStuffMan = "INSERT INTO employee (department_id,first_name,last_name,birth_date,hire_date)\n" +
				"VALUES (?,?,?,?,?) RETURNING employee_id;";
		try{
			int ThisFunny = jdbcTemplate.queryForObject(sqlStuffMan, int.class,employee.getDepartmentId(),employee.getFirstName(),employee.getLastName(),employee.getBirthDate(),employee.getHireDate());
			meeeTo = getEmployeeById(ThisFunny);


		}catch (CannotGetJdbcConnectionException e){
			throw new DaoException("mee"+e);
		}catch (DataIntegrityViolationException e){
			throw new DaoException("kid"+e);
		}

		return meeeTo;

	}
	
	@Override
	public Employee updateEmployee(Employee employee) {
		Employee listNOw = null;
		String mmaaaTheKIdareHere = "UPDATE employee SET department_id = ?, first_name = ?, last_name = ?, birth_date = ?, hire_date = ? WHERE employee_id = ?;";
		try {

		jdbcTemplate.update(mmaaaTheKIdareHere,employee.getDepartmentId(),employee.getFirstName(),employee.getLastName(),employee.getBirthDate(),employee.getHireDate(),employee.getId());
			listNOw = getEmployeeById(employee.getId());

		}

		catch (CannotGetJdbcConnectionException e){
			throw new DaoException("hahah", e);
		}catch (DataIntegrityViolationException e){
			throw new DaoException("up", e);
		}

		return listNOw;

	}

	@Override
	public int deleteEmployeeById(int id) {
		int countMe = 0;
		String sqlMan = "ALTER TABLE project_employee DROP CONSTRAINT pk_project_employee;\n";
		String  realOne ="DELETE FROM employee WHERE employee_id = ?;";
		try{
			jdbcTemplate.update(sqlMan);
			int howMany = jdbcTemplate.update(realOne,id);
			countMe=howMany;
		}catch (CannotGetJdbcConnectionException e){
			throw new DaoException("sdas"+e);

		}catch (DataIntegrityViolationException e){

			throw new DaoException("Alioune"+e);
		}
	return countMe;
	}

	@Override
	public int deleteEmployeesByDepartmentId(int departmentId) {
		int myLifeBelike = 0;
		String youNow = "DELETE FROM employee WHERE department_id = ?;";
		String updatedCase = "DELETE FROM project_employee WHERE employee_id = ?;";
		try{
			jdbcTemplate.update("ALTER TABLE project_employee DROP CONSTRAINT fk_project_employee_employee;");
			jdbcTemplate.update(updatedCase,departmentId);
			int keepCount = jdbcTemplate.update(youNow,departmentId);
			myLifeBelike=keepCount;

		}catch (CannotGetJdbcConnectionException e){
			throw new DaoException("jaja" + e);
		}catch (DataIntegrityViolationException e){
			throw new DaoException("naruto" + e);
		}

return myLifeBelike;	}

	private Employee mapRowToEmployee(SqlRowSet result) {
		Employee employee = new Employee();
		employee.setId(result.getInt("employee_id"));
		employee.setDepartmentId(result.getInt("department_id"));
		employee.setFirstName(result.getString("first_name"));
		employee.setLastName(result.getString("last_name"));
		employee.setBirthDate(result.getDate("birth_date").toLocalDate());
		employee.setHireDate(result.getDate("hire_date").toLocalDate());
		return employee;
	}
}
