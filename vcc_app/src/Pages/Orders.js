import axios from "axios";
import React, { useEffect, useState } from "react";
import * as utils from "./Util.js";
import "../styles/Orders.css";
//import 'bootstrap/dist/css/bootstrap.min.css';

export default function Orders(){
    const[orderList,setOrders]=useState([]);
    var user=utils.getUserInfo();
    var userjson=JSON.parse(user);
useEffect(()=>{
    const fetchData=async()=>{
        try{
         const response=await axios.get(
              'http://localhost:8080/orders/orderByUserId/'+userjson.id    
         );
         setOrders(response.data);
        }catch(error)
        {
            console.error("loading failed!!!")
        }
    };
    fetchData();
},[]);
    return(
        <div>

            <table class="ordertable">
               <tr className="ordertr" >
                <th className="orderth">Order Id</th>
                <th className="orderth">Category </th>
                <th className="orderth">Order Date</th>
                <th className="orderth">User</th>
                <th className="orderth">Total Amount</th>
                <th className="orderth">Payment Status</th>
                </tr>

                {orderList.map((order) => (
          <tr className="ordertr" key={order}>
           <td className="ordertd">{order.id}</td>
           <td className="ordertd">{order.category.name}</td>
           <td className="ordertd">{order.creationDate}</td>
           <td className="ordertd">{order.user.email}</td>
           <td className="ordertd">{order.totalAmount.toFixed(3)}</td>
           <td className="ordertd">{order.status}</td>
       
          </tr>
        ))}
            </table>
        </div>
    )
}