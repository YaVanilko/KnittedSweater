package com.knittedsweater.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Request DTO для отримання параметрів светра
 */
public class SweaterCalculationRequest {

    @NotNull(message = "Ширина світра не може бути порожною")
    @Min(value = 10, message = "Ширина повинна бути не менше 10 см")
    private Double width;

    @NotNull(message = "Довжина світра не може бути порожною")
    @Min(value = 10, message = "Довжина повинна бути не менше 10 см")
    private Double length;

    @NotNull(message = "Щільність петель не може бути порожною")
    @Min(value = 5, message = "Щільність петель повинна бути не менше 5")
    private Double stitchDensity;

    @NotNull(message = "Щільність рядків не може бути порожною")
    @Min(value = 5, message = "Щільність рядків повинна бути не менше 5")
    private Double rowDensity;

    public SweaterCalculationRequest() {
    }

    public SweaterCalculationRequest(Double width, Double length, Double stitchDensity, Double rowDensity) {
        this.width = width;
        this.length = length;
        this.stitchDensity = stitchDensity;
        this.rowDensity = rowDensity;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getStitchDensity() {
        return stitchDensity;
    }

    public void setStitchDensity(Double stitchDensity) {
        this.stitchDensity = stitchDensity;
    }

    public Double getRowDensity() {
        return rowDensity;
    }

    public void setRowDensity(Double rowDensity) {
        this.rowDensity = rowDensity;
    }
}
