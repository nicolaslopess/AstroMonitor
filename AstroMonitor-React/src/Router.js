import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Dashboard from './Pages/Dashboard';
import Results from './Pages/Results';
import Time from './Pages/Time';
import TelaLogin from './Pages/TelaLogin';
import { PrivateRoute } from './PrivateRouter';
import NovoUsuario from './Componentes/NovoUsuario';

const AppRouter = () => {
  return (
    <Router>
      <Routes>
        <Route path="/login" element={<TelaLogin />} />
        <Route path="/registro" element={<NovoUsuario />} />
        <Route path="/" element={<Dashboard />} />
        <Route path="/dados" element={<Results />} />
        <Route path="/sobre" element={<Time />} />
      </Routes>
    </Router>
  );
};

export default AppRouter;
