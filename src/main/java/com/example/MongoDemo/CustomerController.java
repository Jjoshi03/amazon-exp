package com.example.MongoDemo;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
class CustomerController {

  private final ProductRepository prodrepository;

  CustomerController(ProductRepository prodrepository) {
    this.prodrepository = prodrepository;
  }



  @GetMapping("/bands")
  List<Customer> all() {
    return prodrepository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping(path="/customers",consumes = MediaType.APPLICATION_JSON_VALUE)
  
  Customer newCustomer(@RequestBody Customer newCustomer) {
    return prodrepository.save(newCustomer);
  }

  // Single item
  
  /*@GetMapping("/employees/{id}")
  Customer one(@PathVariable Long id) {
    
    return prodrepository.findById(id)
      .orElseThrow(() -> new EmployeeNotFoundException(id));
  }

  @PutMapping("/employees/{id}")
  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(employee -> {
        employee.setName(newEmployee.getName());
        employee.setRole(newEmployee.getRole());
        return repository.save(employee);
      })
      .orElseGet(() -> {
        newEmployee.setId(id);
        return repository.save(newEmployee);
      });
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }*/
}