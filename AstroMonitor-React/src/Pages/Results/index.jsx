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
  
    const toggleSidebar = () => {
      setIsSidebarOpen(!isSidebarOpen);
    };
  
    const atualizarDados = async () => {
      setLoading(true);
      try {
        const response = await axios.get(`http://localhost:8080/api/planetario/recentes`); 
        setResultados(response.data);
      } catch (error) {
        console.error('Erro ao atualizar dados:', error);
      }
      setLoading(false);
    };
  
    return (
      <Container className={styles.container}>
        <MenuLateral isOpen={isSidebarOpen} toggleSidebar={toggleSidebar} />
        <Box style={{ flexGrow: 1, padding: 20 }}>
          <button className={`${styles.hamburgerBtn} ${isSidebarOpen ? styles.hide : ''}`} onClick={toggleSidebar} style={{ zIndex: 1000, position: 'absolute' ,color:"#000000",}}>
            ☰
          </button>
          <Box>
            <Box className={styles.title}>Resultados</Box>
            <Button variant="contained" color="primary" onClick={atualizarDados} disabled={loading}>
              {loading ? 'Atualizando...' : 'Atualizar Dados'}
            </Button>
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
                {resultados.map((resultado, index) => (
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
  
