package com.example.metroapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@DynamicInsert
public class User {
    private Integer user_id;
    private String username;
    private String fullname;
    private String email;
    private String password;
    private String phone_number;
    private Date date_of_birth;
<<<<<<< Updated upstream
    private Integer balance;
    private Set<Ticket> tickets = new HashSet<>();


    public User(){
    }

    public User(Integer user_id, String user_name, String email, String password, String phone_number, Date date_of_birth, Integer balance) {
        this.user_id = user_id;
        this.user_name = user_name;
=======
    private Double balance;
    private Set<Ticket> tickets = new HashSet<>();
    private String role;
    private String stripe_id;

    public User(){
    }
    public User(User user){
        this.user_id = user.getUser_id();
        this.username = user.getUsername();
        this.fullname = user.getFullname();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.phone_number = user.getPhone_number();
        this.date_of_birth = user.getDate_of_birth();
        this.balance = user.getBalance();
        this.role = user.getRole();
        this.stripe_id=user.getStripe_id();
    }
    public User(String user_name,String fullname , String email, String password, String phone_number,
                Date date_of_birth, Double balance, String role,String stripe_id) {
        this.username = user_name;
        this.fullname = fullname;
>>>>>>> Stashed changes
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.date_of_birth = date_of_birth;
        this.balance = balance;
        this.role = role;
        this.stripe_id=stripe_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

<<<<<<< Updated upstream
    public Integer getBalance() {
=======
    public Double getBalance() {
>>>>>>> Stashed changes
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

<<<<<<< Updated upstream
=======
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStripe_id() {
        return stripe_id;
    }
    public void setStripe_id(String stripe_id) {
        this.stripe_id = stripe_id;
    }
>>>>>>> Stashed changes

    @OneToMany(mappedBy="user")
    @JsonManagedReference
    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> InputTickets) {
        tickets.addAll(InputTickets);
    }
}

