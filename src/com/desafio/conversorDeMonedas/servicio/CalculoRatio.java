package com.desafio.conversorDeMonedas.servicio;

import com.desafio.conversorDeMonedas.modelo.DatosRatioConversion;

public class CalculoRatio {
    public static double calcular(double monto, DatosRatioConversion drc) {
        return monto * Double.valueOf(drc.conversionRate());
    }
}
