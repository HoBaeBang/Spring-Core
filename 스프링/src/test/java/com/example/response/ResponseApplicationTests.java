package com.example.response;

import com.example.response.dto.Users;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ResponseApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("----------");

        // Text JSON ->Object
        // object -> Text JSON

        // controller request json(text) -> object
        // response object -> json(text)

        var objectMapper = new ObjectMapper();

        // object -> Text
        // object -> text 일때는  object mapper가 object의 get메서드를 사용한다 따라서 object는 getter을 지녀야 한다.
        // 너무나 중요하게도 object클래스 안에 다른 메서드를 임의로 만들어서 사용할 경우 이름앞에 get을 붙이면 안돌아간다!!!!
        var users = new Users("steve", 10, "010-1111-2222");
        var text = objectMapper.writeValueAsString(users);
        System.out.println(text);

        // text -> object
        // text -> object로 바뀔때에는 object mapper는 default 생성자를 필요로 한다.
        var objectUsers = objectMapper.readValue(text, Users.class);
        System.out.println(objectUsers);
    }

}
