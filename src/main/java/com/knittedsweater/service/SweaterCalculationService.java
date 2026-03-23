package com.knittedsweater.service;

import com.knittedsweater.dto.SweaterCalculationRequest;
import com.knittedsweater.dto.SweaterCalculationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Service для розрахунків параметрів в'язаного светра
 */
@Service
public class SweaterCalculationService {

    private static final Logger LOG = LoggerFactory.getLogger(SweaterCalculationService.class);

    /**
     * Розраховує загальну кількість петель та рядків для в'язання
     *
     * @param request параметри светра
     * @return результати розрахунків
     */
    public SweaterCalculationResponse calculate(SweaterCalculationRequest request) {
        LOG.info("Starting sweater calculation: width={}, length={}",
                request.getWidth(), request.getLength());

        // Розрахунок петель = (ширина в см × щільність петель) / 10
        // Результат округлюємо до парного числа (вимога в'язання)
        Long totalStitches = calculateStitches(request.getWidth(), request.getStitchDensity());
        if (totalStitches % 2 != 0) {
            totalStitches = totalStitches + 1;
        }
        // Розрахунок рядків = (довжина × щільність рядків) / 10
        Long totalRows = calculateRows(request.getLength(), request.getRowDensity());

        LOG.info("Calculation completed: stitches={}, rows={}", totalStitches, totalRows);

        SweaterCalculationResponse response = new SweaterCalculationResponse();
        response.setTotalStitches(totalStitches);
        response.setTotalRows(totalRows);
        response.setWidth(request.getWidth());
        response.setLength(request.getLength());
        response.setStitchDensity(request.getStitchDensity());
        response.setRowDensity(request.getRowDensity());
        response.setMessage("Calculation completed successfully");
        return response;
    }

    /**
     * Розраховує кількість петель для набору
     */
    private Long calculateStitches(Double width, Double stitchDensity) {
        return Math.round((width * stitchDensity) / 10.0);
    }

    /**
     * Розраховує кількість рядків для в'язання
     */
    private Long calculateRows(Double length, Double rowDensity) {
        return Math.round((length * rowDensity) / 10.0);
    }
}
