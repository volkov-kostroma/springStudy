package ru.volkov.springStudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.volkov.springStudy.model.Bank;
import ru.volkov.springStudy.repository.BankRepository;

import java.util.List;

@Service
public class BankService {
    private static final Logger logger = LoggerFactory.getLogger(BankService.class);

    @Autowired
    private final BankRepository bankRepository;

    @Autowired
    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    public Bank saveBank(Bank bank) {
        return bankRepository.save(bank);
    }

    public Bank getBank(Integer id) {
        logger.info("Fetching bank with ID: " + id);
        return bankRepository.findById(id).orElse(null);
    }

    public Bank updateBank(Integer id, Bank bankDetails) {
        Bank bank = bankRepository.findById(id).orElse(null);
        if (bank != null) {
            bank.setBank_Name(bankDetails.getBank_Name()); // Пример обновления поля
            bank.setBin(bankDetails.getBin()); // Пример обновления другого поля
            bankRepository.save(bank);
        }
        return bank;
    }

    public void deleteBank(Integer id) {
        bankRepository.deleteById(id);
    }
}
