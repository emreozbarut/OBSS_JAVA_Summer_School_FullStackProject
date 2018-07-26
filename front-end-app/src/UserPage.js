import React from 'react';

class UserMain extends React.Component{
    constructor(props){
        super(props)
    }
    render(){
        return(
        <div>
            <button>Get All Books</button><br/>
            <button>Search Book</button>
        </div>
        )
    }
}

export default UserMain;