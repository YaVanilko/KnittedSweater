document.getElementById('calculatorForm').addEventListener('submit', function (e) {
    e.preventDefault();
    calculateSweater();
});

function calculateSweater() {
    const width = parseFloat(document.getElementById('width').value);
    const length = parseFloat(document.getElementById('length').value);
    const stitches = parseFloat(document.getElementById('stitches').value);
    const rows = parseFloat(document.getElementById('rows').value);

    if (!Number.isFinite(width) || !Number.isFinite(length) || !Number.isFinite(stitches) || !Number.isFinite(rows)) {
        showError('Будь ласка, заповни всі поля.');
        return;
    }

    if (width <= 0 || length <= 0 || stitches <= 0 || rows <= 0) {
        showError('Усі значення мають бути більше за нуль.');
        return;
    }

    clearError();

    const requestBody = {
        width: width,
        length: length,
        stitchDensity: stitches,
        rowDensity: rows
    };

    fetch('/api/sweater/calculate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestBody)
    })
        .then(async function (response) {
            if (!response.ok) {
                const message = await extractApiErrorMessage(response);
                throw new Error(message);
            }
            return response.json();
        })
        .then(function (data) {
            displayResults(data.totalStitches, data.totalRows);
        })
        .catch(function (error) {
            console.error('Calculation error:', error);
            showError(error.message || 'Сталася помилка під час розрахунку. Спробуйте ще раз.');
        });
}

async function extractApiErrorMessage(response) {
    try {
        const payload = await response.json();

        if (Array.isArray(payload.errors) && payload.errors.length > 0) {
            return payload.errors.join('; ');
        }

        if (payload.message && typeof payload.message === 'string') {
            return payload.message;
        }
    } catch (e) {
        // Ignore JSON parsing errors and use fallback below.
    }

    if (response.status === 400) {
        return 'Перевірте введені дані та спробуйте ще раз.';
    }

    if (response.status >= 500) {
        return 'Помилка сервера. Спробуйте пізніше.';
    }

    return 'Помилка під час розрахунку. Спробуйте ще раз.';
}

function displayResults(stitches, rows) {
    clearError();
    document.getElementById('stitchesResult').textContent = stitches;
    document.getElementById('rowsResult').textContent = rows;

    const resultsContainer = document.getElementById('resultsContainer');
    resultsContainer.classList.remove('hidden');

    setTimeout(function () {
        resultsContainer.scrollIntoView({ behavior: 'smooth', block: 'start' });
    }, 100);
}

function resetForm() {
    clearError();
    document.getElementById('calculatorForm').reset();
    document.getElementById('resultsContainer').classList.add('hidden');
}

function showError(message) {
    const errorBox = document.getElementById('formError');
    if (!errorBox) {
        return;
    }

    errorBox.textContent = message;
    errorBox.classList.remove('hidden');
}

function clearError() {
    const errorBox = document.getElementById('formError');
    if (!errorBox) {
        return;
    }

    errorBox.textContent = '';
    errorBox.classList.add('hidden');
}
