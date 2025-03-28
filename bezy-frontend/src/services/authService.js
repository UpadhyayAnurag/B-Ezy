import axios from 'axios';

const API_URL = 'http://localhost:8080/api/auth';

export const login = (username, password) => {
  return axios.post(`${API_URL}/login`, { username, password });
};

export const registerConsumer = (consumerData) => {
  return axios.post(`${API_URL}/register/consumer`, consumerData);
};

export const registerProvider = (providerData) => {
  return axios.post(`${API_URL}/register/provider`, providerData);
};
