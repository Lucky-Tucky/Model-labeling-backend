package com.lucky.datalabel.Data_Label_Backend.model;

import jakarta.persistence.*;

@Entity
public class OptionTree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String label;

    @Column(nullable = false)
    private int level;

    @ManyToOne
    @JoinColumn(name = "options_id")
    private Options options;
}
