package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentService {

	public String generateResult(StudentDTO studentDTO) {
		long total;
		double average;
		String result;

		total = studentDTO.getMathsMarks() + studentDTO.getPhysicsMarks() + studentDTO.getChemistryMarks();

		double roundOff = (total * 100) / (float) 300;
		average = Math.round(roundOff * 100.0) / 100.0;

		if (average > 50) {
			result = "PASS";
		} else {
			result = "FAIL";
		}

		StudentBO studentBO = new StudentBO();
		studentBO.setRollNumber(studentDTO.getRollNumber());
		studentBO.setName(studentDTO.getStudentName());
		studentBO.setTotal(total);
		studentBO.setAverage(average);
		studentBO.setResult(result);

		StudentDAO studentDAO = new StudentDAO();
		int status = studentDAO.save(studentBO);

		if (status > 0) {

			System.out.println("Registered Successfully");
		} else {
			System.out.println("Not Registered");
		}
		return total + average + result;
	}
}
