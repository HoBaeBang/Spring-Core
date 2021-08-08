package com.example.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//스프링 컨테이너 에서 관리되는 객체들을 Bean이라고 부른다 특정 클래스가 new로 생성된 객체가 빈이다.
@SpringBootApplication
public class IocApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocApplication.class, args);      //기본적으로 작성되어 있는 문장

        ApplicationContext context = ApplicationContextProvider.getContext();   // 객체 관리를 스프링이 하게 만듬

        //Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);     // 스프링이 관리 할 수 있도록 어노테이션을 붙임 @Component!!!
        //UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

        Encoder encoder = context.getBean("urlEncode",Encoder.class);
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        //Encoder encoder = new Encoder(base64Encoder);

        String result = encoder.encode(url);
        System.out.println(result);

//        encoder.setiEncoder(urlEncoder);
//        result = encoder.encode(url);
//        System.out.println(result);
    }
                // 스프링 컨테이너 안에서 많은 빈들이 관리가 되고 있으며 이미 있던 빈을 주입받을수 도 있고 만약 내가 원하는 빈이있다면 @Qualifier를 통해서 이름을 붙여준다.
                // 실질적으로 주입받기 위해서는 생성자 라던지 셋메서드 변수에다가 오토와이어드 인젝트 등을 통해서 객체를 받아올 것이다.(앞으로)
                // 여기 까지 설명한 이유는 스프링 컨테이너를 설명하기 위함이고 스프링에서 객체를 직접 관리하는것 이런 객체를 빈이라하고 이것을 관리되는 장소가 스프링 컨테이너이고
                // 스프링 컨테이너가 제어하는 권한을 가져갔기 때문에 제어의 역전이고 이것이 IOC이다.
                // !스프링 컨테이너 관리하는거 IOC 주입을 받으니까 DI
}

@Configuration
class AppConfig{
    @Bean("base64Encode")
    public Encoder encoder(Base64Encoder base64Encoder){
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncode")
    public Encoder encoder(UrlEncoder urlEncoder){
        return new Encoder(urlEncoder);
    }
}