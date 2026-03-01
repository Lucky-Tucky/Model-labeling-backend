package com.lucky.datalabel.Data_Label_Backend.model;

import jakarta.persistence.*;

public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int id;

    @Column(nullable = false)
    private String filename;

    @Column(nullable = false)
    private byte[] file;

//    @OneToOne
//    @JoinColumn(name = "option_id")
//    private Options options;
}
