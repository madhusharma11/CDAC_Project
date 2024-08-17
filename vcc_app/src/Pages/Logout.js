import React from "react";
import * as utils from "./Util.js";
import SignIn from "./SignIn";
import { Link } from "react-router-dom";

export default function Logout()
{
utils.sessionLogout();
    return(
        <div>
            <h1>logout successfully</h1>
            <button ><Link to="/signin">SignIn</Link></button>
        </div>
    )
}