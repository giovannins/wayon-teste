package br.dev.giovanni.wayon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import br.dev.giovanni.wayon.account.AccountRepository;
import br.dev.giovanni.wayon.account.Account;

@Configuration
public class LoadDatabase {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabase(AccountRepository repository) {
		return args ->  {
			log.info("Preloadin " + repository.save(new Account("João", 200.0f)));
			log.info("Preloadin " + repository.save(new Account("Maria", 100.0f)));
		};
	}
}
