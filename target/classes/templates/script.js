document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.getElementById('loginForm');
    const signupForm = document.getElementById('signupForm');

    loginForm.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent form submission

        const formData = new FormData(loginForm);
        const userData = {
            username: formData.get('username'),
            password: formData.get('password')
        };

        // Assuming you're sending the login request to a backend endpoint using fetch API
        fetch('/api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        })
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error('Login failed');
                }
            })
            .then(data => {
                // Handle successful login (redirect, show success message, etc.)
                console.log('Login successful:', data);
            })
            .catch(error => {
                // Handle login error (display error message, reset form, etc.)
                console.error('Login error:', error);
            });
    });

    signupForm.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent form submission

        const formData = new FormData(signupForm);
        const userData = {
            username: formData.get('username'),
            password: formData.get('password')
        };

        // Assuming you're sending the signup request to a backend endpoint using fetch API
        fetch('/api/signup', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        })
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error('Signup failed');
                }
            })
            .then(data => {
                // Handle successful signup (redirect, show success message, etc.)
                console.log('Signup successful:', data);
            })
            .catch(error => {
                // Handle signup error (display error message, reset form, etc.)
                console.error('Signup error:', error);
            });
    });
});
