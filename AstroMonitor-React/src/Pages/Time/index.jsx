import React, { useState } from 'react';
import { Box, Typography, List, ListItem, ListItemAvatar, ListItemText, Avatar, Container } from '@material-ui/core';
import MenuLateral from '../../Componentes/MenuLateral';
import { Email as EmailIcon, WhatsApp as WhatsAppIcon } from '@material-ui/icons';
import { useStyles } from './styles';
import larrisaImg from '../../Assets/LarissaImg.jpeg';
import nicolasImg from '../../Assets/NicolasImg.jpeg';
import ryanImg from '../../Assets/RyanImg.jpg';
import victorImg from '../../Assets/Victor.jpg';

const Time = () => {
  const styles = useStyles();
  const [isSidebarOpen, setIsSidebarOpen] = useState(true);

  const toggleSidebar = () => {
    setIsSidebarOpen(!isSidebarOpen);
  };

  const integrantes = [
    { nome: 'Larissa Joana Helfer', celular: '(51) 99570-6104', email: 'larissahelfer@mx2.unisc.br', semestre: 'Larissa tem um grande interesse em desenvolvimento web e design de interfaces. Ela gosta de trabalhar com React e tem experiência em criar interfaces de usuário intuitivas e eficientes', img: larrisaImg },
    { nome: 'Nicolas Lopes Redieske', celular: '(51) 99517-0299', email: 'nicolaslopes3@mx2.unisc.br', semestre: 'Nicolas é apaixonado por segurança da informação e redes. Ele está sempre atualizado com as últimas tendências em segurança cibernética e tem um bom entendimento de protocolos de rede e criptografia', img: nicolasImg },
    { nome: 'Ryan dos Reis Marques', celular: '(51) 99610-4130', email: 'ryanreis@mx2.unisc.br', semestre: 'Ryan tem um grande interesse em front-end, UI/UX e Work OSs, desenvolvendo soluções digitais para resolução de problemas.', img: ryanImg },
    { nome: 'Vitor Rafael Miorando', celular: '(51) 99502-4339', email: 'miorando1@mx2.unisc.br', semestre: 'Gosto de computação porque adoro programar e resolver problemas. Também curto explorar novas tecnologias e aprender coisas novas. Ver um código funcionar depois de muito esforço é muito satisfatório.', img: victorImg },
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
                  <Avatar alt={integrante.nome} src={integrante.img} style={{ marginRight:10, width: 100, height: 100, fontSize: 18 }} />
                </ListItemAvatar>
                <ListItemText
                  primary={integrante.nome}
                  secondary={
                    <>
                      <label component="span" variant="body2" color="textPrimary">
                        {integrante.semestre}
                      </label>
                      <Box style={{display:"flex", marginTop: 10}} alignItems="center" mt={1}>
                        <WhatsAppIcon fontSize="small" style={{color:"green"}} />
                        <label style={{ marginLeft: 8 }}>
                          {integrante.celular}
                        </label>
                      </Box>
                      <Box style={{display:"flex", marginTop:5}} alignItems="center" mt={1}>
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
