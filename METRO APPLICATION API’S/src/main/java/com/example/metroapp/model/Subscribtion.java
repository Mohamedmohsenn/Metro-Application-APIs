package com.example.metroapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="subscription")
public class Subscribtion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subscription_id;

    private Integer trips_num;
    private Integer station_num;
    private Integer months_num;
    private Integer price;

   // @JsonManagedReference
    @OneToMany(mappedBy="subscription")
    private Set<NormalSubscribtion> normalSubscribtions = new HashSet<>();

    public Subscribtion()
    {

    }

    public Subscribtion(Integer subscription_id,Integer trips_num, Integer station_num, Integer months_num, Integer price) {
        this.subscription_id=subscription_id;
        this.trips_num = trips_num;
        this.station_num = station_num;
        this.months_num = months_num;
        this.price = price;
    }

    public int gettrips_num() {
        return trips_num;
    }

    public void settrips_num(int trips_num) {
        this.trips_num = trips_num;
    }

    public int getstation_num() {
        return station_num;
    }

    public void setstation_num(int station_num) {
        this.station_num = station_num;
    }

    public int getmonths_num() {
        return months_num;
    }

    public void setmonths_num(int months_num) {
        this.months_num = months_num;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    public int getSubscription_id() {
        return subscription_id;
    }


    public void setSubscription_id(int subscription_id) {
        this.subscription_id = subscription_id;
    }


    public Set<NormalSubscribtion> getNormalSubscribtions() {
        return normalSubscribtions;
    }
    public void setNormalSubscribtions(Set<NormalSubscribtion> normalSubscribtions) {
        this.normalSubscribtions = normalSubscribtions;
    }
}
