package com.accenture.springcore.controller.job;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class GetUsersJobRequestParams {
    @Min(0)
    private Integer minLevel;
    private String name;

    public GetUsersJobRequestParams() {
    }

    public GetUsersJobRequestParams(Integer minValue, String name) {
        this.minLevel = minValue;
        this.name = name;
    }

    public Integer getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(Integer minLevel) {
        this.minLevel = minLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
