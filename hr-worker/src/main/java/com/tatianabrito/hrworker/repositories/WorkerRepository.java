package com.tatianabrito.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tatianabrito.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
