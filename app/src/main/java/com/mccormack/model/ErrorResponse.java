package com.mccormack.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Getter
public class ErrorResponse {
    @JsonProperty("ErrorMessage")
    private String errorMessage;
}
