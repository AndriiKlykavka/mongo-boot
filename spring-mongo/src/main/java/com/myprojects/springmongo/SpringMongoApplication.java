package com.myprojects.springmongo;

import com.myprojects.springmongo.models.CompanyEntity;
import com.myprojects.springmongo.models.UserEntity;
import com.myprojects.springmongo.repositories.CompanyRepository;
import com.myprojects.springmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringMongoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CompanyRepository companyRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if(companyRepository.findAll().isEmpty()){
			companyRepository.save(new CompanyEntity("High School", "Patona st.", "Alice Smith"));
			companyRepository.save(new CompanyEntity("McDonald's", "Amosova st.", "Bob Johnson"));
		}
		if(userRepository.findAll().isEmpty()){
			userRepository.save(new UserEntity("Andrii Kl", "293103217", "+380991992993",
					companyRepository.findAll().stream().map(CompanyEntity::getId).collect(Collectors.toList())));
		}
		companyRepository.findAll().forEach(System.out::println);
		userRepository.findAll().forEach(System.out::println);
	}
}
