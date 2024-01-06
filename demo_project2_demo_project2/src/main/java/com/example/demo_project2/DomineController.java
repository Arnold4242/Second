package com.example.demo_project2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/domains")
public class DomineController {
	private final List<Domine> domains = new ArrayList<>();
	
	@PostMapping
    public Domine createDomain(@RequestBody Domine newDomain) {
        domains.add(newDomain);
        return newDomain;
	}
        
        @GetMapping
        public List<Domine> getDomains() {
            return domains;
        }
        
        @GetMapping("/{id}")
        public Domine getDomainById(@PathVariable int id) {
            return domains.stream()
                    .filter(domain -> domain.getId() == id)
                    .findFirst()
                    .orElse(null);
        }
        @PutMapping("/{id}")
        public Domine updateDomain(@PathVariable int id, @RequestBody Domine updatedDomain) {
            for (int i = 0; i < domains.size(); i++) {
                if (domains.get(i).getId() == id) {
                    domains.set(i, updatedDomain);
                    return updatedDomain;
                }
            }
            return null;
        }
        @DeleteMapping("/{id}")
        public String deleteDomain(@PathVariable int id) {
            domains.removeIf(domain -> domain.getId() == id);
            return "Domain with ID: " + id + " deleted successfully.";
        }

}
