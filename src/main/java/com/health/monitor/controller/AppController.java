package com.health.monitor.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.health.monitor.model.BloodPressure;
import com.health.monitor.model.Profile;
import com.health.monitor.model.User;
import com.health.monitor.repo.BloodPressureRepository;
import com.health.monitor.repo.ProfileRepository;
import com.health.monitor.repo.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/bloodp/app")
public class AppController {
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private BloodPressureRepository bloodPressureRepository;
	@Autowired
	private UserRepository userRepository;

	
	@PostMapping("/records")
	public ResponseEntity<Profile> myRecords(@RequestBody Profile profile){
		if(!profileRepository.findById(profile.getId()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found.");
		}
		return new ResponseEntity<Profile>(profileRepository.findById(profile.getId()).get(),HttpStatus.OK);
	}
	
	@PostMapping("/profile")
	public ResponseEntity<Profile> create(@RequestBody Profile profile){
		User user=userRepository.findById(Long.parseLong(profile.getUserId())).get();
		profile.setUser(user);
		return new ResponseEntity<Profile>(profileRepository.save(profile),HttpStatus.OK);
	}
	
	@PostMapping("/record")
	public ResponseEntity<BloodPressure> create(@RequestBody BloodPressure bloodPressure){
		Profile profile=profileRepository.findById(Long.parseLong(bloodPressure.getProfileId())).get();
		bloodPressure.setId(UUID.randomUUID());
		bloodPressure.setDate(LocalDate.now());
		bloodPressure.setPprofile(profile);
		return new ResponseEntity<BloodPressure>(bloodPressureRepository.save(bloodPressure),HttpStatus.OK);
	}
	
	@GetMapping("/profiles")
	public ResponseEntity<List<Profile>> list(){
		return new ResponseEntity<List<Profile>>(profileRepository.findAll(),HttpStatus.OK);
	}
	
	

}
