import * as BookAPI from './BookAPI';
import React from 'react';
class DeleteBook extends React.Component {
    constructor(props) {
        super(props)
        this.state = {books:[],bookID:null}
        this.clickHandler=this.clickHandler.bind(this);
        this.changeHandler=this.changeHandler.bind(this);
        this.delBookInfo=this.delBookInfo.bind(this);
        this.delBook=this.delBook.bind(this);
    }

    componentDidMount(){
        BookAPI.getAll().then((books)=>{
            if(!books){
                this.setState({books:[]})
            }else{
                this.setState({books:books})
            }
        })
    }
    changeHandler(event){
        this.setState({[event.target.name]:event.target.value});
    }
    clickHandler(event){
        if(!this.state.bookID){
            alert('Please enter the bookID!!!');        
        }else{
            BookAPI.delFav(this.state.bookID);
            this.delBookInfo();
            this.delBook();          
        }
        }
    delBookInfo(){
        BookAPI.delBookInfo(this.state.bookID);
    }
    delBook(){
        BookAPI.del(this.state.bookID);
    }
    render() {
        return (
            <div>
                <input
                    name="bookID"
                    type="Integer"
                    onChange={this.changeHandler}
                    placeholder="Please Enter BookID..."
                    value={this.state.bookID}/>
                <button onClick={this.clickHandler}>Delete</button><br/>
                {this.componentDidMount()}
                {this.state.books.map((book)=>(
                          <div>
                              <ul>
                                  <li>
                              <img src={require('D:/front-end-app/src/java.jpg')}/><br/>
                              {book.bookID}<br/>
                              {book.title}<br/>
                              {book.publishDate}<br/>
                                   </li>
                              </ul>
                          </div>
                ))}
            </div>
                
        )}
    }

export default DeleteBook;