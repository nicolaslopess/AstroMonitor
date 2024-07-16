import React, { useState, useEffect } from 'react';
import { Box, Button, Typography, Table, TableBody, TableCell, TableHead, TableRow, Container } from '@material-ui/core';
import axios from 'axios';
import { useStyles } from './styles';
import MenuLateral from '../../Componentes/MenuLateral';

const Results = () => {
  const styles = useStyles();
  const [resultados, setResultados] = useState([]);
  const [loading, setLoading] = useState(false);
  const [isSidebarOpen, setIsSidebarOpen] = useState(true);
  const [riskFilter, setRiskFilter] = useState('Todos');

  const toggleSidebar = () => {
    setIsSidebarOpen(!isSidebarOpen);
  };

  const handleFilterRisco = (event) => {
    setRiskFilter(event.target.value);
  };

  const filteredResults = resultados.filter(item => {
    if (riskFilter === 'Todos') return true;
    return riskFilter === 'Sim' ? item.risk === 'Sim' : item.risk === 'Não';
  });

  const atualizarDados = async () => {
    setLoading(true);
    try {
      const diaAtual = new Date();
      const diaAnterior = new Date(diaAtual);
      diaAnterior.setDate(diaAtual.getDate() - 5);

      const dataInicio = diaAnterior.toISOString().split('T')[0];
      const dataFim = diaAtual.toISOString().split('T')[0];
      let token = localStorage.getItem('authToken');

      if (!token) {
        return;
      }

      token = token.trim();
      if (!token.startsWith('Bearer ')) {
        token = `Bearer ${token}`;
      }
      const response = await axios.get(`http://localhost:8080/api/recurso/nasa?dateinicio=${dataInicio}&datefim=${dataFim}`, {
        headers: {
          'Authorization': token
        }
      });

      if (response.status == 200) {
        const responseResults = await axios.get(`http://localhost:8080/api/planetario/futuras`, {
        });

        const fetchedData = responseResults.data.map(item => ({
          name: item.nomeAsteroid,
          date: new Date(item.dataAproximacao).toLocaleDateString(),
          distance: (item.distanciaDaTerra / 1e6).toFixed(2) + ' M km',
          risk: item.risco ? 'Sim' : 'Não'
        }));

        setResultados(fetchedData);
      }
    } catch (error) {
      console.error('Erro ao atualizar dados:', error);
    }
    setLoading(false);
  };

  return (
    <Container className={styles.container}>
      <MenuLateral isOpen={isSidebarOpen} toggleSidebar={toggleSidebar} />
      <Box style={{ flexGrow: 1, padding: 20 }}>
        <button className={`${styles.hamburgerBtn} ${isSidebarOpen ? styles.hide : ''}`} onClick={toggleSidebar} style={{ zIndex: 1000, position: 'absolute', color: "#000000", }}>
          ☰
        </button>
        <Box>
          <Box className={styles.title}>Resultados</Box>
          <Button variant="contained" color="primary" onClick={atualizarDados} disabled={loading}>
            {loading ? 'Atualizando...' : 'Atualizar Dados'}
          </Button>
          <select value={riskFilter} onChange={handleFilterRisco} style={{outline: 0, height: 35, width: 120, borderRadius: 8, cursor: "pointer", marginLeft:"2rem"}}>
            <option value="Todos">Todos</option>
            <option value="Sim">Risco</option>
            <option value="Nao">Sem Risco</option>
          </select>
          <Table>
            <TableHead>
              <TableRow>
                <TableCell>Nome</TableCell>
                <TableCell>Data</TableCell>
                <TableCell>Distância</TableCell>
                <TableCell>Risco</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {filteredResults.map((resultado, index) => (
                <TableRow key={index}>
                  <TableCell>{resultado.name}</TableCell>
                  <TableCell>{resultado.date}</TableCell>
                  <TableCell>{resultado.distance}</TableCell>
                  <TableCell>{resultado.risk}</TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </Box>
      </Box>
    </Container>
  );
};

export default Results;

