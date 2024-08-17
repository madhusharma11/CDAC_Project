import logo from './logo.svg';
import './App.css';
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Header from './Components/Header';
import Footer from './Components/Footer';
import Home from './Pages/Home';
import ContactUs from './Pages/ContactUs';
import AboutUs from './Pages/AboutUs';
import SignUp from './Pages/SignUp';
import SignIn from './Pages/SignIn';
import Category from './Pages/Category';
import Help from './Pages/Help';
import OrderDetails from './Pages/OrderDetails';
import Logout from './Pages/Logout';
import Orders from './Pages/Orders';

function App() {
  return (
    <Router>
      <Header />
      <div className="content">
        <Routes>
          <Route path="/" element={<Home/>} />
          <Route path="/contact" element={<ContactUs/>} />
          <Route path="/about" element={<AboutUs/>} />
          <Route path="/signup" element={<SignUp/>} />
          <Route path='/signin' element={<SignIn/>}/>
          <Route path='/category' element={<Category/>}/>
          <Route path='/help' element={<Help/>}/>
          <Route path='/orderdetails' element={<OrderDetails/>}/>
          <Route path='/logout' element={<Logout/>}/>
          <Route path='/orderList' element={<Orders/>}/>
        </Routes>
      </div>
      <Footer />
    </Router>
  );
}

export default App;
