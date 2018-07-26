import React from "react"
import * as BookAPI from './BookAPI'


class SearchBooks extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            books:[],
            query:''
        }
        this.changeHandler = this.changeHandler.bind(this)
        this.clickHandler = this.clickHandler.bind(this)
        this.changeQuery = this.changeQuery.bind(this)
    }

    changeHandler(event){
        this.setState({[event.target.name]: event.target.value})
    }


    clickHandler(event){
       this.changeQuery(this.state.query)
    }

    changeQuery = ((query) => {
        BookAPI.get(query).then((books) => {
            if(!books || query===''){
                alert('Please enter a title!!!');
                this.setState({books:[]});
            } else {
                this.setState({books: books});
            }
        });
    });

    render(){
        const { query, books } = this.state

        return(
            <div>
                <input
                    name="query"
                    type="text"
                    onChange={this.changeHandler}
                    placeholder="Search by title"
                    value={query}/>
                <button onClick={this.clickHandler}>Search</button>

                <div>
                    <ol>
                      {books.map((book) => (
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
                    </ol>
                </div>
            </div>
        )
    }
}

export default SearchBooks;