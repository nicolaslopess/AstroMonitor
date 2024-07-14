import React, { useState, useEffect } from 'react';
import { Typography } from '@material-ui/core';

const Timer = () => {
  const [currentTime, setCurrentTime] = useState(new Date());

  useEffect(() => {
    const timer = setInterval(() => {
      setCurrentTime(new Date());
    }, 1000);

    return () => clearInterval(timer);
  }, []);

  return (
    <label style={{marginLeft:"5rem", fontSize:"1.5rem"}}>
      {currentTime.toLocaleString()}
    </label>
  );
};

export default Timer;
