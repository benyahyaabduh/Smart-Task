package com.cwa.gedApp.repository;

import com.cwa.gedApp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Task,Long> {
}
