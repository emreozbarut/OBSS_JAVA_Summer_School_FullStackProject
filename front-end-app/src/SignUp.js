import React from 'react';
import * as BookAPI from './BookAPI';
import  { Redirect } from 'react-router-dom';
class SignUp extends React.Component{
    constructor(props){
        super(props)
        this.state={username: '',
            email: '',
            password: '' ,userID: 12,
            roleID:1,redirect:false                   
    };
        this.changeHandler=this.changeHandler.bind(this);
        this.clickHandler=this.clickHandler.bind(this);
    }
    setRedirect = () => {
        BookAPI.insert(this.state);
        this.setState({userID:this.state.userID+1});
        this.setState({
          redirect: true
        })
      }
      renderRedirect = () => {
        if (this.state.redirect) {
          return <Redirect to='/usermain'/>
        }
      }
    clickHandler(event){
        
        
    }
    changeHandler(event){
        this.setState({[event.target.name]:event.target.value});
    }
    render(){
        return(
            <div>
                <input name="username" type="text" onChange={this.changeHandler} value={this.state.username}/><br/>
                <input name="email" type="text" onChange={this.changeHandler} value={this.state.email}/><br/>
                <input name="password" type="password" onChange={this.changeHandler} value={this.state.password}/><br/>
                <input type="password"/><br/>
                {this.renderRedirect()}
                <button onClick={this.setRedirect}>Login</button><br/>
            </div>           
        )
    }
}

export default SignUp;