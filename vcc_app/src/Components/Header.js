import React from 'react';
import '../styles/Header.css'; // Ensure you have a CSS file for styling
import Navbar from './Navbar';
import logo from '../Images/logo.png'; // Import the logo image
import searchIcon from '../Images/searchlogo.png';

/*
function Header() {
  return (
    <header>
      <h2>Vehicle Craft Customization</h2>
      <Navbar />
    </header>
  );
}
*/


export default function Header() {
  return (
    <header className="header">
      <div className="header-content">
        <img src={logo} alt="Vehicle Craft Customization Logo" className="logo" />
        <h8 className="site-title">Vehicle Craft Customization</h8>
      </div>

      {/* <div>
      <Navbar />
      </div> */}
      
      <div className="navbar-container">
          <Navbar />
          <button className="search-button">
            <img src={searchIcon} alt="Search" className="search-icon" />
          </button>
          {/* <div className="search-container">
          <input type="text" placeholder="Search" className="search-input" /> 
        </div> */}
      </div>
      
    </header>
  );
}






// src/components/Header.js
// import React from 'react';
// import Navbar from './Navbar';

// function Header() {
//   return (
//     <header>
//       <h3>Vehicle Craft Customization</h3>
//       <Navbar />
//     </header>
//   );
// }

// export default Header;
