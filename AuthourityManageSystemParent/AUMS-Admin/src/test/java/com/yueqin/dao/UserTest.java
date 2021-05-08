package com.yueqin.dao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yueqin.admin.mapper.SysUserMapper;


@SpringBootTest
public class UserTest {
	
	@Autowired
	private SysUserMapper userMapper;
	
	/*
	 * @Test public void testConnection() throws SQLException {
	 * System.out.println(dataSource.getConnection()); }
	 */
	
	@Test
	public void test() {
		//System.out.println(userMapper);
		//System.out.println(userMapper.selectByPrimaryKey(1L));
		System.out.println(userMapper.selectByName("Tom"));
		
	}

}
