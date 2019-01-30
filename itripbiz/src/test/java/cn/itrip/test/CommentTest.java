package cn.itrip.test;

//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//import cn.itrip.beans.pojo.ItripComment;
//import cn.itrip.beans.pojo.ItripImage;
//import cn.itrip.service.itripComment.ItripCommentService;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommentTest {

//    @Test
//    public void test() {
//        System.out.println("Not yet implemented");
//    }

//    @Test
//    public void testAddItripComment() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
//        ItripCommentService itripCommentServiceImpl =
//                (ItripCommentService) context.getBean("itripCommentServiceImpl");
//        ItripComment comment = new ItripComment();
//        List<ItripImage> imageList = new ArrayList<ItripImage>();
//        ItripImage image = new ItripImage();
//        Date d = new Date();
//        String date = "2016-01-01";
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            d = df.parse(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        image.setType("0");
//        image.setImgUrl("");
//        image.setCreationDate(d);
//        imageList.add(image);
//        comment.setHotelId(1L);
//        comment.setProductId(1L);
//        comment.setProductType(1);
//        comment.setUserId(1L);
//        comment.setIsHavingImg(1);
//        comment.setHygieneScore(3);
//        comment.setFacilitiesScore(3);
//        comment.setPositionScore(3);
//        comment.setServiceScore(3);
//        comment.setTripMode("1");
//        comment.setIsOk(1);
//        comment.setCreationDate(new Date());
//        comment.setCreatedBy(1l);
//        comment.setModifyDate(new Date());
//        comment.setModifiedBy(1l);
//        comment.setContent("1231231");
//
//        try {
//            Boolean flag = itripCommentServiceImpl.itriptxAddItripComment(comment, imageList);
//            System.out.println("添加点评的数量为：" + flag);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    @Test
//    public void testQueryItripCommentList() {
//
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
//        IClientCommentService clientCommentServiceImpl =
//                (IClientCommentService) context.getBean("clientCommentServiceImpl");
//        Page<ITripCommentVo> commentList = new Page<ITripCommentVo>();
//        Map<String, Object> param = new HashMap<String, Object>();
//
//        try {
//            commentList = clientCommentServiceImpl.queryItripCommentList(param);
//            int i = 0;
////			for(ITripCommentVo itripCommentVo : commentList){
////				System.out.println("=================== "+i+" ===========");
////				System.out.println(itripCommentVo.getHotelName());
////				System.out.println(itripCommentVo.getId());
////				System.out.println(itripCommentVo.getCreationDate());
////				i++;
////			}
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testGetAvgAndTotalScore() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
//        IClientCommentService clientCommentServiceImpl =
//                (IClientCommentService) context.getBean("clientCommentServiceImpl");
//        ItripComment comment = new ItripComment();
//        comment.setHotelId(1L);
//        ITripCommentScoreVo commentScoreVo = new ITripCommentScoreVo();
//        try {
//            commentScoreVo = clientCommentServiceImpl.getAvgAndTotalScore(1);
//            System.out.println("位置得分：" + commentScoreVo.getAvgPositionScore());
//            System.out.println("设施得分：" + commentScoreVo.getAvgFacilitiesScore());
//            System.out.println("服务得分：" + commentScoreVo.getAvgServiceScore());
//            System.out.println("卫生得分：" + commentScoreVo.getAvgHygieneScore());
//            System.out.println("综合得分：" + commentScoreVo.getAvgScore());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//	@Test
//	public void testGetItripCommentCountByMap() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
//        ItripCommentService itripCommentServiceImpl =
//                (ItripCommentService) context.getBean("itripCommentServiceImpl");
//        Map<String, Object> param = new HashMap<String, Object>();
//        param.put("hotelId", 1);
//        try {
//            Integer i = itripCommentServiceImpl.getItripCommentCountByMap(param);
//            System.out.println("查询出来的数目：" + i);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    @Test
//	public void testItriptxAddItripComment() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
//        ItripCommentService itripCommentServiceImpl =
//                (ItripCommentService) context.getBean("itripCommentServiceImpl");
//        ItripComment itripComment = new ItripComment();
//        itripComment.setHotelId(2L);
//        itripComment.setProductId(2L);
//        itripComment.setProductType(1);
//        itripComment.setUserId(1L);
//        itripComment.setIsHavingImg(0);
//        itripComment.setHygieneScore(1);
//        Date d = new Date();
//        String date = "2016-01-01";
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            d = df.parse(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        itripComment.setCreationDate(d);
//        try {
//            Integer i = itripCommentServiceImpl.itriptxAddItripComment(itripComment);
//            System.out.println("新增的主键的ID：" + i);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
