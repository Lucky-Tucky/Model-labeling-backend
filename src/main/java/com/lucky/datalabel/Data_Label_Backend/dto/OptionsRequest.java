package com.lucky.datalabel.Data_Label_Backend.dto;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record OptionsRequest(UUID imageId , List<OptionTreeRequest> optionTree , List<String> options) {
}
