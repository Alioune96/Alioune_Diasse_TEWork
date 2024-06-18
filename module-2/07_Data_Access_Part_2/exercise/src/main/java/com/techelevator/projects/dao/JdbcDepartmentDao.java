package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {

	private final String DEPARTMENT_SELECT = "SELECT d.department_id, d.name FROM department d ";
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartmentById(int id)  {
		Department department = null;
		String sql = DEPARTMENT_SELECT +
				" WHERE d.department_id=?";
		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

			if (results.next()) {
				department = mapRowToDepartment(results);
			}
		}catch (CannotGetJdbcConnectionException e){
			throw new DaoException("hahah"+e);
		}catch (DataIntegrityViolationException e){
			throw new DaoException("hahah"+e);
		}
		return department;
	}

	@Override
	public List<Department> getDepartments() {
		List<Department> departments = new ArrayList<>();
		String sql = DEPARTMENT_SELECT;
		try {


			SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
			while (results.next()) {
				departments.add(mapRowToDepartment(results));
			}
		}catch (CannotGetJdbcConnectionException e){
			throw new DaoException("hahah" + e);
		}catch (DataIntegrityViolationException e){
			throw new DaoException("butHere" + e);
		}
		return departments;
	}

	@Override
	public Department createDepartment(Department department){
		Department hello = null;
		String createdOne = "INSERT INTO department (name) VALUES(?) RETURNING department_id;";
		try {
			int count = jdbcTemplate.queryForObject(createdOne,int.class,department.getName());
			hello = getDepartmentById(count);
		}catch (DaoException e){
			System.out.println(e);
		}
		catch (CannotGetJdbcConnectionException e){
			throw new DaoException("not right " +e);
		}catch (DataIntegrityViolationException e){
			throw new DaoException("also not right" + e);
		}


		return hello;
	}

	@Override
	public Department updateDepartment(Department department){
		Department updated = null;
		String updatedstatement = "UPDATE department SET name = ? WHERE department_id = ?";
		try {
			jdbcTemplate.update(updatedstatement,department.getName(),department.getId());
			updated=getDepartmentById(department.getId());


		}catch (DaoException e){
			System.out.println(e);
		}

		catch (CannotGetJdbcConnectionException e){
			throw new DaoException("not right " +e);
		}catch (DataIntegrityViolationException e){
			throw new DaoException("not again right lol "+ e);
		}


return updated;


	}

	@Override
	public int deleteDepartmentById(int id) throws DaoException {
		int count = 0;
		String catMe = "ALTER TABLE project_employee DROP CONSTRAINT fk_project_employee_employee;\n";
		String becausMe = "DELETE FROM employee WHERE department_id = ? ;";
		String thisISIT = "DELETE FROM department WHERE department_id = ?;";
		try {
			jdbcTemplate.update(catMe);
			jdbcTemplate.update(becausMe, id);
			count = jdbcTemplate.update(thisISIT,id);
			if(count==0){
				System.out.println("nothing Happened");
			}
		}catch (DaoException e){
			System.out.println(e);
		}
		catch (CannotGetJdbcConnectionException e){
			throw new DaoException("not Working"+e);
		}catch (DataIntegrityViolationException e){
			throw new DaoException("hahaha" + e);
		}






return count;	}

	private Department mapRowToDepartment(SqlRowSet results) {
		Department department = new Department();
		department.setId(results.getInt("department_id"));
		department.setName(results.getString("name"));
		return department;
	}

}
