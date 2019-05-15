package war;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
@MapperScan(basePackages = "war.sys.dao")//使用mybatis-plus要指明mapper扫描路径
//@EnableAutoConfiguration
@SpringBootApplication
public class SpringCloudApplication {

	@GetMapping("/test")
	public String test(HttpServletRequest request){
		String host= request.getHeader("x-forwarded-host");
//		Enumeration<String> tt =  request.getHeaderNames();
//		Enumeration<String> ee = request.getHeaders(tt.nextElement());
		System.out.println("=========="+host);

		return "成功连接！";
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringCloudApplication.class, args);
	}
}
