package edu.kh.objarray.practice.model.vo;

public class Employee {

	private int empNo;
	private String name;
	private String dept;
	private String jobTitle;
	private int salary;

	public Employee() {	}

	public Employee(int empNo, String name, String dept, String jobTitle, int salary) {
		this.empNo = empNo;
		this.name = name;
		this.dept = dept;
		this.jobTitle = jobTitle;
		this.salary = salary;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "사번 : " + empNo + ", 이름 : " + name + ", 부서 : " + dept + 
				", 직급 : " + jobTitle + " , 급여 : " + salary;
	}


}

