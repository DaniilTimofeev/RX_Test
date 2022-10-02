package com.example.demo.storage;
import com.example.demo.registration.GetRegistrationResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<GetRegistrationResponse, String> {
}
