package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.PersonVo;

@WebServlet("/pbc")
public class PhoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("controller");

		String action = request.getParameter("action");

		// 리스트일 때
		if ("list".equals(action)) {
			System.out.println("list");

			PhoneDao dao = new PhoneDao();
			List<PersonVo> pList = dao.getPersonList();

			// 데이터 리퀘스트에 추가
			request.setAttribute("personList", pList);

			// forword
			WebUtil.forword(request, response, "/WEB-INF/list.jsp");

			/*
			 * RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
			 * rd.forward(request, response);
			 */
		}

		// 등록일 때
		else if ("wform".equals(action)) {
			System.out.println("wform");

			// forword
			WebUtil.forword(request, response, "/WEB-INF/writeForm.jsp");

			/*
			 * RequestDispatcher rd =
			 * request.getRequestDispatcher("/WEB-INF/writeForm.jsp"); rd.forward(request,
			 * response);
			 */
		}

		// 번호 저장
		else if ("insert".equals(action)) {
			System.out.println("insert");

			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");

			PersonVo vo = new PersonVo(name, hp, company);

			PhoneDao dao = new PhoneDao();
			dao.personInsert(vo);

			// 리다이렉트
			WebUtil.redirect(request, response, "/pb02/pbc?action=list");

			// response.sendRedirect("/pb02/pbc?action=list");
		}

		// 수정 버튼 눌렀을 때
		else if ("updateForm".equals(action)) {
			System.out.println("updateForm");
			
			WebUtil.forword(request, response, "/WEB-INF/updateForm.jsp");
		}

		// 번호 수정
		else if ("update".equals(action)) {
			System.out.println("update");
			
			int personID = Integer.parseInt(request.getParameter("pID"));
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");

			PhoneDao dao = new PhoneDao();
			PersonVo vo = new PersonVo(personID, name, hp, company);
			dao.personUpdate(vo);
			
			// 리다이렉트
			WebUtil.redirect(request, response, "/pb02/pbc?action=list");
		}
		
		// 번호 삭제
		else if ("delete".equals(action)) {
			System.out.println("delete");

			int personId = Integer.parseInt(request.getParameter("pID"));
			System.out.println(personId);

			PhoneDao phoneDao = new PhoneDao();
			phoneDao.personDelete(personId);

			// 리다이렉트
			WebUtil.redirect(request, response, "/pb02/pbc?action=list");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
