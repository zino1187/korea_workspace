package com.koreait.mylegacy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.koreait.mylegacy.model.domain.Emp;

//Dept 테이블에 대한 CRUD 를 수행하되, jdbc기반으로 코드를 작성
@Repository
public class JdbcEmpDAO {
	private Connection con;
	public void setCon(Connection con) {
		this.con = con;
	}
	
	public List selectAll() {
		List list = null;
		return list;
	}
	public Emp select(int empno) {
		Emp emp = null;
		return emp;
	}
	public int regist(Emp emp) throws SQLException{
		int result=0;
		PreparedStatement pstmt=null;
		String sql="insert into emp(empno, ename, sal, deptno) values(?,?,?,?)";
	
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setInt(3,emp.getSal());
			pstmt.setInt(4,emp.getDept().getDeptno());
			
			result=pstmt.executeUpdate();
			
		} finally{
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	public int update(Emp emp) {
		int result=0;
		return result;
	}
	public int delete(int empno) {
		int result=0;
		return result;
	}
	
}





