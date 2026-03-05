package com.lucky.datalabel.Data_Label_Backend.controller;

import com.lucky.datalabel.Data_Label_Backend.dto.OptionsRequest;
import com.lucky.datalabel.Data_Label_Backend.model.Options;
import com.lucky.datalabel.Data_Label_Backend.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/option")
public class labelController {

    @Autowired
    private LabelService labelService;

    @PostMapping("/image")
    public ResponseEntity<?> addImage(@RequestParam("file") MultipartFile image) throws IOException {

        try{

            String result = labelService.saveImage(image);
            return new ResponseEntity<>(result,HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>("Image Not Saved", HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PostMapping("/options")
    public ResponseEntity<?> addOptions(@RequestBody OptionsRequest optionsRequest){

        try{

            String result = labelService.saveOptions(optionsRequest);
            return new ResponseEntity<>(result, HttpStatus.OK);

        }catch (Exception e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
