package com.lucky.datalabel.Data_Label_Backend.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @Column(nullable = false)
    @OneToMany(mappedBy = "options", cascade = CascadeType.ALL)
    private List<OptionTree> optionTree;

    @Column(nullable = false)
    private List<String> options;

}
