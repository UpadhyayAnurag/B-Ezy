// src/pages/ConsumerDashboard.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';

function ConsumerDashboard() {
  const [bookings, setBookings] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    const token = localStorage.getItem('token');
    axios.get('http://localhost:8080/api/bookings/search?status=PENDING', {
      headers: { Authorization: `Bearer ${token}` }
    })
    .then(res => {
      setBookings(res.data);
    })
    .catch(err => {
      console.error('Error fetching bookings:', err);
    });
  }, []);

  return (
    <div>
      <h2>Consumer Dashboard</h2>
      <h3>Your Pending Bookings</h3>
      <ul>
        {bookings.map(b => (
          <li key={b.id}>Booking #{b.id} - Service: {b.serviceType}</li>
        ))}
      </ul>
    </div>
  );
}

export default ConsumerDashboard;
