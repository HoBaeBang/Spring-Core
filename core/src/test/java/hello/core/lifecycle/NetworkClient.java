package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient{

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = "+ url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect: "+ url);
    }

    public void call(String message) {
        System.out.println("call: "+ url+ " message = "+ message);
    }

    public void disconnect() {
        System.out.println("close: "+url);
    }

   //의존관계 주입이 끝나면 호출해 주겠따.
    @PostConstruct      //어노 테이션을 사용하면 외부 라이브러리를 사용할수 없는 경우가 생긴다.
    public void init(){
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    //종료 될 때 나올거임
    @PreDestroy
    public void close(){
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
