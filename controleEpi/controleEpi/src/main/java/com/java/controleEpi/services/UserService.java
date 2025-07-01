package com.java.controleEpi.services;

import com.java.controleEpi.dtos.UserUpdateDTO;
import com.java.controleEpi.entities.Devolution;
import com.java.controleEpi.entities.Epi;
import com.java.controleEpi.entities.Loan;
import com.java.controleEpi.entities.User;
import com.java.controleEpi.repositories.DevolutionRepository;
import com.java.controleEpi.repositories.LoanRepository;
import com.java.controleEpi.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private DevolutionRepository devolutionRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }

    public List<User> findByName(String name){
        return userRepository.findByName(name).orElseThrow();
    }

    public User findByEmail(String email){
        return (User) userRepository.findByEmail(email);
    }

    @Transactional
    public User updateEmail(Long id, UserUpdateDTO dto) {
        User user = userRepository.findById(id).orElseThrow();
        user.setEmail(dto.getEmail());
        return userRepository.save(user);
    }

    public void removeUser(Long id, Loan loan, Devolution devolution) {
        User user = findById(id);
        List<Loan> loans = loanRepository.findByUser(user);

        if(loans.isEmpty()) {
            userRepository.delete(user);
            return;
        }

        /*for(Loan loan : loans) {
            boolean hasDevolution = devolutionRepository.findByLoan(loan.getUser());

            if(!hasDevolution) {
                throw new RuntimeException("Usuário não pode ser removido. Existem empréstimos pendentes de devolução.");
            }
        }*/

        userRepository.delete(user);
    }
}