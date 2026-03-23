package com.knittedsweater.dto;

public class SweaterCalculationResponse {

    private Long totalStitches;
    private Long totalRows;
    private Double width;
    private Double length;
    private Double stitchDensity;
    private Double rowDensity;
    private String message;

    public SweaterCalculationResponse() {
    }

    public SweaterCalculationResponse(Long totalStitches, Long totalRows, Double width, Double length,
                                     Double stitchDensity, Double rowDensity, String message) {
        this.totalStitches = totalStitches;
        this.totalRows = totalRows;
        this.width = width;
        this.length = length;
        this.stitchDensity = stitchDensity;
        this.rowDensity = rowDensity;
        this.message = message;
    }

    public Long getTotalStitches() {
        return totalStitches;
    }

    public void setTotalStitches(Long totalStitches) {
        this.totalStitches = totalStitches;
    }

    public Long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Long totalRows) {
        this.totalRows = totalRows;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
