package me.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Test {
	
	public static void main(String[] args){
//		调用存储过程
		testGetUserCount();
	}
//	一对一的连表查询
	public static void testGetUserCount(){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		String statement = "me.mapping.classMapper.getUserCount";
		Map<String, Integer> para = new HashMap<String,Integer>();
		para.put("setId", 1);
		para.put("count", -1);
		sqlSession.selectOne(statement,para);
		int result2 = para.get("count");
		sqlSession.close();
		System.out.println("男生数目："+result2);
	}
}
