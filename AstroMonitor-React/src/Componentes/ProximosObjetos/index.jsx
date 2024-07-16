import React, { useEffect, useState } from 'react';
import { Box, Typography } from '@material-ui/core';
import axios from 'axios';
import { useStyles } from './styles';

const ProximosObjetos = ({ limit = 5 }) => {
  const styles = useStyles();
  const [data, setData] = useState([]);
  const [error, setError] = useState('');

  const formatDate = (date) => {
    const d = new Date(date);
    const month = `${d.getMonth() + 1}`.padStart(2, '0');
    const day = `${d.getDate()}`.padStart(2, '0');
    const year = d.getFullYear();
    return `${year}-${month}-${day}`;
  };

  useEffect(() => {
    const fetchData = async () => {
      const today = new Date();
      const yesterday = new Date(today);
      yesterday.setDate(today.getDate() - 1);
  
      const dataInicio = yesterday.toISOString().split('T')[0];
      const dataFim = today.toISOString().split('T')[0];  
      let token = localStorage.getItem('authToken');
  
      if (!token) {
        setError('Token inválido');
        return;
      }
  
      token = token.trim();
      if (!token.startsWith('Bearer ')) {
        token = `Bearer ${token}`;
      }
  
      try {
        const response = await axios.get(`http://localhost:8080/api/planetario/futuras`, {          
        });
  
        const fetchedData = response.data.map(item => ({
          name: item.nomeAsteroid,
          date: new Date(item.dataAproximacao).toLocaleDateString(),
          distance: (item.distanciaDaTerra / 1e6).toFixed(2) + ' M km',
          risk: item.risco ? 'Sim' : 'Não'
        }));
  
        setData(fetchedData);
      } catch (error) {
        console.error('Erro ao buscar dados:', error);
        setError('Erro ao buscar dados.');
      }
    };
  
    fetchData();
  }, []);
  

  const limiteProximo = data.slice(0, limit);

  return (
    <Box style={{ backgroundColor: 'transparent' }}>
      <label className={styles.title}>Próximas Aproximações:</label>
      <Box>
        <Box className={styles.block} style={{ marginTop: 20 }}>
          <label className={styles.tableLabelsHeader} style={{ width: "15%" }}>Nome</label>
          <label className={styles.tableLabelsHeader} style={{ width: "10%" }}>Data</label>
          <label className={styles.tableLabelsHeader} style={{ width: "12%" }}>Distância</label>
          <label className={styles.tableLabelsHeader} style={{ width: "15%" }}>Risco</label>
        </Box>
        {limiteProximo.map((e, index) => (
          <Box key={index} className={styles.tableInfo} >
            <label className={styles.tableLabels} style={{ width: "15%" }}>{e.name}</label>
            <label className={styles.tableLabels} style={{ width: "10%" }}>{e.date}</label>
            <label className={styles.tableLabels} style={{ width: "12%" }}>{e.distance}</label>
            <label className={styles.tableLabels} style={{ width: "15%" }}>{e.risk}</label>
          </Box>
        ))}
      </Box>
    </Box>
  );
};

export default ProximosObjetos;
