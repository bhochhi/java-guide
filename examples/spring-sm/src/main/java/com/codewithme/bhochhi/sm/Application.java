package com.codewithme.bhochhi.sm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private StateMachine<States, Events> stateMachine;

	public static void main(String[] args) {
//		SpringApplication app = new SpringApplication(Application.class);
//		app.setWebEnvironment(false); // <<<<<<<<<
//		app.run(args);
		 SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		stateMachine.sendEvent(Events.E1);
		stateMachine.sendEvent(Events.E2);
	}

	public enum States {
		SI, S1, S2
	}

	public enum Events {
		E1, E2
	}
}
