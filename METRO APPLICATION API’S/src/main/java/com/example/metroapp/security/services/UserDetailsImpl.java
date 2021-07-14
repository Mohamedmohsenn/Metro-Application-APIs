package com.example.metroapp.security.services;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.metroapp.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    private static String ROLE_PREFIX = "ROLE_";

    private Integer user_id;
    private String user_name;
    private String fullname;
    private String email;
    @JsonIgnore
    private String password;
    private String phone_number;
    private Date date_of_birth;
    private Double balance;
    private String role;
    private String stripe_id;


    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Integer user_id, String user_name,String fullname, String email, String password,
                           String phone_number, Date date_of_birth, Double balance, String role, String stripe_id,
                           Collection<? extends GrantedAuthority> authorities) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.date_of_birth = date_of_birth;
        this.balance = balance;
        this.role = role;
        this.fullname= fullname;
        this.stripe_id=stripe_id;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + user.getRole()));

        return new UserDetailsImpl(
                user.getUser_id(),
                user.getUsername(),
                user.getFullname(),
                user.getEmail(),
                user.getPassword(),
                user.getPhone_number(),
                user.getDate_of_birth(),
                user.getBalance(),
                user.getRole(),
                user.getStripe_id(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(ROLE_PREFIX + getRole()));
        return list;
    }

    public int getId() {
        return user_id;
    }

    public String getEmail() {
        return email;
    }

    public String getRole()
    {
        return role;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return user_name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getStripe_id() {
        return stripe_id;
    }

    public void setStripe_id(String stripe_id) {
        this.stripe_id = stripe_id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(user_id, user.user_id);
    }
}