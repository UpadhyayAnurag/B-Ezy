// src/pages/Registration.js
import React, { useState } from 'react';
import axios from 'axios';

function Registration() {
  const [isProvider, setIsProvider] = useState(false);
  const [formData, setFormData] = useState({
    username: '',
    email: '',
    password: '',
    companyName: '',
    serviceType: ''
  });
  const [error, setError] = useState(null);
  const [success, setSuccess] = useState(null);

  const handleChange = (e) => {
    setFormData((prev) => ({ ...prev, [e.target.name]: e.target.value }));
  };

  const handleRegister = async (e) => {
    e.preventDefault();
    try {
      const endpoint = isProvider
        ? 'http://localhost:8080/api/auth/register/provider'
        : 'http://localhost:8080/api/auth/register/consumer';
      await axios.post(endpoint, formData);
      setSuccess('Registration successful! Please log in.');
      setError(null);
    } catch (err) {
      setError(err.response?.data || 'Registration failed');
      setSuccess(null);
    }
  };

  return (
    <div>
      <h2>Register as {isProvider ? 'Provider' : 'Consumer'}</h2>
      <button onClick={() => setIsProvider(!isProvider)}>
        Switch to {isProvider ? 'Consumer' : 'Provider'} Registration
      </button>
      {error && <p style={{ color: 'red' }}>{error}</p>}
      {success && <p style={{ color: 'green' }}>{success}</p>}
      <form onSubmit={handleRegister}>
        {!isProvider && (
          <>
            <div>
              <label>Username</label>
              <input
                name="username"
                value={formData.username}
                onChange={handleChange}
                required
              />
            </div>
          </>
        )}
        {isProvider && (
          <>
            <div>
              <label>Company Name</label>
              <input
                name="companyName"
                value={formData.companyName}
                onChange={handleChange}
                required
              />
            </div>
            <div>
              <label>Service Type</label>
              <input
                name="serviceType"
                value={formData.serviceType}
                onChange={handleChange}
                required
              />
            </div>
          </>
        )}
        <div>
          <label>Email</label>
          <input
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Password</label>
          <input
            type="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            required
          />
        </div>
        <button type="submit">Register</button>
      </form>
    </div>
  );
}

export default Registration;
