document.addEventListener("DOMContentLoaded", function () {
    // Get form and field elements
    const form = document.getElementById('register-form');
    const nameField = document.getElementById('name');
    const emailField = document.getElementById('email');
    const passwordField = document.getElementById('password');
    const nameError = document.getElementById('name-error');
    const emailError = document.getElementById('email-error');
    const passwordError = document.getElementById('password-error');

    // Real-time validation for email
    emailField.addEventListener('input', function () {
        const emailValue = emailField.value;
        const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
        
        if (emailRegex.test(emailValue)) {
            emailError.textContent = "Valid email format";
            emailError.style.color = "green";
        } else {
            emailError.textContent = "Invalid email format";
            emailError.style.color = "red";
        }
    });

    // Password strength check
    passwordField.addEventListener('input', function () {
        const passwordValue = passwordField.value;
        const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d@$!%*?&]{8,}$/;
        
        if (passwordRegex.test(passwordValue)) {
            passwordError.textContent = "Strong password";
            passwordError.style.color = "green";
        } else {
            passwordError.textContent = "Password must be at least 8 characters, and include at least one letter and one number.";
            passwordError.style.color = "red";
        }
    });

    // Submit event handler for form validation
    form.addEventListener('submit', function (e) {
        e.preventDefault();

        let valid = true;

        // Check for required name field
        if (nameField.value.trim() === "") {
            nameError.textContent = "Name is required";
            nameError.style.color = "red";
            valid = false;
        } else {
            nameError.textContent = "";
        }

        // Check for valid email format
        const emailValue = emailField.value;
        const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
        if (!emailRegex.test(emailValue)) {
            emailError.textContent = "Please enter a valid email";
            emailError.style.color = "red";
            valid = false;
        }

        // Check for valid password format
        const passwordValue = passwordField.value;
        const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d@$!%*?&]{8,}$/;
        if (!passwordRegex.test(passwordValue)) {
            passwordError.textContent = "Password must be at least 8 characters and include both letters and numbers";
            passwordError.style.color = "red";
            valid = false;
        }

        // If all fields are valid, submit the form
        if (valid) {
            alert("Registration successful!");
            form.reset();  // Reset the form after successful submission
        }
    });
});
