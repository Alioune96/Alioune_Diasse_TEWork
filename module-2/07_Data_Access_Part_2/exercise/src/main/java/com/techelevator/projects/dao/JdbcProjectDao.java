package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final String PROJECT_SELECT = "SELECT p.project_id, p.name, p.from_date, p.to_date FROM project p";

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProjectById(int projectId) {
		Project project = null;
		String sql = PROJECT_SELECT +
				" WHERE p.project_id=?";
try {
	SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
	if (results.next()) {
		project = mapRowToProject(results);
	}
}catch (CannotGetJdbcConnectionException e){
	throw new DaoException("sadas"+e);
}catch (DataIntegrityViolationException e){
	throw new DaoException("kid"+e);
}
		return project;
	}

	@Override
	public List<Project> getProjects() {
		List<Project> allProjects = new ArrayList<>();
		String sql = PROJECT_SELECT;
		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
			while (results.next()) {
				Project projectResult = mapRowToProject(results);
				allProjects.add(projectResult);
			}
		}catch (CannotGetJdbcConnectionException e){
			throw new DaoException("listenHere" + e);
		}catch (DataIntegrityViolationException e){
			throw new DaoException("myType"+e);
		}
		return allProjects;
	}

	@Override
	public Project createProject(Project newProject) {
		Project gg = null;
		String stateKid = "INSERT INTO project (name, from_date, to_date) VALUES(?, ?, ?) RETURNING project_id;\n";
		try {
			int count = jdbcTemplate.queryForObject(stateKid,int.class,newProject.getName(),newProject.getFromDate(),newProject.getToDate());
			gg = getProjectById(count);
		}catch (CannotGetJdbcConnectionException e){
			throw new DaoException("hello"+e);
		}catch (DataIntegrityViolationException e){
			throw new DaoException("my old"+ e);
		}


return gg;
	}
	
	@Override
	public void linkProjectEmployee(int projectId, int employeeId) {
		String commandMlol = "INSERT INTO project_employee (employee_id, project_id) VALUES (?,?)\n";
		try{
			jdbcTemplate.update(commandMlol,employeeId,projectId);
		}catch (CannotGetJdbcConnectionException e){
			throw new DaoException("frieendd!!");
		}catch (DataIntegrityViolationException e){
			throw new DaoException("Here we are again");
		}
	}

	@Override
	public void unlinkProjectEmployee(int projectId, int employeeId) {
		String myWay = "ALTER TABLE project_employee DROP CONSTRAINT fk_project_employee_employee;\n" +
				"DELETE FROM project_employee WHERE employee_id = ?;\n";
		try{
			jdbcTemplate.update(myWay,employeeId);
		}catch (CannotGetJdbcConnectionException e){
			throw new DaoException("kitaa" + e);
		}catch (DataIntegrityViolationException e){
			throw new DaoException("hello" + e);
		}
	}

	@Override
	public Project updateProject(Project project) {
		Project justForCase = null;
		String thisIsjusttsmh = "UPDATE project SET name = ?, from_date = ?, to_date = ? WHERE project_id = ?;\n";
		try{
			jdbcTemplate.update(thisIsjusttsmh,project.getName(),project.getFromDate(),project.getToDate(),project.getId());
			justForCase = getProjectById(project.getId());

		}catch (CannotGetJdbcConnectionException e){
			throw new DaoException("kka"+e);
		}catch (DataIntegrityViolationException e){
			throw new DaoException("oka"+e);
		}

		return justForCase;
	}
	@Override
	public int deleteProjectById(int projectId) {
	int countAmount = 0;
	String yoMyGirl = "ALTER TABLE project_employee DROP CONSTRAINT fk_project_employee_employee;";

	String smileAlot = "DELETE FROM project_employee WHERE project_id = ?";
	String realyyc = "DELETE FROM project WHERE project_id = ?;";

	try {
		jdbcTemplate.update(yoMyGirl);
		jdbcTemplate.update(smileAlot,projectId);
		countAmount = jdbcTemplate.update(realyyc,projectId);


	}catch (CannotGetJdbcConnectionException e){
		throw new DaoException("notAgain"+ e);
	}catch (DataIntegrityViolationException e){
		throw new DaoException("myKid"+e);
	}



return countAmount;	}
	
	private Project mapRowToProject(SqlRowSet results) {
		Project project = new Project();
		project.setId(results.getInt("project_id"));
		project.setName(results.getString("name"));
		if (results.getDate("from_date") != null) {
			project.setFromDate(results.getDate("from_date").toLocalDate());
		}
		if (results.getDate("to_date") != null) {
			project.setToDate(results.getDate("to_date").toLocalDate());
		}
		return project;
	}

}
