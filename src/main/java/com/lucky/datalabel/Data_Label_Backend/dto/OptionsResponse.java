package com.lucky.datalabel.Data_Label_Backend.dto;

import com.lucky.datalabel.Data_Label_Backend.model.OptionTree;
import lombok.Builder;

import java.util.List;

@Builder
public record OptionsResponse(List<OptionTree> optionTree, List<String> options) {
}
