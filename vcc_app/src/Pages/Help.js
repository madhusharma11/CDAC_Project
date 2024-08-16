import React from "react";

export default function Help()
{
    return(
        <div>
        <div className="help-page">
            <h1>Help & Support</h1>
            <p>Welcome to the Vehicle Craft Customization help page. Find answers to common questions or reach out to our support team for further assistance.</p>
            
            {/* Search Bar
            <div className="search-bar">
                <input type="text" placeholder="Search for help..." />
                <button type="button">Search</button>
            </div> */}
            
            {/* FAQs Section */}
            <section className="faq-section">
                <h2>Frequently Asked Questions (FAQs)</h2>
                
                <h3>General Questions</h3>
                <ul>
                    <li>What is Vehicle Craft Customization?</li>
                    <li>How do I create an account?</li>
                    <li>How do I reset my password?</li>
                </ul>
                
                <h3>Orders and Payments</h3>
                <ul>
                    <li>How can I place an order?</li>
                    <li>What payment methods are accepted?</li>
                    <li>How do I track my order?</li>
                </ul>
                
                <h3>Customization</h3>
                <ul>
                    <li>How do I customize a vehicle?</li>
                    <li>What options are available for customization?</li>
                </ul>
                
                <h3>Shipping and Delivery</h3>
                <ul>
                    <li>How long does delivery take?</li>
                    <li>Can I change my delivery address?</li>
                </ul>
                
                <h3>Returns and Refunds</h3>
                <ul>
                    <li>What is the return policy?</li>
                    <li>How do I request a refund?</li>
                </ul>
            </section>
            
            {/* User Guides Section */}
            <section className="guide-section">
                <h2>User Guides</h2>
                
                <h3>Getting Started</h3>
                <p>Learn how to create an account and navigate the website with ease.</p>
                
                <h3>Customization Process</h3>
                <p>A step-by-step guide on how to customize your vehicle, select configurations, and place an order.</p>
                
                <h3>Order Process</h3>
                <p>Instructions on how to select a category, add items to your cart, and complete the checkout process.</p>
                
                <h3>Payment and Billing</h3>
                <p>Guide on entering payment information, understanding invoices, and managing billing preferences.</p>
            </section>
            </div>
            <br></br>
            <h3 >For general inquiries, please email us at: 
    <a href="mailto:info@vehiclecraftcustomization.com">info@vehiclecraftcustomization.com</a>
    </h3>
    <p>For support inquiries, please email us at: 
    <a href="mailto:support@vehiclecraftcustomization.com">support@vehiclecraftcustomization.com</a>
    </p>
    <p>For sales inquiries, please email us at: 
    <a href="sales@vehiclecraftcustomization.com">sales@vehiclecraftcustomization.com</a>
    </p>
        </div>
    );
}



    
