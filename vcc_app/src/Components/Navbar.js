// src/components/Navbar.js
import React from 'react';
import { Link } from 'react-router-dom';

function Navbar() {
  return (
    <nav>
      <ul>
        <li><Link to="/">Home</Link></li>
        <li><Link to="/about">About Us</Link></li>
        <li><Link to="/contact">Contact Us</Link></li>
        <li><Link to="/help">Help</Link></li>
        <li><Link to="/logout">Logout</Link></li>
        {/* <li><Link to="/signup">Signup</Link></li>
        <li><Link to="/signin">SignIn</Link></li> */}
        {/* <li><Link to="/search">Search</Link></li> */}
      </ul>
    </nav>
  );
}

export default Navbar;
