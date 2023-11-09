package com.github.merelysnow.bankproject.user.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName, lastName;
    @Column(unique = true)
    private String document;
    private double balance;

    public void incrementBalance(double newBalance) {
        setBalance(balance + newBalance);
    }

    public void decrementBalance(double newBalance) {
        setBalance(balance - newBalance);
    }
}
