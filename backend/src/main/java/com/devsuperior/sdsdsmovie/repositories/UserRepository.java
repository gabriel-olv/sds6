package com.devsuperior.sdsdsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.sdsdsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
