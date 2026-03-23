# Knitted Sweater Calculator

Spring Boot web app for calculating sweater knitting parameters.

## Tech Stack

- Java 17
- Spring Boot 3.2
- Maven
- HTML/CSS/JavaScript frontend in `src/main/resources/static`

## Project Structure

- `src/main/java/com/knittedsweater/KnittedSweaterApplication.java`
- `src/main/java/com/knittedsweater/controller/SweaterCalculatorController.java`
- `src/main/java/com/knittedsweater/service/SweaterCalculationService.java`
- `src/main/java/com/knittedsweater/dto/SweaterCalculationRequest.java`
- `src/main/java/com/knittedsweater/dto/SweaterCalculationResponse.java`
- `src/main/resources/static/index.html`
- `src/main/resources/static/styles.css`
- `src/main/resources/static/script.js`
- `src/test/java/com/knittedsweater/service/SweaterCalculationServiceTest.java`

## Run

```powershell
Set-Location "D:\JProjects\KnittedSweater"
mvn spring-boot:run
```

Open:
- `http://localhost:8080`

## Test

```powershell
Set-Location "D:\JProjects\KnittedSweater"
mvn test
```

## API

### Calculate

- Method: `POST`
- URL: `/api/sweater/calculate`

Request example:

```json
{
  "width": 40,
  "length": 60,
  "stitchDensity": 20,
  "rowDensity": 25
}
```

Response example:

```json
{
  "totalStitches": 80,
  "totalRows": 150,
  "width": 40.0,
  "length": 60.0,
  "stitchDensity": 20.0,
  "rowDensity": 25.0,
  "message": "Calculation completed successfully"
}
```

### Health

- Method: `GET`
- URL: `/api/sweater/health`
