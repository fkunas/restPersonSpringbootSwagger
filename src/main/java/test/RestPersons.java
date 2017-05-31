package test;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dto.Person;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@RestController
public class RestPersons {

	public static ArrayList<Person> personList = new ArrayList<>();
	
    public static void main(String[] args) {
    	initWhoList();
        SpringApplication.run(RestPersons.class, args);
    }

	private static void initWhoList() {
    	Person person = new Person();
    	person.setId("1");
    	person.setFirstname("Hans");
    	person.setLastname("Mustermann");
    	person.setCountry("Germany");
    	person.setStreet("Musterstrasse");
    	person.setStreetnumber("4");
    	
    	Person person1 = new Person();
    	person1.setId("2");
    	person1.setFirstname("Jan");
    	person1.setLastname("Feuerstein");
    	person1.setCountry("Germany");
    	person1.setStreet("Seilergasse");
    	person1.setStreetnumber("5");
    	
    	Person person2 = new Person();
    	person2.setId("3");
    	person2.setFirstname("Herbert");
    	person2.setLastname("Stark");
    	person2.setCountry("England");
    	person2.setStreet("Downstreet");
    	person2.setStreetnumber("1");
    	
    	Person person3 = new Person();
    	person3.setId("4");
    	person3.setFirstname("Henriette");
    	person3.setLastname("Halbacht");
    	person3.setCountry("Bukarest");
    	person3.setStreet("Upstreet");
    	person3.setStreetnumber("4c");
    	
    	Person person4 = new Person();
    	person4.setId("5");
    	person4.setFirstname("Lisa");
    	person4.setLastname("Simpson");
    	person4.setCountry("Germany");
    	person4.setStreet("Segelweg");
    	person4.setStreetnumber("4d");
		
    	personList.add(person);
    	personList.add(person1);
    	personList.add(person2);
    	personList.add(person3);
    	personList.add(person4);
	}
	
    @Bean

    public Docket newsApi() {

        return new Docket(DocumentationType.SWAGGER_2)

                .apiInfo(apiInfo())

                .select()

                .paths(PathSelectors.any())

                .build();

    }

     

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()

                .title("Spring REST Sample with Swagger")

                .description("Spring REST Sample with Swagger")

                .contact("Finn Kunas")

                .version("1.0")

                .build();

    }
	
	@ApiOperation(value = "provideDocumentation", nickname = "provideDocumentation")
    @RequestMapping(method = RequestMethod.GET, path="/")
    public String index() {
        return "Please fetch REST-Documentation under: .../swagger-ui.html";
    }
}