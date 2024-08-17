import React, { useState } from "react";
import { json, useLocation } from "react-router-dom";
import { useEffect } from "react";
import axios from "axios";
import * as utils from "./Util.js";
import { Link } from "react-router-dom";
import "../styles/Orders.css";
import { useNavigate } from "react-router-dom";

export default function OrderDetails() {

   var user = utils.getUserInfo();
 /* const navigate=useNavigate();

  if(!user)
    {
      navigate("./");
    }
*/
  const location = useLocation();
  const { state } = location;
  const { configurationModels, categoryId, configuration } = state || {};

  const [category, setCategory] = useState();
  const [orderSubmitted, setOrderStatus] = useState(false);
  const [paymentDone, setPaymentStatus] = useState(false);
  const [order, setOrder] = useState({});
const[total,setPrice]=useState(0);
  var orderData = {};
  
  var usrJson = JSON.parse(user);
  var confiModelIds = [];
  var totalPrice = 0;

  Object.keys(configurationModels).map((key) => {
    totalPrice = totalPrice + configurationModels[key].modelPrice;
    confiModelIds.push(configurationModels[key].id);
  });

  
  
  const doPayment = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.put(
        "http://localhost:8080/orders/updatePaymentStatus/"+order.id
      
      );
      setPaymentStatus(true);
      setOrder(response.data);
      // redirect to login
    } catch (error) {
      console.error("error registering the user:", error);
    }
  };

  const submitOrder = async (e) => {
    e.preventDefault();
    try {
      orderData = {
        categoryId: categoryId,
        configurationModelId: confiModelIds,
        userId: usrJson.id
      };
      const response = await axios.post(
        "http://localhost:8080/orders/addOrder",
        orderData
      );

      console.log("order registered successfully:plz login", response.data);
      setOrderStatus(true);
      setOrder(response.data)
      // redirect to login
    } catch (error) {
      console.error("error registering the user:", error);
    }
  };

  useEffect(() => {
    // This function runs after the component mounts and after every render
    console.log("Component rendered or updated");

    // Simulate data fetching
    const fetchData = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8080/category/findByCatId/" + categoryId
        );
        console.log("Category id loading successfully:", response.data);
        setCategory(response.data.name);
        setPrice(response.data.price+totalPrice);
        //alert("totalPrice"+totalPrice);
      } catch (error) {
        console.error("loading failed:", error);
      }
    };

    fetchData();
  }, []);

  return (
    <div>
      <h1 style={{color:'white'}}>OrderDetails</h1>
      <table className="ordertable">
       
        <tr>
          <td><b>Category:</b></td>
          <td colSpan="1">{category}</td><br></br>
        </tr>
        <tr className="ordertr">
        
          <th className="headerth" >Configuration Name</th>
          <th className="headerth">Model No.</th>
          <th className="headerth">Model Description</th>
          <th className="headerth">Model Price</th>
        
        </tr>
        {Object.keys(configurationModels).map((key) => (
          <tr key={key}>
            <td  style={{ width: "200px"}}>{configuration[key]} </td>
            <td  style={{ width: "200px" }}>
              {configurationModels[key].modelCode}{" "}
            </td>
            <td  style={{ width: "200px" }}>
              {configurationModels[key].modelDescription}{" "}
            </td>
            <td  style={{ width: "200px" }}>
              {configurationModels[key].modelPrice}{" "}
            </td>
          </tr>
        ))}
     
        <tr>
          <td className="ordertd" colSpan="1" style={{ width: "200px" }}>
           <b>Total amount:</b> 
          </td>
          
          <td><b>{total.toFixed(3)} (including GST**)</b></td>
        </tr>
        {orderSubmitted?
        <tr>
          <td>
            Payment Status
          </td>
          {paymentDone?
          <td style={{color:'green'}}>{order.status}</td>:<td style={{color:'red'}}>{order.status}</td>}
          <td></td>
          <td></td>
        </tr>:""
        }
      
        <tr>
          <td className="headerth" colSpan="4"><b>Customer Details:</b></td>
        </tr>
        <tr>
          <td>
            {usrJson.firstname} {usrJson.lastname}
           
          </td>
          <td colSpan="3">
            {usrJson.chosenAddress.adrLine1},{usrJson.chosenAddress.adrLine2}
            {usrJson.chosenAddress.city},{usrJson.chosenAddress.state},
            {usrJson.chosenAddress.country},{usrJson.chosenAddress.zipCode}
          </td> 
        </tr>
        
        <tr>
          <td>Mob.no</td>
          <td colSpan="3">{usrJson.contact}</td>
        </tr>
      </table> 

{ orderSubmitted ?paymentDone?<span style={{color:'green'}}>Order Successfull 
</span>:<button id="payment" name="payment" onClick={doPayment}>
        Pay Now
      </button>
  :<span>
        <button id="submitOrder" name="submitOrder" onClick={submitOrder}>
        Confirm
      </button> 
      &nbsp;  &nbsp;  &nbsp; 
      <button ><Link to="/category">Edit</Link></button>
      </span>  
}

    </div>
  );
}
