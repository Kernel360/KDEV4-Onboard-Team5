package com.sh.restapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sh.restapi.model.UserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiApplicationTests {

	@Autowired //spring에서 관리하는 빈 중 자동으로 생성되는 ObjectMapper를 가져와줌
	private ObjectMapper objectMapper;

	@Test
 	void contextLoads() throws JsonProcessingException {
//		var user = new UserRequest("홍길동", 10, "hong@gamil.com", true);
//		System.out.println(user);
//		user.setUserName("홍길동");
//		user.setUserAge(10);
//		user.setEmail("hong@gmail.com");
//		user.setIsKorean(true);

		//dto -> json (직렬화)
		//var json = objectMapper.writeValueAsString(user);
		var json = "{\"user_name\":\"홍길동\",\"user_age\":10,\"email\":\"hong@gamil.com\",\"is_korean\":true}";
		System.out.println(json);

		//json -> dto (역직렬화)
		var dto = objectMapper.readValue(json, UserRequest.class);
		System.out.println(dto);

	}

}
