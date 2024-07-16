import React, { useState } from 'react';
import { Box, Typography, List, ListItem, ListItemAvatar, ListItemText, Avatar, Container } from '@material-ui/core';
import MenuLateral from '../../Componentes/MenuLateral';
import { Email as EmailIcon, WhatsApp as WhatsAppIcon } from '@material-ui/icons';
import { useStyles } from './styles';
import anaImg from '../../Assets/Ana.webp';
import carlosImg from '../../Assets/Carlos.webp';
import matheusImg from '../../Assets/Matheus.webp';
import rafaelImg from '../../Assets/Rafael.webp';

const Time = () => {
  const styles = useStyles();
  const [isSidebarOpen, setIsSidebarOpen] = useState(true);

  const toggleSidebar = () => {
    setIsSidebarOpen(!isSidebarOpen);
  };

  const integrantes = [
    { nome: 'Larissa Helfer', celular: '(51) 99773-6700', email: 'ana87S@hotmail.com.br', semestre: 'Apaixonada por melhorar a usabilidade e acessibilidade dos produtos digitais. Dedica-se a participar de workshops sobre UX e design inclusivo', img: anaImg },
    { nome: 'Nicolas Redieske', celular: '(51) 99812-1239', email: 'carlos_12@gmail.com', semestre: 'Focado em aprender mais sobre arquiteturas de microserviços e segurança cibernética.', img: carlosImg },
    { nome: 'Ryan Marques', celular: '(51) 99165-9752', email: 'matGomes@hotmail.com.br', semestre: 'Interessado em expandir suas habilidades em automação de testes e inteligência artificial aplicada a testes.', img: matheusImg },
    { nome: 'Victor Miorando', celular: '(51) 99242-1753', email: 'rafaNunes11@gmail.com', semestre: 'Explorar novas tendências em animação e design gráfico. Interessado em tecnologias de realidade aumentada.', img: rafaelImg },
  ];

  return (
    <Container className={styles.container}>
      <MenuLateral isOpen={isSidebarOpen} toggleSidebar={toggleSidebar} />
      <Box style={{ flexGrow: 1, padding: 20, color: "#000000" }}>
        <button className={`${styles.hamburgerBtn} ${isSidebarOpen ? styles.hide : ''}`} onClick={toggleSidebar} style={{ zIndex: 1000, position: 'absolute', color: "#000000" }}>
          ☰
        </button>
        <Box>
          <Box className={styles.title}>Sobre</Box>
          <label className={styles.label}>
            O AstroMonitor é um aplicativo com o frontend desenvolvido em React e o backend em Java, que utiliza a API de Objetos Próximos à Terra da NASA
            (NEO - Near Earth Objects) para monitorar e analisar asteroides e cometas que passam perto da Terra. O sistema realiza chamadas à API para coletar
            dados sobre esses objetos, como tamanho, velocidade, distância da Terra e potencial perigo, e apresenta os resultados através de uma interface gráfica.
          </label>
        </Box>
        <Box>
          <Box className={styles.title} style={{ marginTop: 20 }}>Sobre os desenvolvedores</Box>
          <List>
            {integrantes.map((integrante, index) => (
              <ListItem key={index} alignItems="flex-start">
                <ListItemAvatar>
                  <Avatar alt={integrante.nome} src={integrante.img} style={{ marginRight: 10, width: 100, height: 100, fontSize: 18 }} />
                </ListItemAvatar>
                <ListItemText
                  primary={integrante.nome}
                  secondary={
                    <>
                      <label component="span" variant="body2" color="textPrimary">
                        {integrante.semestre}
                      </label>
                      <Box style={{ display: "flex", marginTop: 10 }} alignItems="center" mt={1}>
                        <WhatsAppIcon fontSize="small" style={{ color: "green" }} />
                        <label style={{ marginLeft: 8 }}>
                          {integrante.celular}
                        </label>
                      </Box>
                      <Box style={{ display: "flex", marginTop: 5 }} alignItems="center" mt={1}>
                        <EmailIcon fontSize="small" />
                        <label style={{ marginLeft: 8 }}>
                          {integrante.email}
                        </label>
                      </Box>
                    </>
                  }
                />
              </ListItem>
            ))}
          </List>
        </Box>
      </Box>
    </Container>
  );
};

export default Time;
