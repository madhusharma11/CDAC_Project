import React, { useState } from 'react';
import axios from 'axios';
import '../styles/SignUp.css';
import '../styles/background.css';

import { Link, Navigate, useNavigate } from 'react-router-dom';
import * as utils from './Util.js'; 


function SignIn() {
  const navigate=useNavigate();
  const[reqmsg,setReqMsg]=useState('');
  const [formData, setFormData] = useState({
    email: '',
    password: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
      setFormData({ ...formData, [name]: value });
  };

 

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/users/signin', formData);
      console.log('User logedin successfully:', response.data);
      setReqMsg('User successfully login');
      utils.setSession(response.data);
      navigate("/category");
      window.location.reload();

    } catch (error) {
      console.error('login failed:', error);
      setReqMsg('User not registered please register');
<span color='red'>{reqmsg}</span>
      navigate("/signup");
    }
  };

  

  return (
    <div className="signup-page page">
      <h3>SignIn !! </h3>
      <form onSubmit={handleSubmit} className="signup-form">
        
       
        <div className="form-group">
          <label htmlFor="email">Email</label>
          <input
            type="email"
            id="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="password">Password</label>
          <input
            type="password"
            id="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            required
            
          />
        </div>
       
        <button type="submit">SignIn</button><br></br>
       
      </form>
      
      <button ><Link to="/signup">Register</Link></button>
    </div>
  );
}

export default SignIn;
