import React from 'react';
import * as BookAPI from './BookAPI';
import  { Redirect } from 'react-router-dom';
class AddBook extends React.Component{
    constructor(props){
        super(props)
        this.state={
            "title":"",
            "publishDate":"28.07.2018",
            "updateDate":"28.07.2018",
            "insertDate":"28.07.2018",
            "insertedBy":"1",
            "redirect":false
        };
        this.changeHandler=this.changeHandler.bind(this);
    }
    setRedirect = () => {
        if(this.state.title!==""){
        BookAPI.insertBook(this.state);
        this.setState({
          redirect: true
        })
        }else{
            this.setState({
                redirect: false
              })
              alert('Title cannot be null!!!');
        }
      }
      renderRedirect = () => {
        if (this.state.redirect) {
          return <Redirect to='/getbooks'/>
        }
      }
   
    changeHandler(event){
        this.setState({[event.target.name]:event.target.value});
    }
    render(){
        return(
            <div>
                <input name="title" type="text" onChange={this.changeHandler} placeHolder="Name of the Book" value={this.state.title}/><br/>
                {this.renderRedirect()}
                <button onClick={this.setRedirect}>Add Book</button><br/>
            </div>           
        )
    }
}

export default AddBook;