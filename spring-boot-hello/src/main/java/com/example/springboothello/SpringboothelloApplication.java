package com.example.springboothello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringboothelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringboothelloApplication.class, args);
		//java8 的lambda表达式
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.forEach((player) -> System.out.print(player + "; "));
	}
}
