package ru.volkov.springStudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.volkov.springStudy.model.Bank;
import ru.volkov.springStudy.service.BankService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    private final BankService bankService;

    @Autowired
    public Controller(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/bank/{id}")
    public Bank getBankById(@PathVariable Integer id) {
        return bankService.getBank(id);
    }

    @GetMapping("/all")
    public List<Bank> getAllBanks() {
        return bankService.getAllBanks();
    }

    @PostMapping("/bank")
    public Bank createBank(@RequestBody Bank bank) {
        return bankService.saveBank(bank);
    }

    @PutMapping("/bank/{id}")
    public Bank updateBank(@PathVariable Integer id, @RequestBody Bank bankDetails) {
        return bankService.updateBank(id, bankDetails);
    }

    @DeleteMapping("/bank/{id}")
    public void deleteBank(@PathVariable Integer id) {
        bankService.deleteBank(id);
    }

    @GetMapping("/hi")
    public String getName(){
        return "Petrov";
    }
}
