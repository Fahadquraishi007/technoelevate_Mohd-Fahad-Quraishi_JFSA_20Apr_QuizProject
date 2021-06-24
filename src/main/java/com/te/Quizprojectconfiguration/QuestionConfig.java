package com.te.Quizprojectconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.te.Quizproject.beans.Questions;

@Configuration
public class QuestionConfig {
	@Bean
	@Scope("prototype")
public Questions getQuesBean() {
	return new Questions();
}
}
