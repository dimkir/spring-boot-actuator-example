import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Collections;

import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;


@Controller
@EnableAutoConfiguration
public class SampleController {

    @Bean
    public AuthenticationManager authenticationManager(
                    ObjectPostProcessor<Object> objectPostProcessor) throws Exception {

            InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> builder = new AuthenticationManagerBuilder(
                            objectPostProcessor).inMemoryAuthentication();
            
            builder
                    .withUser("client")
                    .password("secret")
                    .roles( "USER" );

            return builder.and().build();

    }  


  @RequestMapping("/")
  @ResponseBody
  public Map<String, String> helloWorld() {
    return Collections.singletonMap("message", "Hello World");
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(SampleController.class, args);
  }

}


