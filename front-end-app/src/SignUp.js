import React from 'react';
import * as BookAPI from './BookAPI';
import  { Redirect } from 'react-router-dom';
class SignUp extends React.Component{
    constructor(props){
        super(props)
        this.state={username: '',
            email: '',
            password: '' ,
            roleID:1,redirect:false,confirm:''                   
    };
        this.changeHandler=this.changeHandler.bind(this);
        this.clickHandler=this.clickHandler.bind(this);
    }
    setRedirect = () => {
      
        this.setState({
          redirect: true
        });
        
      }
    
      renderRedirect = () => {
        if (this.state.redirect) {
          return <Redirect to='/usermain'/>
        }
      }
    clickHandler(event){
        if(this.state.confirm===this.state.password){
        this.setRedirect();        
        BookAPI.insert(this.state);
        }else{
            this.setState({
                redirect: false
              });
              alert('Passwords are not same');
        }              
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
                <input name="confirm" type="password" onChange={this.changeHandler} value={this.state.confirm}/><br/>
                {this.renderRedirect()}
                <button onClick={this.clickHandler}>Login</button><br/>
            </div>           
        )
    }
}

export default SignUp;