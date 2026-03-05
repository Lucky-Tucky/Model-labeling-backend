package com.lucky.datalabel.Data_Label_Backend.repository;

import com.lucky.datalabel.Data_Label_Backend.model.Options;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OptionsRepository extends JpaRepository<Options , UUID> {
}
