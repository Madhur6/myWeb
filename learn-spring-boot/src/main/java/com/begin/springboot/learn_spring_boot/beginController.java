package com.begin.springboot.learn_spring_boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// https: localhost:8080/begin

// We want to return this data back, Whenever someone hits this api...
//[{
//	"id": 1,
//	"name": "Learn spring-boot",
//	"author": "madhur"
//}]


@RestController
public class beginController {
	// begin: id, name, author
	@RequestMapping("/begin")
	public List<begin> retrieveAllBegin() {
		return Arrays.asList(
				new begin(1, "Learn spring-boot", "madhur"),
				new begin(2, "Learn cloud", "madhur"),
				new begin(3, "Learn azure", "madhur"),
				new begin(4, "Learn python", "madhur")
			);
	}
}
