import React from 'react';
import { Drawer, List, ListItem, ListItemText } from '@material-ui/core';
import { useNavigate } from 'react-router-dom';

const MenuLateral = ({ isOpen, toggleSidebar }) => {
  const navigate = useNavigate();

  const handleNavigate = (path) => {
    toggleSidebar();
    navigate(path);
  };

  const handleLogout = () => {
    localStorage.removeItem('authToken');
    toggleSidebar();
    navigate('/login');
  };

  return (
    <Drawer anchor="left" open={isOpen} onClose={toggleSidebar}>
      <List>
        <ListItem button onClick={() => handleNavigate('/')}>
          <ListItemText primary="Dashboard" />
        </ListItem>
        <ListItem button onClick={() => handleNavigate('/dados')}>
          <ListItemText primary="Dados" />
        </ListItem>        
        <ListItem button onClick={() => handleNavigate('/sobre')}>
          <ListItemText primary="Sobre" />
        </ListItem>
        <ListItem button onClick={handleLogout}>
          <ListItemText primary="Sair" />
        </ListItem>
      </List>
    </Drawer>
  );
};

export default MenuLateral;
