import * as BookAPI from './BookAPI';
import React from 'react';

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
                    <ol>
                        <li>
                          <div>
                              <ul>
                                  <li>
                              <img src={require('D:/front-end-app/src/java.jpg')}/><br/>
                              
                              {book.title}<br/>
                              {book.publishDate}<br/>
                              
                              <button>Add to Favorites</button>
                              <button>Add to Will Reads</button>
                                   </li>
                              </ul>
                          </div>
                        </li>
                      </ol>
                ))}
            </div>
                
        )
    }
}

export default BookInfo;