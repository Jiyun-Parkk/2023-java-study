package com.woorifisa.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserved_id",nullable = false)
    private long id;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private String vehicleType;
    private Date pickupDate;
    private Date returnDate;
    private String phoneNumber;
}
