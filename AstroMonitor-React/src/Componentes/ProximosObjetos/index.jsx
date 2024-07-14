import React from 'react';
import { Box } from '@material-ui/core';
import { useStyles } from './styles';

const ProximosObjetos = ({ approaches, limit = 5 }) => {
  const styles = useStyles();
  const limitedApproaches = approaches.slice(0, limit);

  return (
    <Box style={{ backgroundColor: 'transparent' }}>
      <label className={styles.title}>Próximas Aproximações:</label>
      <Box>
        <Box className={styles.block} style={{ marginTop: 20 }}>
          <label className={styles.tableLabelsHeader} style={{ width: "10%" }}>Nome</label>
          <label className={styles.tableLabelsHeader} style={{ width: "10%" }}>Data</label>
          <label className={styles.tableLabelsHeader} style={{ width: "12%" }}>Distância</label>
          <label className={styles.tableLabelsHeader} style={{ width: "15%" }}>Risco</label></Box>
        {limitedApproaches.map((e, index) => (
          <Box key={index} className={styles.tableInfo} >
            <label className={styles.tableLabels} style={{ width: "10%" }}>{e.name}</label>
            <label className={styles.tableLabels} style={{ width: "10%" }}>{e.date}</label>
            <label className={styles.tableLabels} style={{ width: "12%" }}>{e.distance}</label>
            <label className={styles.tableLabels} style={{ width: "15%" }}>{e.risk}</label></Box>
        ))}
      </Box>
    </Box>
  );
};

export default ProximosObjetos;
