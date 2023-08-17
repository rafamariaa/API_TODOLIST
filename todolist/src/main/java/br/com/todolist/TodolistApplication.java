package br.com.todolist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Bean
	CommandLineRunner criarTarefasFake(TodoRepository todoRepository){
		return args -> {
			todoRepository.deleteAll();

			Todo todo1 = new Todo("Configurar JDK","Preciso aprender a configurar o jdk corretamente", StatusEnum.NOT_STARTED);
			Todo todo2 = new Todo("Estudar java", "Estudar java para aprender prorgramação", StatusEnum.IN_PROGRESS);
			Todo todo3 = new Todo("Estudar HTML", "Estudar Html para desenvolver sites", StatusEnum.FINISHED);
			todoRepository.save(todo1);
			todoRepository.save(todo2);
			todoRepository.save(todo3);
		};

	}

}
