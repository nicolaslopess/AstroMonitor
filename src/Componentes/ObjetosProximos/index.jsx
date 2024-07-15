import React, { useEffect, useState } from 'react';
import { Box } from '@material-ui/core';
import axios from 'axios';

const ObjetosProximos = ({ count }) => {
  const [object, setObject] = useState(0);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/planetario/proximos');
        if (response && response.data) {
          setObject(response.data);
        }
      } catch (error) {
        console.error('Erro ao buscar dados:', error);
      }
    };

    fetchData();
  }, []);


  return (
    <Box style={{ backgroundColor: 'transparent', pointerEvents: 'none' }}>
      <label style={{ fontSize: "1.5rem", color: 'white', pointerEvents: 'none' }}>Objetos Próximos Detectados:</label>
      <label style={{ color: 'white', fontSize: "1.5rem", pointerEvents: 'auto' }}> {object}</label>
    </Box>
  );
};

export default ObjetosProximos;
