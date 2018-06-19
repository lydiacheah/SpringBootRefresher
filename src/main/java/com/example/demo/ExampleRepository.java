package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Repository for a specific entity, instance created in controller
// Methods to call on repository instance (in controller) can be found here: https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
@Repository
public interface ExampleRepository extends JpaRepository<ExampleModel, Long> {
    // Query code not required, Spring Data will do the querying
    // if we use their method names (found here: https://docs.spring.io/spring-data/jpa/docs/1.4.3.RELEASE/reference/html/jpa.repositories.html)
    List<ExampleModel> findByNameLengthLessThan(int length);
}
