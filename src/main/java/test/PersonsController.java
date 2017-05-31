package test;

import org.springframework.web.bind.annotation.RestController;

import dto.Person;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class PersonsController {

    
    @ApiOperation(value = "getPersons", nickname = "getPersons")
    @RequestMapping(method = RequestMethod.GET, path="/persons")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "firstname", value = "User's firstname", required = false, dataType = "string", paramType = "query")
      })
    public List<Person> returnPersons(String firstname) {
    	if ( firstname == null || firstname.equals("")){
    		return RestPersons.personList;
    	}else{
            List<Person> personsToReturn = new ArrayList<Person>();
            for (Person p : RestPersons.personList){
            	if (p.getFirstname().equals(firstname)){
            		personsToReturn.add(p);
            	}
            }
            return personsToReturn;
    	}
        }
    
    @ApiOperation(value = "deletePerson", nickname = "deletePerson")
    @RequestMapping(method = RequestMethod.DELETE, path="/persons")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "User's id", required = false, dataType = "string", paramType = "query")
      })
    public String deletePersonByFirstname(String id) {
        List<Person> personsToDelete = new ArrayList<Person>();
        for (Person p : RestPersons.personList){
        	if (p.getId().equals(id)){
        		personsToDelete.add(p);
        	}
        }
        if (personsToDelete.size()>0){
        	for (Person p : personsToDelete){
        		RestPersons.personList.remove(p);
        	}
        	return "Person with ID: " + id + " successfully deleted.";
        }else{
        return "ID not found.";
        }
        }
    
    @ApiOperation(value = "addPersons", nickname = "addPersons")
    @RequestMapping(method = RequestMethod.POST, path="/persons")
    public String addPersons(@RequestBody ArrayList<Person> personsToAdd) {
    	ArrayList<Person> finalPersons = new ArrayList<Person>();
    	ArrayList<String> addedPersons = new ArrayList<String>();
    	for (Person p : personsToAdd){
    		Boolean isIdUnique = true;
    		for(Person p1 : RestPersons.personList){
    			if (p.getId().equals(p1.getId())){
    				isIdUnique = false;
    			}
    		}
    		if(isIdUnique){
    			addedPersons.add(p.getId());
    			finalPersons.add(p);
    		}
    	}
    	
    	for (Person addingPerson : finalPersons){
    		RestPersons.personList.add(addingPerson);
    	}
    	if (finalPersons.size()>0){
    		String idString = new String();
    		for (Person p : finalPersons){
    			idString = idString + p.getId() + " ";
    		}
    		return "Successfully added Persons for IDs: " + idString + "!";
    	}else{
    		return "No Persons added! (ID already taken?)";
    	}

        }
    
    @ApiOperation(value = "updatePerson", nickname = "updatePerson")
    @RequestMapping(method = RequestMethod.PUT, path="/persons")
    public String updatePerson(@RequestBody Person person) {
    		String idToUpdate = person.getId();
    		Boolean isIdValid = false;
    		Person personToRemove = null;
    		
    		for (Person p : RestPersons.personList){
    			if(p.getId().equals(idToUpdate)){
    				isIdValid = true;
    				personToRemove = p;
    			}
    		}
    		if(isIdValid){
    			RestPersons.personList.remove(personToRemove);
    			RestPersons.personList.add(person);
    			return "Person with ID: " + person.getId() + " successfully updated!";
    		}
    		return "No Person with given ID found!";
    	
        }

}