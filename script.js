document.getElementById('calculatorForm').addEventListener('submit', function(e) {
    e.preventDefault();
    calculateSweater();
});

function calculateSweater() {
    // Отримуємо значення з форми
    const width = parseFloat(document.getElementById('width').value);
    const length = parseFloat(document.getElementById('length').value);
    const stitches = parseFloat(document.getElementById('stitches').value);
    const rows = parseFloat(document.getElementById('rows').value);

    // Валідація
    if (!width || !length || !stitches || !rows) {
        alert('Будь ласка, заповни всі поля!');
        return;
    }

    if (width <= 0 || length <= 0 || stitches <= 0 || rows <= 0) {
        alert('Усі значення мають бути більше за нуль!');
        return;
    }

    // Розрахунки
    // Петлі = (ширина в см × щільність петель) / 10
    const totalStitches = Math.round((width * stitches) / 10);

    // Рядки = (довжина × щільність рядків) / 10
    const totalRows = Math.round((length * rows) / 10);

    // Виводимо результати
    displayResults(totalStitches, totalRows);
}

function displayResults(stitches, rows) {
    document.getElementById('stitchesResult').textContent = stitches;
    document.getElementById('rowsResult').textContent = rows;

    const resultsContainer = document.getElementById('resultsContainer');
    resultsContainer.classList.remove('hidden');

    // Скролимо до результатів
    setTimeout(() => {
        resultsContainer.scrollIntoView({ behavior: 'smooth', block: 'start' });
    }, 100);
}

function resetForm() {
    document.getElementById('calculatorForm').reset();
    document.getElementById('resultsContainer').classList.add('hidden');
}

