package com.example.demo;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/test")
	public class TestRestController extends JdbcDaoSupport {

		@GetMapping("/index")
		public String index() {
			return "Docker Test Successful";
		}
		
		@Autowired
		DataSource dataSource;

		@PostConstruct
		private void initialize() {
			setDataSource(dataSource);
		}
		
		@GetMapping(value = "/employees")
		public String getAllEmployees() {
			String sql = "SELECT * FROM employee";
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

			List<Employee> result = new ArrayList<Employee>();
			String msg=new String("");
			for (Map<String, Object> row : rows) {
				Employee emp = new Employee();
				emp.setEmpId(row.get("empId").toString());
				emp.setEmpName((String) row.get("empName"));
				msg=msg+ emp.getEmpId()+" "+ emp.getEmpName()+" ";
				result.add(emp);
				
			}
			
			
			return msg;
		}
		
		/*public List<Employee> getAllEmployees() {
			String sql = "SELECT * FROM employee";
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

			List<Employee> result = new ArrayList<Employee>();
			for (Map<String, Object> row : rows) {
				Employee emp = new Employee();
				emp.setEmpId(row.get("empId").toString());
				emp.setEmpName((String) row.get("empName"));
				result.add(emp);
			}
			
			
			return result;
		}*/

	}
