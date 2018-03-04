package com.project.amio.projetamio;

/**
 * Created by MusKad on 04/03/2018.
 */

public class Sensor {

    private String name;
    private Double value;

    public Sensor (String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }
}

