// src/pages/ProviderDashboard.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';

function ProviderDashboard() {
  const [hotels, setHotels] = useState([]);
  const [error, setError] = useState(null);

  // Fields for adding a new hotel listing
  const [newHotelName, setNewHotelName] = useState('');
  const [newHotelLocation, setNewHotelLocation] = useState('');
  const [newHotelRating, setNewHotelRating] = useState('');

  // 1. Fetch existing hotel listings for the provider
  useEffect(() => {
    const token = localStorage.getItem('token');
    // Replace this URL with one that returns only the current provider's hotels.
    // For example, you might implement /api/hotels/provider to fetch hotels belonging to the logged-in provider.
    axios.get('http://localhost:8080/api/hotels', {
      headers: { Authorization: `Bearer ${token}` }
    })
    .then((response) => {
      setHotels(response.data);
    })
    .catch((err) => {
      console.error('Error fetching provider hotels:', err);
      setError('Unable to fetch hotels for this provider');
    });
  }, []);

  // 2. Add a new hotel listing
  const handleAddHotel = async (e) => {
    e.preventDefault();
    const token = localStorage.getItem('token');

    const hotelData = {
      name: newHotelName,
      location: newHotelLocation,
      rating: Number(newHotelRating),
      // The provider ID is usually set in the backend based on the authenticated user
    };

    try {
      const response = await axios.post('http://localhost:8080/api/hotels', hotelData, {
        headers: { Authorization: `Bearer ${token}` }
      });
      // Update local state to show the newly added hotel
      setHotels([...hotels, response.data]);
      // Reset form fields
      setNewHotelName('');
      setNewHotelLocation('');
      setNewHotelRating('');
    } catch (err) {
      console.error('Error adding new hotel:', err);
      setError('Failed to add hotel');
    }
  };

  // 3. Delete a hotel listing
  const handleDeleteHotel = async (hotelId) => {
    const token = localStorage.getItem('token');
    try {
      await axios.delete(`http://localhost:8080/api/hotels/${hotelId}`, {
        headers: { Authorization: `Bearer ${token}` }
      });
      // Remove the deleted hotel from state
      setHotels(hotels.filter((h) => h.id !== hotelId));
    } catch (err) {
      console.error('Error deleting hotel:', err);
      setError('Failed to delete hotel');
    }
  };

  return (
    <div>
      <h2>Provider Dashboard</h2>
      {error && <p style={{ color: 'red' }}>{error}</p>}

      <section style={{ marginBottom: '2rem' }}>
        <h3>Your Hotel Listings</h3>
        {hotels.length === 0 ? (
          <p>No hotels found for this provider.</p>
        ) : (
          <ul>
            {hotels.map((hotel) => (
              <li key={hotel.id}>
                <strong>{hotel.name}</strong> ({hotel.location}) - Rating: {hotel.rating ?? 'N/A'}
                <button
                  style={{ marginLeft: '1rem' }}
                  onClick={() => handleDeleteHotel(hotel.id)}
                >
                  Delete
                </button>
              </li>
            ))}
          </ul>
        )}
      </section>

      <section>
        <h3>Add a New Hotel</h3>
        <form onSubmit={handleAddHotel}>
          <div>
            <label>Name: </label>
            <input
              type="text"
              value={newHotelName}
              onChange={(e) => setNewHotelName(e.target.value)}
              required
            />
          </div>
          <div>
            <label>Location: </label>
            <input
              type="text"
              value={newHotelLocation}
              onChange={(e) => setNewHotelLocation(e.target.value)}
              required
            />
          </div>
          <div>
            <label>Rating: </label>
            <input
              type="number"
              step="0.1"
              value={newHotelRating}
              onChange={(e) => setNewHotelRating(e.target.value)}
            />
          </div>
          <button type="submit">Add Hotel</button>
        </form>
      </section>
    </div>
  );
}

export default ProviderDashboard;
