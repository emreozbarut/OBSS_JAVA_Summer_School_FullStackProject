import React from 'react';

class AdminMainPage extends React.Component{
    constructor(props){
        super(props)
    }
    render(){
        return(
        <div>
            <button>Add Book</button><br/>
            <button>Update Book</button><br/>
            <button>Delete Book</button><br/>
            <button>Search Book</button><br/>
            <button>Get All Books</button>
        </div>
        )
    }
}

export default AdminMainPage;