package com.koreait.mylegacy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.mylegacy.model.domain.Dept;
import com.koreait.mylegacy.model.domain.Emp;
import com.koreait.mylegacy.model.pool.PoolManager;

//Dept 테이블에 대한 CRUD 를 수행하되, jdbc기반으로 코드를 작성
@Repository
public class JdbcEmpDAO {
	@Autowired
	private PoolManager poolManager;
	
	public List selectAll() {
		List list = null;
		return list;
	}
	public Emp select(int empno) {
		Emp emp = null;
		return emp;
	}
	public int regist(Emp emp) {
		int result=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="insert into emp(empno, ename, sal, deptno) values(?,?,?,?)";
		
		con=poolManager.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setInt(3,emp.getSal());
			pstmt.setInt(4,emp.getDeptno());
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			poolManager.freeConnection(con, pstmt);
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





