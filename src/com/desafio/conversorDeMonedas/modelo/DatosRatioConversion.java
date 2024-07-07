package com.desafio.conversorDeMonedas.modelo;

import com.google.gson.annotations.SerializedName;

public record DatosRatioConversion(
        @SerializedName("conversion_rate") String conversionRate) {
}
