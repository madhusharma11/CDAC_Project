
import React from 'react';
import { Carousel } from 'react-responsive-carousel';
import { Link } from 'react-router-dom';
import '../styles/Home.css';
import 'react-responsive-carousel/lib/styles/carousel.min.css';

// Import your car images
import car1 from '../Images/car1.jpg';
import car2 from '../Images/car2.jpg';
import car3 from '../Images/car3.jpg';
import car4 from '../Images/car4.jpg';
import car5 from '../Images/car5.jpg';

function Home() {
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
          <img src={car1} alt="Car 1" />
          
        </div>
        <div>
          <img src={car2} alt="Car 2" />
          
        </div>
        <div>
          <img src={car3} alt="Car 3" />
          
        </div>
        <div>
          <img src={car4} alt="Car 4" />
          
        </div>
        <div>
          <img src={car5} alt="Car 5" />
        </div>
      </Carousel>
      
    </div>
    
  );
}


export default Home;
