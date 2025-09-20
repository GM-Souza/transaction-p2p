package com.transaction_p2p.service;

import com.transaction_p2p.domain.UserType;
import com.transaction_p2p.domain.user.User;
import com.transaction_p2p.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {

    private UserRepository userRepository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuario do tipo Lojista não está autorizado a realizar transação");
        }

        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo insuficiente");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
    }

    public void saveUser(User user){
        this.userRepository.save(user);
    }
}
