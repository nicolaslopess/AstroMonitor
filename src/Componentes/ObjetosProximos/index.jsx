import React from 'react';
import { Box } from '@material-ui/core';

const ObjetosProximos = ({ count }) => {
  return (
    <Box style={{ backgroundColor: 'transparent', pointerEvents: 'none' }}>
      <label style={{ fontSize: "1.5rem", color: 'white', pointerEvents: 'none' }}>Objetos Próximos Detectados:</label>
      <label style={{ color: 'white',fontSize:"1.5rem", pointerEvents: 'auto' }}>{count}</label>
    </Box>
  );
};

export default ObjetosProximos;
