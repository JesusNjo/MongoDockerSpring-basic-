package com.springmongo.springmongo;

import com.springmongo.springmongo.models.Student;
import com.springmongo.springmongo.models.helpers.Address;
import com.springmongo.springmongo.models.helpers.Gender;
import com.springmongo.springmongo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class SpringmongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmongoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate){
		return args -> {
			Address address = new Address("United State","Chicago","8478");
			Student student = new Student("Lukas","Norton","LukasNorton@gmail.com", Gender.MALE,address, List.of("Science", "Biology"), BigDecimal.ZERO, LocalDateTime.now()
			);

			String email = "LukasNorton@gmail.com";
			repository.findStudentByEmail(email).ifPresentOrElse(s->{
				System.out.println(s.getEmail() + " Already Exist");
			}, () ->{
				System.out.println("Inserting student "+ student);
				repository.insert(student);
			});



			/*Query query = new Query();
			query.addCriteria(Criteria.where("email").is(email)); //Consultar en Mongo

			List<Student> studentList= mongoTemplate.find(query,Student.class);
			if(studentList.size()> 1){
				throw new IllegalStateException("Found many students with email "+email);
			}
			if(studentList.isEmpty()){
				System.out.println("Inserting student "+ student);
				repository.insert(student);
			}else{
				System.out.println(student.getEmail() + " Already Existe");
			}*/
		};
	}

}
