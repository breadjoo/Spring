package org.zerock.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.persistence.BoardDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class BoardDAOTests {
	
	@Inject
	private BoardDAO dao;	
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTests.class);
	
	@Test
	public void testCreate() throws Exception {
		BoardVO board = new BoardVO();
		board.setTitle("�깉濡쒖슫 湲��쓣 �꽔�뒿�땲�떎.");
		board.setContent("�깉濡쒖슫 �궡�슜�쓣 �꽔�뒿�땲�떎.");
		board.setWriter("�솉湲몃룞");
		dao.create(board);		
	}
	
	@Test
	public void testRead() throws Exception {
		logger.info(dao.read(1).toString());
	}

	 @Test
	  public void testUpdate() throws Exception {
		 BoardVO board = new BoardVO();
		 board.setBno(1);
		 board.setTitle("�닔�젙湲��엯�땲�떎.");
		 board.setContent("�닔�젙 �뀒�뒪�듃�엯�땲�떎.");
		 dao.update(board);		 
	 }
	 
	 @Test
	  public void testDelete() throws Exception {
		 dao.delete(1);
	 }
	 
	 @Test
	  public void testListAll() throws Exception {
		 
		 logger.info(dao.listAll().toString()); 
	 }
	 
	 @Test
	  public void testListPage() throws Exception {
		 int page = 1;
		 
		 List<BoardVO> list = dao.listPage(page);
		 
		 for(BoardVO BoardVO : list) {
			 logger.info(BoardVO.getBno()+" : "+BoardVO.getTitle());
		 }
	 }
	 
	 @Test
	 public void testListCriteria() throws Exception {
		 Criteria cri = new Criteria();
		 cri.setPage(3);
		 cri.setPerPageNum(11);
		 cri.getPageStart();
		 
		 List<BoardVO> list = dao.listCriteria(cri);
		 
		 for(BoardVO BoardVO : list) {
			 logger.info(BoardVO.getBno()+" : " +BoardVO.getTitle());
		 }
		 
	 }
}
