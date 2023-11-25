package ru.volkov.springStudy.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.volkov.springStudy.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer> {
}
