package com.knittedsweater.service;

import com.knittedsweater.dto.SweaterCalculationRequest;
import com.knittedsweater.dto.SweaterCalculationResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SweaterCalculationServiceTest {

    private final SweaterCalculationService service = new SweaterCalculationService();

    // 1. Типовий кейс: width=40, length=60, stitchDensity=20, rowDensity=25
    // Петлі: round((40 * 20) / 10) = 80 → вже парне → 80
    // Ряди:  round((60 * 25) / 10) = 150
    @Test
    void typicalCaseReturnsCorrectResult() {
        SweaterCalculationRequest request = new SweaterCalculationRequest(40.0, 60.0, 20.0, 25.0);

        SweaterCalculationResponse response = service.calculate(request);

        Assertions.assertEquals(80L, response.getTotalStitches());
        Assertions.assertEquals(150L, response.getTotalRows());
    }

    // 2. Якщо формула дає непарне число петель → округлюємо до наступного парного
    // Петлі: round((45 * 21) / 10) = round(94.5) = 95 → непарне → 96
    @Test
    void oddStitchesAreRoundedUpToEven() {
        SweaterCalculationRequest request = new SweaterCalculationRequest(45.0, 60.0, 21.0, 25.0);

        SweaterCalculationResponse response = service.calculate(request);

        Assertions.assertEquals(0, response.getTotalStitches() % 2,
                "Кількість петель завжди має бути парною");
    }

    // 3. Якщо формула дає парне число → залишається без змін
    // Петлі: round((50 * 20) / 10) = 100 → вже парне → 100
    @Test
    void evenStitchesAreNotChanged() {
        SweaterCalculationRequest request = new SweaterCalculationRequest(50.0, 60.0, 20.0, 25.0);

        SweaterCalculationResponse response = service.calculate(request);

        Assertions.assertEquals(100L, response.getTotalStitches());
    }

    // 4. Ряди рахуються без змін (без округлення до парного)
    // Ряди: round((70 * 30) / 10) = 210
    @Test
    void rowsAreCalculatedCorrectly() {
        SweaterCalculationRequest request = new SweaterCalculationRequest(40.0, 70.0, 20.0, 30.0);

        SweaterCalculationResponse response = service.calculate(request);

        Assertions.assertEquals(210L, response.getTotalRows());
    }
}
