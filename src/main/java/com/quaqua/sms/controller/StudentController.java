package com.quaqua.sms.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quaqua.sms.exception.StudentNotFoundException;
import com.quaqua.sms.repository.StudentRepository;
import com.quaqua.sms.student.StudentDetails;
 
@RestController
@RequestMapping("/sms")
public class StudentController {
	 @Autowired
	  private StudentRepository StudentRepository;
	  /**
	   * Get all Students list.
	   *
	   * @return the list
	   */
	  @GetMapping("/student")
	  public List<StudentDetails> getAllStudents() {
	    return StudentRepository.findAll();
	  }
	  /**
	   * Gets Students by id.
	   *
	   * @param stuid
	   * @return the Students by id
	   * @throws StudentNotFoundException
	   */
	  @GetMapping("/student/{id}")
	  public ResponseEntity<StudentDetails> getStudentsById(@PathVariable(value = "id") Long stuId)
	      throws StudentNotFoundException {
	    StudentDetails studentDetails =
	        StudentRepository
	            .findById(stuId)
	            .orElseThrow(() -> new StudentNotFoundException());
	    return ResponseEntity.ok().body(studentDetails);
	  }
	  /**
	   * Add new student.
	   *
	   * @param 
	   * @return the Student
	   */
	  
	  @PostMapping("/add_student")
	  public StudentDetails createStudentDetails(@Valid() @RequestBody  StudentDetails studentDetails) {
	    return StudentRepository.save(studentDetails);
	  }
	  /*
	   * Update StudentDetails response entity.
	   *
	   * @param stuId the user id
	   * @param userDetails the user details
	   * @return the response entity
	   * @throws ResourceNotFoundException the resource not found exception
	   */
	  @PutMapping("/Students/{id}")
	  public ResponseEntity<StudentDetails> updateStudentDetails(
	      @PathVariable(value = "id") Long stuId, @Valid @RequestBody StudentDetails studentDetails)
	      throws StudentNotFoundException {
	    StudentDetails stu =
	        StudentRepository
	            .findById(stuId)
	            .orElseThrow(() -> new StudentNotFoundException());
	    stu.setEmail(studentDetails.getEmail());
	    
	    stu.setFname(studentDetails.getFname());
	    stu.setLname(studentDetails.getLname());
	    stu.setPhone_no(studentDetails.getPhone_no());
	    final StudentDetails updatedstudent = StudentRepository.save(stu);
	    return ResponseEntity.ok(updatedstudent);
	  }
	  /*/
	   * Delete user map.
	   *
	   * @param stuId the user id
	   * @return the map
	   * @throws Exception the exception
	   */
	  @DeleteMapping("/user/{id}")
	  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long Id) throws Exception {
	    StudentDetails stu =
	        StudentRepository
	            .findById(Id)
	            .orElseThrow(() -> new StudentNotFoundException());
	    StudentRepository.delete(stu);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
	  }
	}/*
	Create Unit Testing for API Requests and Run the Unit Testing
	@RunWith(SpringRunner.class)
	@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
	public class ApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;
	@LocalServerPort
	private int port;
	private String getRootUrl() {
	return "http://localhost:" + port;
	}
	@Test
	public void contextLoads() {
	}
	@Test
	public void testGetAllStudents() {
	HttpHeaders headers = new HttpHeaders();
	HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/Students",
	HttpMethod.GET, entity, String.class);
	Assert.assertNotNull(response.getBody());
	}
	@Test
	public void testGetUserById() {
	User user = restTemplate.getForObject(getRootUrl() + "/Students/1", User.class);
	System.out.println(user.getFirstName());
	Assert.assertNotNull(user);
	}
	@Test
	public void testCreateUser() {
	User user = new User();
	user.setEmail("admin@gmail.com");
	user.setFirstName("admin");
	user.setLastName("admin");
	user.setCreatedBy("admin");
	user.setUpdatedBy("admin");
	ResponseEntity<User> postResponse = restTemplate.postForEntity(getRootUrl() + "/Students", user, User.class);
	Assert.assertNotNull(postResponse);
	Assert.assertNotNull(postResponse.getBody());
	}
	@Test
	public void testUpdatePost() {
	int id = 1;
	User user = restTemplate.getForObject(getRootUrl() + "/Students/" + id, User.class);
	user.setFirstName("admin1");
	user.setLastName("admin2");
	restTemplate.put(getRootUrl() + "/Students/" + id, user);
	User updatedUser = restTemplate.getForObject(getRootUrl() + "/Students/" + id, User.class);
	Assert.assertNotNull(updatedUser);
	}
	@Test
	public void testDeletePost() {
	int id = 2;
	User user = restTemplate.getForObject(getRootUrl() + "/Students/" + id, User.class);
	Assert.assertNotNull(user);
	restTemplate.delete(getRootUrl() + "/Students/" + id);
	try {
	user = RestTemplate.getForObject(getRootUrl() + "/Students/" + id, User.class);
	} catch (final HttpClientErrorException e) {
	Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
	}
	}
	}	
	
 */

