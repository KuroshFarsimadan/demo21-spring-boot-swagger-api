package ir.kuroshfarsimadan.demo21springbootswaggerapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import ir.kuroshfarsimadan.demo21springbootswaggerapi.bean.User;
import ir.kuroshfarsimadan.demo21springbootswaggerapi.dao.UserRepository;
import ir.kuroshfarsimadan.demo21springbootswaggerapi.exception.NotFoundException;

@RestController
@RequestMapping("/api/v2")
@Api(value = "USER MICROSERVICE REST API") // description =
public class UserController {

	@Autowired
	private UserRepository userDAO;

	@ApiOperation(value = "View a list of available users", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 401, message = "Unauthorized access"),
			@ApiResponse(code = 403, message = "Forbidden access"),
			@ApiResponse(code = 404, message = "Resource not found") })
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userDAO.findAll();
	}

	@ApiOperation(value = "Get user by ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 401, message = "Unauthorized access"),
			@ApiResponse(code = 403, message = "Forbidden access"),
			@ApiResponse(code = 404, message = "Resource not found") })
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long employeeId) throws NotFoundException {
		User employee = userDAO.findById(employeeId)
				.orElseThrow(() -> new NotFoundException("User not found in the database for the id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	@ApiOperation(value = "Save a new user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 401, message = "Unauthorized access"),
			@ApiResponse(code = 403, message = "Forbidden access"),
			@ApiResponse(code = 404, message = "Resource not found") })
	@PostMapping("/users")
	public User createUser(
			@ApiParam(value = "User was succesfully saved into the database", required = true) @Valid @RequestBody User employee) {
		return userDAO.save(employee);
	}

	@ApiOperation(value = "Updtae user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 401, message = "Unauthorized access"),
			@ApiResponse(code = 403, message = "Forbidden access"),
			@ApiResponse(code = 404, message = "Resource not found") })
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
			@Valid @RequestBody User userDetails) throws NotFoundException {
		User user = userDAO.findById(userId)
				.orElseThrow(() -> new NotFoundException("User not found in the database for the id :: " + userId));
		user.setEmail(userDetails.getEmail());
		user.setLastName(userDetails.getLastName());
		user.setFirstName(userDetails.getFirstName());
		final User updatedUser = userDAO.save(user);
		return ResponseEntity.ok(updatedUser);
	}

	@ApiOperation(value = "Delete user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 401, message = "Unauthorized access"),
			@ApiResponse(code = 403, message = "Forbidden access"),
			@ApiResponse(code = 404, message = "Resource not found") })
	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws NotFoundException {
		User user = userDAO.findById(userId)
				.orElseThrow(() -> new NotFoundException("User not found in the database for the id :: " + userId));
		userDAO.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}