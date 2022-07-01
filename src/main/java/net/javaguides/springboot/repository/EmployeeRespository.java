package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Long> {

    List<Employee> findByFirstName(String firstName);
    List<Employee> findByLastName(String lastName);

    List<Employee> findByEmail(String email);
}