import React, { useState } from "react";
import { json, useLocation } from "react-router-dom";
import { useEffect } from "react";
import axios from "axios";
import * as utils from "./Util.js";

export default function OrderDetails() {
  const location = useLocation();
  const { state } = location;
  const { configurationModels, categoryId, configuration } = state || {};

  const [category, setCategory] = useState();
  const [orderSubmitted, setOrderStatus] = useState(false);
  const [paymentDone, setPaymentStatus] = useState(false);
  const [order, setOrder] = useState({});

  var orderData = {};
  var user = utils.getUserInfo();
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
      } catch (error) {
        console.error("loading failed:", error);
      }
    };

    fetchData();
  }, []);

  return (
    <div>
      <h1>OrderDetails</h1>
      <table>
        <tr>
          <td>Category:</td>
          <td colSpan="3">{category}</td>
        </tr>
        //loop
        {Object.keys(configurationModels).map((key) => (
          <tr key={key}>
            <td style={{ width: "150px" }}>{configuration[key]} </td>
            <td style={{ width: "150px" }}>
              {configurationModels[key].modelCode}{" "}
            </td>
            <td style={{ width: "150px" }}>
              {configurationModels[key].modelDescription}{" "}
            </td>
            <td style={{ width: "150px" }}>
              {configurationModels[key].modelPrice}{" "}
            </td>
          </tr>
        ))}
        <tr>
          <td colSpan="3" style={{ width: "150px" }}>
            total amount:
          </td>
          <td>{totalPrice.toFixed(3)}</td>
        </tr>
        {orderSubmitted?
        <tr>
          <td colSpan="3" style={{ width: "150px" }}>
            Payment Status
          </td>
          <td>{order.status}</td>
        </tr>:""
        }
        <tr>
          <td colSpan="4">Customer Details:</td>
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

{ orderSubmitted ?paymentDone?<span>Order Successfull </span>:<button id="payment" name="payment" onClick={doPayment}>
        Pay Now
      </button>
  :
        <button id="submitOrder" name="submitOrder" onClick={submitOrder}>
        Confirm
      </button>
}
    </div>
  );
}
