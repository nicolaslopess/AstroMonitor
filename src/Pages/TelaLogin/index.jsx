import React, { useState } from 'react';
import { Box, Button, Typography, Container, TextField, CircularProgress } from '@material-ui/core';
import Api, { exceptionNotificationAPI } from '../../Api';
import { useNavigate } from 'react-router-dom';
import { useStyles } from './styles';
import Senha from '../../Componentes/Senha';

const TelaLogin = () => {
  const styles = useStyles();
  const navigate = useNavigate();
  const [loading, setLoading] = useState(false);
  const [usuario, setUsuario] = useState('');
  const [senha, setSenha] = useState('');
  const [error, setError] = useState('');

  const handleInputChange = (field, value) => {
    switch (field) {
      case 'usuario':
        setUsuario(value);
        break;
      case 'senha':
        setSenha(value);
        break;
      default:
        break;
    }
    setError('');
  };

  const fazerLogin = async () => {
    if (!usuario || !senha) {
      setError('Por favor, preencha todos os campos necessários.');
      return;
    }

    setLoading(true);
    try {
      const data = {
        login: usuario,
        senha: senha
      }
      const response = await Api.post(`/login`, data);
      console.log('Login bem-sucedido:', response.data);
      navigate('/');
    } catch (error) {
      exceptionNotificationAPI(error);
    }
    setLoading(false);
  };

  const registrarUsuario = () => {
    navigate('/registro');
  };

  return (
    <Container className={styles.container} maxWidth="xs">
      <Box style={{ padding: 20, color: "#000000" }}>
        <Typography variant="h4" gutterBottom>Login</Typography>
        <TextField
          label="Nome de Usuário"
          variant="outlined"
          fullWidth
          value={usuario}
          onChange={(e) => handleInputChange('usuario', e.target.value)}
          margin="normal"
        />
        <Senha
          value={senha}
          onChange={(e) => handleInputChange('senha', e.target.value)}
        />
        <Button
          variant="contained"
          color="primary"
          onClick={fazerLogin}
          disabled={loading}
          fullWidth
          style={{ marginTop: 16 }}
        >
          {loading ? <CircularProgress size={24} /> : 'Entrar'}
        </Button>
        <Button
          variant="text"
          onClick={registrarUsuario}
          fullWidth
          style={{ marginTop: 8 }}
        >
          Não possui uma conta? Cadastra-se aqui
        </Button>
      </Box>
    </Container>
  );
};

export default TelaLogin;
