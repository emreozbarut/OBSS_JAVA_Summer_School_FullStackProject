import React from 'react';
import * as BookAPI from './BookAPI';
import  { Redirect } from 'react-router-dom';
class AddBook extends React.Component{
    constructor(props){
        super(props)
        this.state={
            "bookID":2,
            "title":"",
            "publishDate":"27.07.2018",
            "updateDate":"27.07.2018",
            "insertDate":"27.07.2018",
            "insertedBy":"1",
            "redirect":false
        };
        this.changeHandler=this.changeHandler.bind(this);
    }
    setRedirect = () => {
        BookAPI.insertBook(this.state);
        this.setState({bookID:this.state.bookID+1});
        this.setState({
          redirect: true
        })
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
                <input name="title" type="text" onChange={this.changeHandler} value={this.state.title}/><br/>
                {this.renderRedirect()}
                <button onClick={this.setRedirect}>Add Book</button><br/>
            </div>           
        )
    }
}

export default AddBook;