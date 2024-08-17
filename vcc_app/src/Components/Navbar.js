// src/components/Navbar.js
import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import * as utils from '../Pages/Util.js';

function Navbar() {
const[user,setUser]=useState();
  
useEffect(()=>{
  var user = utils.getUserInfo();
  setUser(user);
  console.log("user: "+user);
});

  return (
    <nav>
      <ul>
        <li><Link to="/">HOME</Link></li>
        <li><Link to="/about">ABOUT US</Link></li>
        <li><Link to="/contact">CONTACT US</Link></li>
        <li><Link to="/help">HELP</Link></li>

        {user?
        <li><Link to="/logout">LOGOUT</Link></li>:""}
        {user?
        <li><Link to="/orderList">ORDERS</Link></li>:""
        }
       
      </ul>
    </nav>
  );
}

export default Navbar;
