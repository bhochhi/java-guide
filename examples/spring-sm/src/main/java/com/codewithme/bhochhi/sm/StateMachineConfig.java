package com.codewithme.bhochhi.sm;

import java.util.EnumSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import com.codewithme.bhochhi.sm.Application.Events;
import com.codewithme.bhochhi.sm.Application.States;

@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

	@Override
	public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
		config.withConfiguration().autoStartup(true).listener(listener());
	}

	@Override
	public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
		states.withStates().initial(States.SI).states(EnumSet.allOf(States.class));
	}

	@Override
	public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
		transitions.withExternal().source(States.SI).target(States.S1).event(Events.E1).and().withExternal()
				.source(States.S1).target(States.S2).event(Events.E2);
	}

	@Bean
	public StateMachineListener<States, Events> listener() {
		return new StateMachineListenerAdapter<States, Events>() {
			@Override
			public void stateChanged(State<States, Events> from, State<States, Events> to) {
				System.out.println("State change to " + to.getId());
			}
		};
	}
}