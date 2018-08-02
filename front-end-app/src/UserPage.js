import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import  { Redirect } from 'react-router-dom';
import { Button } from 'reactstrap';
class Button1 extends React.Component{
    render(){
        return(
            <div>
                {this.props.renderRedirect()}
                <Button color="primary" onClick={()=>{this.props.setRedirect(this.props.url)}}>{this.props.value}</Button><br/>
            </div>
        )
    }
}

class UserMain extends React.Component{
    constructor(props){
        super(props)
        this.state={redirect:false,url:''};
    }

    setRedirect = (url) => {
            this.setState({
                redirect: true,url:url
              });
              this.renderRedirect();
      }
      renderRedirect = () => {
        if (this.state.redirect) {
          return <Redirect to={this.state.url}/>
        }
      }
    render(){
        return(
        <div>
           <Button1 value="Search Book" url='/search' setRedirect={this.setRedirect} renderRedirect={this.renderRedirect}/>
           <Button1 value="Get All Books" url='/getbooks' setRedirect={this.setRedirect} renderRedirect={this.renderRedirect}/>
        </div>
        )
    }
}

export default UserMain;