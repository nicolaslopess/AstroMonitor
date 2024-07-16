import axios from 'axios';
import { error_message } from '../Componentes/Toast';

const Api = axios.create({
  baseURL: 'http://localhost:8080/api',
  headers: {
    'Content-Type': 'application/json'
  }
});

Api.interceptors.request.use(
  config => {
    const token = localStorage.getItem('authToken');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    console.log('Interceptador de requisição - Configuração:', config); // Log para verificar a configuração da requisição
    return config;
  },
  error => {
    return Promise.reject(error);
  }
);

Api.interceptors.response.use(
  response => response,
  error => {
    if (error.response) {
      console.error('Erro de resposta da API:', error.response); // Log para verificar o erro de resposta
    }
    return Promise.reject(error);
  }
);

export const exceptionNotificationAPI = (error) => {
  if (/500/.test(error.message)) {
    error_message('Failed to connect Web Service (500).');
  } else if (/404/.test(error.message)) {
    error_message(error.message);
  } else if (/400/.test(error.message)) {
    let notifications = error.response.data.notifications;
    if (notifications && notifications.length > 0) {
      notifications.forEach((not) => {
        error_message(not.message);
      });
    }
  } else {
    error_message(error.message);
  }
};

export default Api;
