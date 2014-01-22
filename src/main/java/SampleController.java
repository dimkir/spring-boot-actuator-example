import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Collections;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;


@Controller
@EnableAutoConfiguration
public class SampleController {


  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
      auth.inMemoryAuthentication()
              .withUser("client").password("secret").roles("USER");
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


