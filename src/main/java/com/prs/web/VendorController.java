package com.prs.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prs.business.Vendor;
import com.prs.db.JsonResponse;
import com.prs.db.VendorRepository;

@RestController
@RequestMapping("/vendors")
public class VendorController {
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@GetMapping("/")
	public JsonResponse getAll() {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(vendorRepository.findAll());
		}	catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@GetMapping("/{id}")
	public JsonResponse get(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			Optional<Vendor> v = vendorRepository.findById(id);
			if (v.isPresent())
				jr = JsonResponse.getInstance(v);
			else
				jr = JsonResponse.getInstance("No vendor found for id " + id);
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	@PostMapping("/")
	public JsonResponse add(@RequestBody Vendor v) {
		JsonResponse jr = null;
		// NOTE: May need to enhance exception handling if more than one exception type
		// needs to be caught
		try {
			jr = JsonResponse.getInstance(vendorRepository.save(v));
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	@PutMapping("/")
	public JsonResponse update(@RequestBody Vendor v) {
		JsonResponse jr = null;
		// NOTE: May need to enhance exception handling if more than one exception type
		// needs to be caught
		try {
			if (vendorRepository.existsById(v.getId())) {

				jr = JsonResponse.getInstance(vendorRepository.save(v));
			} else {
				jr = JsonResponse.getInstance(
						"Vendor id: " + v.getId() + " does not exist and" + "you are attempting to save it.");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@DeleteMapping("/")
	public JsonResponse delete(@RequestBody Vendor v) {
		JsonResponse jr = null;
		// NOTE: May need to enhance exception handling if more than one exception type
		// needs to be caught
		try {
			if (vendorRepository.existsById(v.getId())) {
				vendorRepository.delete(v);
				jr = JsonResponse.getInstance("User deleted.");
			} else {
				jr = JsonResponse.getInstance(
						"Vendor id: " + v.getId() + " does not exist and " + "you are attempting to delete it.");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
