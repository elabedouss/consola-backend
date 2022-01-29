package com.consola.rest;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.consola.dto.VacationStatusDTO;
import com.consola.model.VacationStatus;
import com.consola.repositories.VacationStatusRepository;

@RestController
@RequestMapping("/api/vacation-status")
public class VacationStatusRestController {

	@Autowired
	private VacationStatusRepository vacationStatusRepository;

	private ModelMapper mapper = new ModelMapper();
	
	@GetMapping("")
	public ResponseEntity<Page<VacationStatus>> status(
			@RequestParam(name = "pageSize", defaultValue = "10", required = false) Integer pageSize,
			@RequestParam(name = "pageIndex", defaultValue = "0", required = false) Integer pageIndex) {
		return new ResponseEntity<>(vacationStatusRepository.findAll(PageRequest.of(pageIndex, pageSize)), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Optional<VacationStatus> statusById(@PathVariable("id") int id) {
		return vacationStatusRepository.findById(id);
	}

	@PostMapping("/save")
	public VacationStatus saveStatus(@RequestBody VacationStatusDTO status) {
		return vacationStatusRepository.saveAndFlush(mapper.map(status, VacationStatus.class));
	}

	@DeleteMapping("/{id}")
	public void deleteStatusById(@PathVariable("id") int id) {
		vacationStatusRepository.deleteById(id);
	}

}