package com.nt.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class StudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {

			int rollNumber = Integer.parseInt(request.getParameter("roll_number"));
			String studentName = request.getParameter("name");
			int mathsMarks = Integer.parseInt(request.getParameter("maths_marks"));
			int physicsMarks = Integer.parseInt(request.getParameter("physics_marks"));
			int chemistryMarks = Integer.parseInt(request.getParameter("chemistry_marks"));

			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setRollNumber(rollNumber);
			studentDTO.setStudentName(studentName);
			studentDTO.setMathsMarks(mathsMarks);
			studentDTO.setPhysicsMarks(physicsMarks);
			studentDTO.setChemistryMarks(chemistryMarks);

			StudentService studentService = new StudentService();
			studentService.generateResult(studentDTO);

		} catch (Exception e) {
			out.println("ERORR");
		}
	}

}
