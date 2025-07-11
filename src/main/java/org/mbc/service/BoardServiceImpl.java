package org.mbc.service;

import java.util.List;
import org.mbc.domain.BoardVO;
import org.mbc.mapper.BoardMapper;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service // 이 클래스는 서비스 계층임을 명시
@AllArgsConstructor // 생성자 자동 주입
@Log4j2 // 로깅 처리용
public class BoardServiceImpl implements BoardService {
	// 조원이 실행문을 생성하는 용도로 활용 필수 : implements BoardService(구현 클래스)
	
	private BoardMapper mapper ; // db 쿼리용 객체(CRUD)
	
	@Override
	public void register(BoardVO board) {
		// 객체가 넘어오면 매퍼를 이용해서 데이터베이스에 등록
		
		log.info("BoardServiceImpl.register메서드 실행.....");
		
		mapper.insertSelectKey(board);
		log.info("정상등록 후 리스트 출력테스트...");
		mapper.getList2();
		
	}

	@Override
	public BoardVO get(Long bno) {
		// 게시물 번호가 들어가면 매퍼의 select문이 동작해야 한다.
		
		log.info("BoardServiceImpl.get메서드 실행.........");
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("BoardServiceImpl.modify메서드 실행....");
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		
		log.info("BoardServiceImpl.remove메서드 발동....");
		return;
	}

	@Override
	public List<BoardVO> getList() {
		// getList() 메서드가 호출되면 매퍼에 getList2()를 호출
		
		log.info("BoardServiceimpl.getList 메서드 실행.....");
		
		return mapper.getList2();
	}

	
}
