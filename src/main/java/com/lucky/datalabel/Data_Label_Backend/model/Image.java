package com.lucky.datalabel.Data_Label_Backend.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String filename;

    @Column(nullable = false)
    private byte[] file;

    @OneToOne(mappedBy = "image", cascade = CascadeType.ALL)
    private Options options;
}
