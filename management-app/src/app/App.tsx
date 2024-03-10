import './App.css';
import { Route, Routes } from 'react-router-dom';
import Home from 'components/Home/Home';
import Navbar from 'navigation/Navbar/Navbar';
import Invoicing from 'components/Invoicing/Invoicing';
import { Button } from '@mui/material';
import React from 'react';
import httpService from 'api/FireBase/httpService';
const App = () => {
  // Initialize Firebase
  interface prueba {
    nombre: string;
    apellido: string;
    numbero: number;
  }
  const submithandler = async (_e: React.MouseEvent<HTMLButtonElement>) => {
    const lista = await httpService.getAll<prueba>('Usuarios');
    console.log(
      'YO',
      await httpService.get<prueba>('Usuarios', '1jScesyp8arYV56dU3GE')
    );

    console.log('LISTA', lista);
  };

  return (
    <>
      <Navbar></Navbar>
      <Button onClick={submithandler}>CLICK</Button>
      <Routes>
        <Route path="/invoicing" element={<Invoicing />} />
        <Route path="/" element={<Home />} />
      </Routes>
    </>
  );
};

export default App;
