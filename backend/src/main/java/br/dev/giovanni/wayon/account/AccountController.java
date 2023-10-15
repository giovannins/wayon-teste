package br.dev.giovanni.wayon.account;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	private final AccountRepository repository;
	
	public AccountController(AccountRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/accounts")
	List<Account> findAll() {
		return repository.findAll();
	}
	
	@GetMapping("/account/{id}")
	Account findId(@PathVariable long id) {
		return repository.findById(id).orElseThrow();
	}

}
