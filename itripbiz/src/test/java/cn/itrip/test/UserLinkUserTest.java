//package cn.itrip.test;
//
//import java.util.Date;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import cn.itrip.service.client.IClientUserLinkUserService;
//
//public class UserLinkUserTest {
//
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@Test
//	public void testQueryItripUserLinkUserListByUserId(){
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
//		IClientUserLinkUserService clientUserLinkUserServiceImpl =
//				(IClientUserLinkUserService)context.getBean("clientUserLinkUserServiceImpl");
//		List<ItripUserLinkUser> userLinkUserList;
//		try {
//			userLinkUserList = clientUserLinkUserServiceImpl.queryItripUserLinkUserListByUserId(11l);
//			for(ItripUserLinkUser userLinkUser : userLinkUserList){
//				System.out.println("linkUserName:" + userLinkUser.getLinkUserName());
//				System.out.println("linkIdCard:" + userLinkUser.getLinkIdCard());
//				System.out.println("linkPhone:" + userLinkUser.getLinkPhone());
//				System.out.println("userId:" + userLinkUser.getUserId());
//				System.out.println("creationDate:" + userLinkUser.getCreationDate());
//				System.out.println("createdBy:" + userLinkUser.getCreatedBy());
//				System.out.println("modifyDate:" + userLinkUser.getModifyDate());
//				System.out.println("modifiedBy:" + userLinkUser.getModifiedBy());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testDelUserLinkUser(){
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
//		IClientUserLinkUserService clientUserLinkUserServiceImpl =
//				(IClientUserLinkUserService)context.getBean("clientUserLinkUserServiceImpl");
//		ItripUserLinkUser userLinkUser = new ItripUserLinkUser();
//		try {
//			int i = clientUserLinkUserServiceImpl.delUserLinkUser(1l);
//			System.out.println("成功删除记录数："+i);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testAddUserLinkUser(){
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
//		IClientUserLinkUserService clientUserLinkUserServiceImpl =
//				(IClientUserLinkUserService)context.getBean("clientUserLinkUserServiceImpl");
//		ItripUserLinkUser userLinkUser = new ItripUserLinkUser();
//		userLinkUser.setLinkUserName("hai.dong");
//		userLinkUser.setLinkIdCard("110");
//		userLinkUser.setLinkPhone("1");
//		userLinkUser.setUserId(1);
//		userLinkUser.setCreationDate(new Date());
//		userLinkUser.setCreatedBy(1l);
//		userLinkUser.setModifyDate(new Date());
//		userLinkUser.setModifiedBy(1l);
//		try {
//			int i = clientUserLinkUserServiceImpl.addUserLinkUser(userLinkUser);
//			System.out.println("成功添加记录数："+i);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
