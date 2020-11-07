package com.tatianabrito.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatianabrito.hrworker.entities.Worker;
import com.tatianabrito.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

	@Value(value = "${test.config}")
	private String testConfig;

	@Autowired
	private Environment env;

	@Autowired
	private WorkerRepository repository;

	@GetMapping("/configs")
	public ResponseEntity<Void> getConfig() {
		logger.info("CONFIG: " + testConfig);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {

		/*int x = 1;
		if (x == 1)
		throw new RuntimeException("Test");*/

		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("PORT = " + env.getProperty("local.server.port"));

		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
}
