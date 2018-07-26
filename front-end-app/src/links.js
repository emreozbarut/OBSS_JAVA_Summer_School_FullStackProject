import React from 'react';
import {Link} from 'react-router-dom';
class Links extends React.Component{
    render(){
        return(
            <div className="links">
                <Link to={"/signup"}>Sign Up</Link><br/>
                <Link to={"/login"}>Login</Link><br/>
                <Link to={"/main"}>Main</Link><br/>
                <Link to={"/delete"}>Delete Book</Link><br/>
                <Link to={"/getbooks"}>Get All Books</Link><br/>
                <Link to={"/admin"}>Admin Page</Link><br/>
                <Link to={"/usermain"}>User Main Page</Link><br/>
                <Link to={"/search"}>Search Book</Link><br/>
            </div>
        )
    }
}
export default Links;