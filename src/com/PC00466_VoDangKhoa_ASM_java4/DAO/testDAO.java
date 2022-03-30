package com.PC00466_VoDangKhoa_ASM_java4.DAO;

import com.PC00466_VoDangKhoa_ASM_java4.entity.Users;

public class testDAO {
public static void main(String[] args) {
	UserDAO dao = new UserDAO();
//	Users user1 = new Users();
//	user1.setId("test2");
//	user1.setPassword("123");
//	user1.setEmail("testDAo@gmail.com");
//	user1.setFullname("testDAOname");
//	user1.setRole(false);
//	dao.create(user1);
//	dao.remove("test2");
	dao.findById("test2");
}
}
