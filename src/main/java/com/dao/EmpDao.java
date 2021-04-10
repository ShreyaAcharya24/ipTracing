package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;

import com.bean.EmpBean;
import com.util.DBConnection;

public class EmpDao {

	
	public boolean addEmployee(EmpBean eb) {

		boolean flag = false;
		Connection conn = DBConnection.getDBConnection();

		if (conn != null) {

			try {
				PreparedStatement pstmt = conn.prepareStatement("insert into emp(ename) values (?)");
				pstmt.setString(1, eb.geteName());
				int res = pstmt.executeUpdate();
				if (res > 0) {

					flag = true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return flag;

	}

	public List<EmpBean> getAllStudents() {

		Connection conn = DBConnection.getDBConnection();
		List<EmpBean> employees = new ArrayList<>();
		if (conn != null) {

			try {
				PreparedStatement pstmt = conn.prepareStatement("select * from emp");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {

					EmpBean eb = new EmpBean();
					eb.seteId(rs.getInt(1));
					eb.seteName(rs.getString(2));
					employees.add(eb);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return employees;
	}
}
