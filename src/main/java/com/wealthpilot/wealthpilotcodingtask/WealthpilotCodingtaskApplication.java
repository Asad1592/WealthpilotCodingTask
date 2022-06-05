package com.wealthpilot.wealthpilotcodingtask;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Soccer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import service.SoccerService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class WealthpilotCodingtaskApplication {

	public static void main(String[] args) {

		SpringApplication.run(WealthpilotCodingtaskApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(SoccerService soccerService){
		return  args -> {
			// read json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Soccer>> typeReference = new TypeReference<List<Soccer>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/soccer_teams.json");
			try {
				List<Soccer> soccers = mapper.readValue(inputStream,typeReference);
				soccerService.save(soccers);
				System.out.println("Teams Saved!");
			} catch (IOException e){
				System.out.println("Unable to save teams: " + e.getMessage());
			}
		};
	}
}
