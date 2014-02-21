package org.fanjun.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.fanjun.model.College;
import org.fanjun.model.Student;
import org.fanjun.service.CollegeService;
import org.fanjun.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private CollegeService collegeService;
	

	
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public CollegeService getCollegeService() {
		return collegeService;
	}
	public void setCollegeService(CollegeService collegeService) {
		this.collegeService = collegeService;
	}
	@RequestMapping("/index")
	public String setupForm(Map<String, Object> map){
		Student student = new Student();
		map.put("student", student);
		map.put("studentList", studentService.getAllStudent());
		return "student";
	}
	@RequestMapping(value="/student.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Student student, BindingResult result, @RequestParam String action, Map<String, Object> map){
		Student studentResult = new Student();
		switch(action.toLowerCase()){	
		case "add":
			System.out.println("Add");
			studentService.add(student);
			studentResult = student;
			break;
		case "edit":
			studentService.edit(student);
			studentResult = student;
			break;
		case "delete":
			studentService.delete(student.getStudentId());
			studentResult = new Student();
			break;
		case "search":
			Student searchedStudent = studentService.getStudent(student.getStudentId());
			studentResult = searchedStudent!=null ? searchedStudent : new Student();
			break;
		case "join":
			System.out.println("Join");
			break;
		}
		map.put("student", studentResult);
		map.put("studentList", studentService.getAllStudent());
		return "student";
	}
	@RequestMapping(value = "/join", method = RequestMethod.GET)
    public String getJoin(@RequestParam("id") Integer studentId,Map<String, Object> map) {
    	
    
		//Student student =new Student();
    	College college = new College();
    	//student.setStudentId(studentId);
    	
    	
    
    	//map.put("student", student);
		map.put("college", college);
		map.put("collegeList", collegeService.getAllCollege());
		
		System.out.println("Student ID= "+studentId);
    	
    	return "ListofCollege";
	}
	
	 @RequestMapping(value = "/add", method = RequestMethod.GET)
	    public String postAdd(@RequestParam("id") Integer studentId, 
	    		@RequestParam("c_id") Integer college_id) {
		 		
		
			// Delegate to service
			//College c=collegeService.getCollege(college_id);
		
		 	
			studentService.addStudenttoCollege(studentId, college_id);
			// System.out.println("Student ID= "+	studentService.getStudent(studentId).getfirstname() +" College ID  "+studentService.getStudent(studentId).getCollege().getCollegeName());

			// Redirect to url
			return "redirect:index";
		}
}
