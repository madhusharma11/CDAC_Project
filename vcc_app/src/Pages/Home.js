
import React from 'react';
import { Carousel } from 'react-responsive-carousel';
import { Link } from 'react-router-dom';
import '../styles/Home.css';
import 'react-responsive-carousel/lib/styles/carousel.min.css';

// Import your car images

import car4 from '../Images/car4.jpg';
import car5 from '../Images/car5.jpg';

function Home() {
const stylesIMG={width:"100%",height:"100%"};

  return (
    <div className="home-page">
      <div >
      <button><Link to="/signin">Start Custom Order</Link></button>
      <br /><br />
      </div>
     <Carousel
        showThumbs={false}
        autoPlay={true}
        infiniteLoop={true}
        showStatus={false}
        interval={1000}
      >
        
        <div>
          <img style={stylesIMG} src={car4} alt="Car 4" />
          
        </div>
        <div>
          <img style={stylesIMG} src={car5} alt="Car 5" />
        </div>
      </Carousel>
      
    </div>
    
  );
}


export default Home;
