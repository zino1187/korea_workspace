package com.koreait.mylegacy.controller.emp;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.mylegacy.model.dao.JdbcDeptDAO;
import com.koreait.mylegacy.model.dao.JdbcEmpDAO;
import com.koreait.mylegacy.model.domain.Dept;
import com.koreait.mylegacy.model.domain.Emp;

//component-scan대상이 되려면 어노테이션을 지정해야 한다

@Controller
public class EmpController {
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	private JdbcDeptDAO jdbcDeptDAO;
	
	@Autowired
	private JdbcEmpDAO jdbcEmpDAO;
	
	//사원등록 폼요청
	@RequestMapping("/emp/registform")
	public String registForm() {
		//저장할 것이 없고, 그냥 뷰만 반환하고싶을때는 String도 가능 
		return "emp/regist_form";
	}
	
	//사원등록 요청을 처리하는 메서드
	@RequestMapping(value="/emp/regist", method=RequestMethod.POST)
	public String regist(Dept dept, Emp emp) {
		//파라미터 받아와 출력해보기!!
		System.out.println(dept.getDeptno());
		System.out.println(dept.getDname());
		System.out.println(dept.getLoc());
		
		System.out.println(emp.getEmpno());
		System.out.println(emp.getEname());
		System.out.println(emp.getSal());
		System.out.println(emp.getDeptno());
		
		//DB에 등록!!!
		//부서등록과 사원등록이라는 두개의 업무가 모두 성공되어야, 전체를 성공으로 간주하는 트랜잭션 상황!!!
		int result = jdbcDeptDAO.regist(dept);
		System.out.println("result : "+result);
		
		int result2 = jdbcEmpDAO.regist(emp);
		System.out.println("result2 : "+result2);
		
		return null;
	}
}




