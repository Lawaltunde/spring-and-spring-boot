package com.amigoscode;

import com.amigoscode.account.Account;
import com.amigoscode.account.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AccountRepository accountRepository;

    public DataInitializer(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) {
        accountRepository.save(new Account("Alice", 1000.0));
        accountRepository.save(new Account("Bob", 500.0));

        // TODO: 4 - Inject StudentRepository into this class (add it to the constructor)
        //  Then save 3 students:
        //  new Student("John", "Doe", "john@gmail.com", 25)
        //  new Student("Jane", "Smith", "jane@yahoo.com", 22)
        //  new Student("Bob", "Johnson", "bob@gmail.com", 30)
        //  Print the student count using studentRepository.count()
    }

}
