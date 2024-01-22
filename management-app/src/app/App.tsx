import './App.css';
import { Route, Routes } from 'react-router-dom';
import Home from 'components/Home/Home';
import Navbar from 'navigation/Navbar/Navbar';
import Invoicing from 'components/Invoicing/Invoicing';

const App = () => {
  return (
    <>
      <Navbar></Navbar>
      <Routes>
        <Route path="/invoicing" element={<Invoicing />} />
        <Route path="/" element={<Home />} />
      </Routes>
    </>
  );
};

export default App;
