
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

import carc1 from '../Images/carc1.jpg';
import carc2 from '../Images/carc2.jpg';
import carc3 from '../Images/carc3.jpg';
import carc4 from '../Images/carc4.jpg';
import carc5 from '../Images/carc5.jpg';

function Home() {
const stylesIMG={width:"100%",height:"100%"};

  return (
    <div className="home-page">
   
    <div className='carousel-container'>
      <Carousel
        showThumbs={false}
        autoPlay={true}
        infiniteLoop={true}
        showStatus={false}
        interval={1000}
       >
        <div>
          <img style={stylesIMG} src={car1} alt="Car 1" />
        </div>
        <div>
          <img style={stylesIMG} src={car2} alt="Car 2" />
        </div>
        <div>
          <img style={stylesIMG} src={car3} alt="Car 3" />
        </div>
        <div>
          <img style={stylesIMG} src={car4} alt="Car 4" />
        </div>
       

       <div>
          <img style={stylesIMG} src={carc1} alt="Car 1" /> 
        </div>
        <div>
          <img style={stylesIMG} src={carc2} alt="Car 2" />
        </div>
        <div>
          <img style={stylesIMG} src={carc3} alt="Car 3" />  
        </div>
        <div>
          <img style={stylesIMG} src={carc4} alt="Car 4" />         
        </div>
        <div>
          <img style={stylesIMG} src={carc5} alt="Car 5" />
         </div>
      </Carousel>
     
     <div className='homeBTN'>
      <button><Link to="/signin">Start Custom Order</Link></button>
      </div>
      </div>
    </div>
  
  );
}


export default Home;
