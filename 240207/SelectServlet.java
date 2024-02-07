package com.emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.model.EmpDAO;
import com.emp.model.EmpDTO;


@WebServlet("/select.do")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SelectServlet() {
        super();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// DB에 접속해서 EMP 테이블의 전체 사원 목록을 조회 후 가져와서 view page로 이동시키는 비지니스 로직.(CRUD라는 로직)
		
		// DB와 드라이버 로딩 및 데이터베이스 접속 진행.
		// 싱글턴 방식으로 EmpDAO 객체 생성.
		EmpDAO dao = EmpDAO.getInstance();
		
		// 확인해보자.
		System.out.println("list dao >>> " + dao);
		
		// Emp 테이블에서 전체 사원 리스트를 조회하는 메서드 호출 
		//dao-> dto를 거치는 이유는 조회된 데이터를 객체화 한사람 한 사람을 다 객체화 시켜서 관리


		List<EmpDTO> empList = dao.allList();
		
		//조회된 데이터(empList)를 List라는 이름으로 jsp로 보낼 예정이다.
		request.setAttribute("List", empList);
		
		RequestDispatcher rd = request.getRequestDispatcher("view/emp_list.jsp");
		
		//실제로 이동
		rd.forward(request, response);
		
	
		
		
		
	
	
	
	}

}