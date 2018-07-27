import * as BookAPI from './BookAPI';
import React from 'react';
import image from './java.jpg';
class BookInfo extends React.Component {
    constructor(props) {
        super(props)
        this.state = { book: [], books:[],query: '' ,bookID:1}
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
    render() {
        return (
            <div>
                {this.state.books.map((book)=>(
                    <ul>
                        <li>
                          <div>
                              
                              <img src={image}/><br/>
                              
                              {book.title}<br/>
                              {book.publishDate}<br/>
                              
                              <button>Add to Favorites</button>
                              <button>Add to Will Reads</button>
                               
                          </div>
                        </li>
                      </ul>
                ))}
            </div>
                
        )
    }
}

export default BookInfo;