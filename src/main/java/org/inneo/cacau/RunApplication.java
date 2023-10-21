package org.inneo.cacau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Builder;
import lombok.Data;

@RestController
@SpringBootApplication
public class RunApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunApplication.class, args);
	}
	
	@GetMapping
	public AppInfo apinfo() {
		return AppInfo.builder().state(true).message("is runing").build();
	}

}

@Data
@Builder
class AppInfo {
	private Boolean state;
	private String message;
}