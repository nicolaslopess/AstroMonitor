import React from 'react';
import { Typography, Box } from '@material-ui/core';

const AtividadeRecente = ({ data }) => {
  const svgHeight = 200;
  const svgWidth = 300;
  const padding = 40; 

  const maxX = data.length - 1;
  const maxY = Math.max(...data.map(d => d.count));
  const scaleX = (index) => padding + (index / maxX) * (svgWidth - 2 * padding);
  const scaleY = (count) => svgHeight - padding - (count / maxY) * (svgHeight - 2 * padding);

  return (
    <Box>
      <Typography variant="h5">Atividades Recentes:</Typography>
      <Box style={{ height: svgHeight, width: svgWidth }}>
        <svg width="100%" height="100%">
          <line x1={padding} y1={padding} x2={padding} y2={svgHeight - padding} stroke="white" strokeWidth="2" />
          <line x1={padding} y1={svgHeight - padding} x2={svgWidth - padding} y2={svgHeight - padding} stroke="white" strokeWidth="2" />
          <polyline
            fill="none"
            stroke="white"
            strokeWidth="2"
            points={data.map((d, i) => `${scaleX(i)},${scaleY(d.count)}`).join(' ')}
          />
          {data.map((d, i) => (
            <text x={scaleX(i) - 10} y={svgHeight - padding + 20} fill="white" fontSize="12" key={i}>
              {d.time}
            </text>
          ))}
          {Array.from({ length: 5 }).map((_, index) => (
            <text x={5} y={scaleY(index * (maxY / 4)) + 5} fill="white" fontSize="12" key={index}>
              {Math.round(index * (maxY / 4))}
            </text>
          ))}
        </svg>
      </Box>
    </Box>
  );
};

export default AtividadeRecente;
