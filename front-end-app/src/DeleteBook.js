import * as BookAPI from './BookAPI';
import React from 'react';
import image from './java.jpg';
import BookInfo from './GetAllBooks';
class DeleteBook extends React.Component {
    constructor(props) {
        super(props)
        this.state = {books:[],title:''}
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
    clickHandler(){
        if(this.state.title===''){
            alert('Please enter the Title!!!');        
        }else{
            var bookList=this.state.books;
                for(var i=0;i<=bookList.length;i++){
                    if(i==bookList.length){
                        alert('There is no book with this Title!!!');
                        break;
                    }
                    else if(bookList[i].title === this.state.title){
                        BookAPI.delFav(bookList[i].bookID);
                        this.delBookInfo(bookList[i].bookID);
                        this.delBook(this.state.title);
                        break;  
                    }
                }
                    
            }
        
        }
    delBookInfo(bookID){
        BookAPI.delBookInfo(bookID);
    }
    delBook(title){
        BookAPI.del(title);
        var bookList=this.state.books;
        for(var i=0;i<bookList.length;i++){
            if(bookList[i].title === title){
                bookList.splice(i,1);
            }
        }
        this.setState({books:bookList});    
    }
    
    render() {
        return (
            <div>
                <input
                    name="title"
                    type="Integer"
                    onChange={this.changeHandler}
                    placeholder="Please Enter Title..."
                    value={this.state.title}/>
                <button onClick={this.clickHandler}>Delete</button><br/>
                {this.state.books.map((book)=>(
                          <div>
                              <ul>
                                  <li>
                              <img src={image}/><br/>
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