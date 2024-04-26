function validateForm(formName, fieldsToCheck) {
    var form = document.forms[formName];

    for (var i = 0; i < fieldsToCheck.length; i++) {
        var fieldName = fieldsToCheck[i];
        var fieldInput = form.elements[fieldName];
        var fieldValue = fieldInput.value.trim();

        if (fieldValue === "") {
            var fieldLabel = fieldInput.getAttribute('placeholder') || fieldName; // Используем placeholder или имя поля
            alert("Пожалуйста, заполните все обязательные поля (" + fieldLabel + ")");
            fieldInput.focus(); // Установка фокуса на пустом поле
            return false;
        }
        if (fieldName === 'price') {
            // Проверяем, что значение состоит только из цифр и, возможно, одного пробела
            if (!/^\d+$/.test(fieldValue)) {
                alert("Пожалуйста, введите корректное значение для цены");
                fieldInput.focus();
                return false;
            }
        }

    }
    return true;
}