package cn.mldn.microcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"cn.mldn.service","cn.mldn.microcloud"})
@EnableFeignClients(basePackages={"cn.mldn.service"})
public class Consumer_80_StartSpringCloudApplication {
	public static void main(String[] args) {
		SpringApplication.run(Consumer_80_StartSpringCloudApplication.class,
				args);
	}
}
