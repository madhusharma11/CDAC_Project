
import React, { useState } from 'react';
import axios from 'axios';
import '../styles/SignUp.css';
import { Link } from 'react-router-dom';

function Signup() {
  const [reqmsg, setReqMsg] = useState('');
  const [registerStatus, setRegisterStatus] = useState(false);
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

  const [errors, setErrors] = useState({});

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

  const validateForm = () => {
    const newErrors = {};
    if (!formData.firstname) newErrors.firstname = "First Name is required";

    if (!formData.lastname) newErrors.lastname = "Last Name is required";

    if (!formData.email) {
      newErrors.email = "Email is required";
    } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(formData.email)) {
      newErrors.email = "Invalid email format, must contain @ and end with .com";
    }
    if (!formData.password) {
      newErrors.password = "Password is required";
    } else if (
      !/^(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/.test(formData.password)
    ) {
      newErrors.password =
        "Password must be at least 8 characters long, contain at least 1 number and 1 special character";
    }
    if (!formData.contact) newErrors.contact = "Contact is required";

    if (!formData.chosenAddress.adrLine1) newErrors.adrLine1 = "Address Line 1 is required";

    if (!formData.chosenAddress.city) newErrors.city = "City is required";

    if (!formData.chosenAddress.state) newErrors.state = "State is required";

    if (!formData.chosenAddress.country) newErrors.country = "Country is required";

    if (!formData.chosenAddress.zipCode) newErrors.zipCode = "Zip Code is required";

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!validateForm()) {
      return;
    }

    try {
      const response = await axios.post('http://localhost:8080/users/register', formData);
      console.log('User registered successfully: Please login', response.data);
      setReqMsg('User registered successfully: Please login');
      setRegisterStatus(true);
    } catch (error) {
      console.error('Error registering the user:', error);
      setReqMsg('Error registering the user');
    }
  };

  return (
    <div className="signup-page page">
      <h3>Register !! </h3>
      <form onSubmit={handleSubmit} className="signup-form">
        <div className="form-group">
          <label htmlFor="firstname">First Name <span className="required">*</span></label>
          <input
            type="text"
            id="firstname"
            name="firstname"
            value={formData.firstname}
            onChange={handleChange}
            required
          />
          {errors.firstname && <span className="error">{errors.firstname}</span>}
        </div>
        <div className="form-group">
          <label htmlFor="lastname">Last Name <span className="required">*</span></label>
          <input
            type="text"
            id="lastname"
            name="lastname"
            value={formData.lastname}
            onChange={handleChange}
            required
          />
          {errors.lastname && <span className="error">{errors.lastname}</span>}
        </div>
        <div className="form-group">
          <label htmlFor="email">Email <span className="required">*</span></label>
          <input
            type="email"
            id="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            required
          />
          {errors.email && <span className="error">{errors.email}</span>}
        </div>
        <div className="form-group">
          <label htmlFor="password">Password <span className="required">*</span></label>
          <input
            type="password"
            id="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            required
          />
          {errors.password && <span className="error">{errors.password}</span>}
        </div>
        <div className="form-group">
          <label htmlFor="contact">Contact <span className="required">*</span></label>
          <input
            type="text"
            id="contact"
            name="contact"
            value={formData.contact}
            onChange={handleChange}
            required
          />
          {errors.contact && <span className="error">{errors.contact}</span>}
        </div>
        
        <div className="form-group">
          <h4>Address</h4>
          <label htmlFor="adrLine1">Address Line 1 <span className="required">*</span></label>
          <input
            type="text"
            id="adrLine1"
            name="chosenAddress.adrLine1"
            value={formData.chosenAddress.adrLine1}
            onChange={handleChange}
            required
          />
          {errors.adrLine1 && <span className="error">{errors.adrLine1}</span>}
          <label htmlFor="adrLine2">Address Line 2</label>
          <input
            type="text"
            id="adrLine2"
            name="chosenAddress.adrLine2"
            value={formData.chosenAddress.adrLine2}
            onChange={handleChange}
          />
          <label htmlFor="city">City <span className="required">*</span></label>
          <input
            type="text"
            id="city"
            name="chosenAddress.city"
            value={formData.chosenAddress.city}
            onChange={handleChange}
            required
          />
          {errors.city && <span className="error">{errors.city}</span>}
          <label htmlFor="state">State <span className="required">*</span></label>
          <input
            type="text"
            id="state"
            name="chosenAddress.state"
            value={formData.chosenAddress.state}
            onChange={handleChange}
            required
          />
          {errors.state && <span className="error">{errors.state}</span>}
          <label htmlFor="country">Country <span className="required">*</span></label>
          <input
            type="text"
            id="country"
            name="chosenAddress.country"
            value={formData.chosenAddress.country}
            onChange={handleChange}
            required
          />
          {errors.country && <span className="error">{errors.country}</span>}
          <label htmlFor="zipCode">Zip Code <span className="required">*</span></label>
          <input
            type="text"
            id="zipCode"
            name="chosenAddress.zipCode"
            value={formData.chosenAddress.zipCode}
            onChange={handleChange}
            required
          />
          {errors.zipCode && <span className="error">{errors.zipCode}</span>}
        </div>
        <button type="submit">Signup</button>
      </form>
      <span color='green'>{reqmsg}</span>
      <div className="form-group">
        {registerStatus ? <button><Link to="/signin">SignIn</Link></button> : ""}
      </div>
    </div>
  );
}

export default Signup;
