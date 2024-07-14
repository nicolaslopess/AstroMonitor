import React, { useState, useEffect } from 'react';
import { useStyles } from './styles';
import MenuLateral from '../../Componentes/MenuLateral';
import SolarSystem from '../../Componentes/Terra';
import Timer from '../../Componentes/Timer';
import NearbyObjectsCounter from '../../Componentes/ObjetosProximos';
import UpcomingApproachesList from '../../Componentes/ProximosObjetos';
import RecentActivityChart from '../../Componentes/AtividadeRecente';
import { Box, Grid, Button, Container } from '@material-ui/core';
import ProximosObjetos from '../../Componentes/ProximosObjetos';
import AtividadeRecente from '../../Componentes/AtividadeRecente';
import ObjetosProximos from '../../Componentes/ObjetosProximos';

const Dashboard = () => {
  const styles = useStyles();
  const [isSidebarOpen, setIsSidebarOpen] = useState(false);

  const toggleSidebar = () => {
    setIsSidebarOpen(!isSidebarOpen);
  };

  return (
    <Box className="dashboard" style={{ position: 'relative', height: '100vh', width: '100vw', overflow: 'hidden' }}>
      <Button
        className={`${styles.hamburgerBtn} ${isSidebarOpen ? styles.hide : ''}`}
        onClick={toggleSidebar}
        style={{ zIndex: 1000, position: 'absolute', pointerEvents: 'auto', color:"#fff" }}
      >
        ☰
      </Button>
      <MenuLateral isOpen={isSidebarOpen} toggleSidebar={toggleSidebar} />
      <SolarSystem />
      <Box className={styles.title}>
        <label style={{ fontSize: "1.5rem", WebkitUserSelect:"none" }}>Objetos Próximos à Terra</label>
      </Box>
      <Box className={styles.box}>
        <Grid container style={{ pointerEvents: 'none' }}>
          <Grid item xs={12} md={12} className={styles.boxes} style={{display:"flex", justifyContent:"flex-end"}}>
            <Box style={{ WebkitUserSelect:"none" }}>
              <Timer />
            </Box>
          </Grid>
          <Grid item xs={12} md={0} style={{marginTop:"-4%"}} className={styles.boxes}>
            <Box style={{ WebkitUserSelect:"none" }}>
              <ObjetosProximos count={42} />
            </Box>
          </Grid>
          <Grid item xs={12} md={0} className={styles.boxes}>
            <Box style={{WebkitUserSelect:"none" }}>
              <AtividadeRecente
                data={[
                  { time: '2023-07-01', count: 5 },
                  { time: '2023-07-02', count: 3 },
                ]}
              />
            </Box>
          </Grid>
          <Grid item xs={12} md={0} className={styles.boxes}>
            <Box style={{ pointerEvents: 'none', WebkitUserSelect:"none" }}>
              <ProximosObjetos
                approaches={[
                  { name: 'Objeto 1', date: '2023-07-10', distance: '5.6M km', risk: 'Baixo' },
                  { name: 'Objeto 2', date: '2023-07-15', distance: '7.2M km', risk: 'Médio' },
                ]}
                limit={5}
              />
            </Box>
          </Grid>
        </Grid>
      </Box>
    </Box>
  );
};

export default Dashboard;


