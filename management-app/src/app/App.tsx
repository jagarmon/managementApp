import './App.css';
import { Route, Routes } from 'react-router-dom';
import Home from 'components/Home/Home';
import Navbar from 'navigation/Navbar/Navbar';

const App = () => {
  return (
    <>
      <Navbar></Navbar>
      <Routes>
        <Route path="/" element={<Home />} />
      </Routes>
    </>
  );
};

export default App;
