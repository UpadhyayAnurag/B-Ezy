// src/components/Navbar.js
import React from 'react';
import { Link } from 'react-router-dom';

function Navbar() {
  return (
    <nav style={{ backgroundColor: '#eee', padding: '1rem' }}>
      <ul style={{ listStyle: 'none', display: 'flex', gap: '1rem' }}>
        <li><Link to="/">Home</Link></li>
        <li><Link to="/login">Login</Link></li>
        <li><Link to="/register">Register</Link></li>
        <li><Link to="/consumer-dashboard">Consumer Dashboard</Link></li>
        <li><Link to="/provider-dashboard">Provider Dashboard</Link></li>
      </ul>
    </nav>
  );
}

export default Navbar;
