package com.amigoscode;

import com.amigoscode.account.Account;
import com.amigoscode.account.AccountRepository;
import com.amigoscode.student.Student;
import com.amigoscode.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final StudentRepository studentRepository;

    public DataInitializer(AccountRepository accountRepository, StudentRepository studentRepository) {
        this.accountRepository = accountRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) {
        accountRepository.save(new Account("Alice", 1000.0));
        accountRepository.save(new Account("Bob", 500.0));

        studentRepository.save(new Student("John", "Doe", "john@gmail.com", 25));
        studentRepository.save(new Student("Jane", "Smith", "jane@yahoo.com", 22));
        studentRepository.save(new Student("Bob", "Johnson", "bob@gmail.com", 30));

        System.out.println("Student count: " + studentRepository.count());
    }

}
