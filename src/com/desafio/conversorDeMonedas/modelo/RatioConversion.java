package com.desafio.conversorDeMonedas.modelo;

public class RatioConversion {
    private Double ratioConversion;

    public RatioConversion(DatosRatioConversion drc) {
        this.ratioConversion = Double.valueOf(drc.conversionRate());
    }

    public Double getRatioConversion() {
        return ratioConversion;
    }

    public void setRatioConversion(Double ratioConversion) {
        this.ratioConversion = ratioConversion;
    }

    @Override
    public String toString() {
        return "RatioConversion{" +
                "ratioConversion=" + ratioConversion +
                '}';
    }
}
