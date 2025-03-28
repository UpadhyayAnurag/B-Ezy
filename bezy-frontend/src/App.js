// src/App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Login from './pages/Login';
import Registration from './pages/Registration';
import ConsumerDashboard from './pages/ConsumerDashboard';
import ProviderDashboard from './pages/ProviderDashboard';
import HotelDetails from './pages/HotelDetails';
import Navbar from './components/Navbar';

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Registration />} />
        <Route path="/consumer-dashboard" element={<ConsumerDashboard />} />
        <Route path="/provider-dashboard" element={<ProviderDashboard />} />
        <Route path="/hotels/:id" element={<HotelDetails />} />
        {/* More routes to be added */}
      </Routes>
    </Router>
  );
}

export default App;
