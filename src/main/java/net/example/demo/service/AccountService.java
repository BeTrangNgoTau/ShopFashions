package net.example.demo.service;


import net.example.demo.entity.Account;
import net.example.demo.exception.AccountNotFoundException;
import net.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id " + id));
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(Long id, Account accountDetails) {
        Account account = getAccountById(id);
        account.setUsername(accountDetails.getUsername());
        account.setPassword(accountDetails.getPassword());
        account.setEmail(accountDetails.getEmail());
        account.setActive(accountDetails.isActive());
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        Account account = getAccountById(id);
        accountRepository.delete(account);
    }

    public Account login(String username, String password) {
        Account user = accountRepository.findByUsername(username);
        if (user == null || !user.isActive()) {
            throw new AccountNotFoundException("Tài khoản không tồn tại hoặc không hoạt động.");
        }
        // Kiểm tra mật khẩu (nên mã hóa và so sánh)
        if (!user.getPassword().equals(password)) {
            throw new AccountNotFoundException("Mật khẩu không chính xác.");
        }
        return user;
    }
}
