import React, { useState } from 'react';
import axios from 'axios';
import '../styles/SignUp.css';
import { Link } from 'react-router-dom';

function Signup() {
  const[reqmsg,setReqMsg]=useState('');
  const[registerStatus,setRegisterStatus]=useState(false);
  const [formData, setFormData] = useState({
    firstname: '',
    lastname: '',
    email: '',
    password: '',
    contact: '',
    role: 'CUSTOMER', 
    chosenAddress: {
      adrLine1: '',
      adrLine2: '',
      city: '',
      state: '',
      country: '',
      zipCode: ''
    }
  });

  const handleChange = (e) => {
    const { name, value } = e.target;

    if (name.startsWith('chosenAddress')) {
      const addressField = name.split('.')[1];
      setFormData({
        ...formData,
        chosenAddress: {
          ...formData.chosenAddress,
          [addressField]: value
        }
      });
    } else {
      setFormData({ ...formData, [name]: value });
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/users/register', formData);
      console.log('User registered successfully:plz login', response.data);
     setReqMsg('User registered successfully:plz login');
     setRegisterStatus(true);
      // redirect to login
    } catch (error) {
      console.error('error registering the user:', error);
    }
  };

  return (
    <div className="signup-page page">
      <h3>Register !! </h3>
      <form onSubmit={handleSubmit} className="signup-form">
        <div className="form-group">
          <label htmlFor="firstname">First Name</label>
          <input
            type="text"
            id="firstname"
            name="firstname"
            value={formData.firstname}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="lastname">Last Name</label>
          <input
            type="text"
            id="lastname"
            name="lastname"
            value={formData.lastname}
            onChange={handleChange}
            required
          />
        </div>
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
        <div className="form-group">
          <label htmlFor="contact">Contact</label>
          <input
            type="text"
            id="contact"
            name="contact"
            value={formData.contact}
            onChange={handleChange}
            required
          />
        </div>
        
        <div className="form-group">
          <h4>Address</h4>
          <label htmlFor="adrLine1">Address Line 1</label>
          <input
            type="text"
            id="adrLine1"
            name="chosenAddress.adrLine1"
            value={formData.chosenAddress.adrLine1}
            onChange={handleChange}
            required
          />
          <label htmlFor="adrLine2">Address Line 2</label>
          <input
            type="text"
            id="adrLine2"
            name="chosenAddress.adrLine2"
            value={formData.chosenAddress.adrLine2}
            onChange={handleChange}
          />
          <label htmlFor="city">City</label>
          <input
            type="text"
            id="city"
            name="chosenAddress.city"
            value={formData.chosenAddress.city}
            onChange={handleChange}
            required
          />
          <label htmlFor="state">State</label>
          <input
            type="text"
            id="state"
            name="chosenAddress.state"
            value={formData.chosenAddress.state}
            onChange={handleChange}
            required
          />
          <label htmlFor="country">Country</label>
          <input
            type="text"
            id="country"
            name="chosenAddress.country"
            value={formData.chosenAddress.country}
            onChange={handleChange}
            required
          />
          <label htmlFor="zipCode">Zip Code</label>
          <input
            type="text"
            id="zipCode"
            name="chosenAddress.zipCode"
            value={formData.chosenAddress.zipCode}
            onChange={handleChange}
            required
          />
        </div>
        <button type="submit">Signup</button>
      </form>
      <span color='green'>{reqmsg}</span>
      <div className="form-group">
      
      {registerStatus?<button><Link to="/signin">SignIn</Link></button>:""}
      </div>
    </div>
  );
}

export default Signup;
