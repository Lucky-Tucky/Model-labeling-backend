package com.lucky.datalabel.Data_Label_Backend.model;

import jakarta.persistence.*;

public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int id;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

}
