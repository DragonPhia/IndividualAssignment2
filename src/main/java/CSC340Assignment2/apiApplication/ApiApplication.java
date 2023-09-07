package CSC340Assignment2.apiApplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

/**
 * @author Dragon Phiansin 
 * Individual Assignment 2 
 *
 * This program gets and prints relevant information from URL
 * @since Sept 5, 2023.
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */

@SpringBootApplication
public class ApiApplication {
    

    public static void main(String[] args) {
	SpringApplication.run(ApiApplication.class, args);
        ravenUser();
        System.exit(0);                            
    }

    public static void ravenUser() {
        try {
            String url = "https://randomuser.me/api/";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonUser = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonUser);

            //gets information
            String firstName = root.findValue("first").asText();
            String lastName = root.findValue("last").asText();
            String gender = root.findValue("gender").asText();
            String dob = root.findValue("date").asText();
            String email = root.findValue("email").asText();
            String age = root.findValue("age").asText();
            
            //gets city & state
            String city = root.findValue("city").asText();
            String state = root.findValue("state").asText();
            
            //prints information
            System.out.println("\nName: " + firstName + " " + lastName + " (" + gender + ")" );
            System.out.println("\nDate of Birth: " + dob + " | Age: " + age);
            System.out.println("\nEmail: " + email);
            System.out.println("\nLocation: " + city + ", " + state);

        } catch (JsonProcessingException ex) {
            System.out.println("error in ravenPrice");
        }
    }
        
        
        
}
