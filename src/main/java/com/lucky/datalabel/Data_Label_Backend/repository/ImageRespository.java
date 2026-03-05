package com.lucky.datalabel.Data_Label_Backend.repository;

import com.lucky.datalabel.Data_Label_Backend.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageRespository extends JpaRepository<Image , UUID> {
}
