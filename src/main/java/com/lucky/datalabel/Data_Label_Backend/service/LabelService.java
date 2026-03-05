package com.lucky.datalabel.Data_Label_Backend.service;

import com.lucky.datalabel.Data_Label_Backend.dto.OptionTreeRequest;
import com.lucky.datalabel.Data_Label_Backend.dto.OptionsRequest;
import com.lucky.datalabel.Data_Label_Backend.dto.OptionsResponse;
import com.lucky.datalabel.Data_Label_Backend.model.Image;
import com.lucky.datalabel.Data_Label_Backend.model.OptionLabel;
import com.lucky.datalabel.Data_Label_Backend.model.OptionTree;
import com.lucky.datalabel.Data_Label_Backend.model.Options;
import com.lucky.datalabel.Data_Label_Backend.repository.ImageRespository;
import com.lucky.datalabel.Data_Label_Backend.repository.OptionsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LabelService {

    @Autowired
    private ImageRespository imageRespository;

    @Autowired
    private OptionsRepository optionsRepository;

    public String saveImage(MultipartFile image) throws IOException {

        String fileName = image.getOriginalFilename();
        byte[] file = image.getBytes();

        try {
            Image img = Image.builder()
                    .filename(fileName)
                    .file(file)
                    .build();
            imageRespository.save(img);
            return "Success";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public String saveOptions(OptionsRequest optionsRequest) throws Exception {

        try{

            Options options = new Options();
            List<OptionTree> optionTreeList = new ArrayList<>();
            List<OptionLabel> optionLabelList = new ArrayList<>();

            optionsRequest.optionTree().forEach((branch)->{

                OptionTree optionTree = OptionTree.builder()
                        .label(branch.label())
                        .level(branch.level())
                        .options(options)
                        .build();

                optionTreeList.add(optionTree);

            });

            optionsRequest.options().forEach((branch)->{
                OptionLabel optionLabel = OptionLabel.builder()
                        .label(branch)
                        .options(options)
                        .build();

                optionLabelList.add(optionLabel);

            });

            Image image = imageRespository.findById(optionsRequest.imageId())
                    .orElseThrow(() -> new RuntimeException("Image not found"));

            image.setOptions(options);

            options.setImage(image);

            options.setOptionLabel(optionLabelList);
            options.setOptionTree(optionTreeList);

            optionsRepository.save(options);

            return "Saving Option Success";

        }catch(Exception exception){
            throw new Exception(exception.getMessage());
        }

    }
}
