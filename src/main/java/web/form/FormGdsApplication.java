package web.form;

import com.github.tomakehurst.wiremock.WireMockServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@SpringBootApplication
@Slf4j
public class FormGdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormGdsApplication.class, args);
		WireMockServer wireMockServer = new WireMockServer(options().port(8888).withRootDirectory("src/main/resources/wiremock"));
		wireMockServer.start();
	}

}
