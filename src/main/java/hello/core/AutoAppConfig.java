package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// 자동으로 component가 붙은 클래스들을 스프링 컨테이너에 등록
// 이전코드를 유지하기 위해 임의로 AppConfig, TestConfig와 같은 설정정보를 컴포넌트 스캔 대상에서 제외함
@ComponentScan(
        //탐색할 패키지의 시작 위치를 지정한다. : basepackages 쓰지말고 config파일 최상단에 위치시키는걸 권장
        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes =  Configuration.class)
)
public class AutoAppConfig {

}
