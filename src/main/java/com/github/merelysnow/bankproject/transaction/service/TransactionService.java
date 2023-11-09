package com.github.merelysnow.bankproject.transaction.service;

import com.github.merelysnow.bankproject.repository.TransactionRepository;
import com.github.merelysnow.bankproject.transaction.data.Transaction;
import com.github.merelysnow.bankproject.user.data.User;
import com.github.merelysnow.bankproject.user.service.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserService userService;

    public void createTransaction(Transaction transaction) throws Exception {
        final User sender = userService.findUserById(transaction.getSenderId());
        final User receiver = userService.findUserById(transaction.getReceiverId());

        if (sender.getBalance() < transaction.getBalance()) throw new Exception("O sender não possui essa quantia");

        transaction.setDate(new Date());
        sender.decrementBalance(transaction.getBalance());
        receiver.incrementBalance(transaction.getBalance());

        transactionRepository.save(transaction);
        userService.saveUser(sender);
        userService.saveUser(receiver);

    }

    public void saveTransaction(@NonNull Transaction transaction) {
        this.transactionRepository.save(transaction);
    }

    public List<Transaction> getAll() {
        return this.transactionRepository.findAll();
    }
}
