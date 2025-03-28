// src/pages/HotelDetails.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

function HotelDetails() {
  const { id } = useParams();
  const [hotel, setHotel] = useState(null);

  useEffect(() => {
    axios.get(`http://localhost:8080/api/hotels/${id}`)
      .then(res => setHotel(res.data))
      .catch(err => console.error('Error fetching hotel details:', err));
  }, [id]);

  if (!hotel) {
    return <p>Loading hotel details...</p>;
  }

  return (
    <div>
      <h2>{hotel.name}</h2>
      <p>Location: {hotel.location}</p>
      <p>Rating: {hotel.rating}</p>
      {/* Display rooms or other info */}
    </div>
  );
}

export default HotelDetails;
