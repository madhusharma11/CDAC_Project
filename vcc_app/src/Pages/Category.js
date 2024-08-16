import React, { useState } from "react";
import { useEffect } from "react";
import axios from "axios";
import "../styles/Category.css";
import { useNavigate } from "react-router-dom";


export default function Category() {
  const navigate=useNavigate();
    const[categories,setCategories]=useState([]);
    const[configurationModels,setConfigurationModels]=useState([]);
    const[formData,setFormData]=useState({});
    const[selectedCategory,setCategory]=useState("");
    const[configurations,setConfiguration]=useState({});
    
    const handleChange=(e)=>{
      const { name, value } = e.target;
     // alert(value);
     const fetchData=async()=>{
      try{ 
        const response=await axios.get('http://localhost:8080/configure/findByCatId/'+value);
        console.log('Configurations loading successfully:', response.data);
         setConfigurationModels(response.data);
         setCategory(value);
      }catch(error)
      {
        console.error('Loading failed',error);
      }
     };
     fetchData();
    };

  const handleChange2=(e)=>{
    const{name,value}=e.target;
    const fetchData=async()=>{
      try{ 
        const response=await axios.get('http://localhost:8080/configure/findByConfigModelId/'+value);
        console.log('ConfigurationsModel loading successfully:', response.data);
        setFormData({...formData, [name]:response.data});
        
      }catch(error)
      {
        console.error('Loading failed',error);
      }
     };
     fetchData();
     const fetchData2=async()=>{
      try{ 
        const response=await axios.get( 'http://localhost:8080/configure/findByConfigId/'+name);
        console.log('Configuration loading successfully:', response.data);
        setConfiguration({...configurations, [name]:response.data.partName});
        
      }catch(error)
      {
        console.error('Loading failed',error);
      }
     };
     fetchData2();
console.log(formData);
  //alert(name);
  };
    const handleSubmit=()=>{


      navigate ("/orderdetails", {
      state: {
       configurationModels:formData,
        categoryId: selectedCategory,
        configuration:configurations
      }
    });
      
    };



    useEffect(() => {
        // This function runs after the component mounts and after every render
        console.log('Component rendered or updated');
        
        // Simulate data fetching
        const fetchData = async () => {
            try {
                const response = await axios.get('http://localhost:8080/category/getAllCategory');
                console.log('Categories loading successfully:', response.data);
                setCategories(response.data);
                
          
              } catch (error) {
                console.error('loading failed:', error);
              }
        };

        fetchData();
},[]);

   
    return(
        <div className="signup-page page">
        <h3>Choose Category !! </h3>
        <form onSubmit={handleSubmit} className="signup-form">
          
          <div className="form-group">
            <table>
              <tr>
              <td style={{width:'150px'}}> 
            <label htmlFor="category" id="category" name="category">Category</label>
            </td>
            <td style={{width:'150px'}}> 
            <select
             style={{width:'100px'}}
              id="category"
              name="category"
              onChange={handleChange}
              required
            >
         <option id="empty" value="" selected>-</option>
         {categories.map(category=>
         <option id={category.id} value={category.id}>
            {category.name}
         </option>         
                  )}
            </select>
            </td>
            </tr>
            </table>
          </div>
       
          {configurationModels.map((configurationModel)=>{
           return(
            <div className="form-group">
            <table>
              <tr>
             <td style={{width:'150px'}}>            
            <label htmlFor={configurationModel.partName} name={configurationModel.partName}>{configurationModel.partName}</label>
            </td>

            <td style={{width:'150px'}}> 
            <select style={{width:'100px'}} id={configurationModel.id}
            name={configurationModel.id}
            onChange={handleChange2}  
            >

               <option id="empty" value="" selected>-</option>
              {configurationModel.configurationModels.map(cmv=>
                <option id={cmv.id} name={cmv.id} value={cmv.id}>{cmv.modelCode} </option> 
              )}
               </select>
               </td>
               
               </tr>
               </table>
            </div>
           
          )}
            )}

            <button type="submit">PROCEED</button>
           
        </form>
    </div>
    )
};