package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	
	private String title ;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")  // 날짜 처리용 코드 추가
	private Date dueDate ; //import java.util.Date;

}
