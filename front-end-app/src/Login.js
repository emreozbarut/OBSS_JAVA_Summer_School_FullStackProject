import React from 'react';

class Login extends React.Component {
    constructor(props) {
        super(props)
        this.state = { username: '', password: '' };
        this.changeHandler = this.changeHandler.bind(this);
        this.clickHandler = this.clickHandler.bind(this);
    }
    clickHandler(event) {
        event.preventDefault();
    }
    changeHandler(event) {
        this.setState({ [event.target.name]: event.target.value });
    }
    render() {
        return (
            <div>
                <input name="username" type="text" onChange={this.changeHandler} value={this.state.username} /><br />
                <input name="password" type="password" onChange={this.changeHandler} value={this.state.password} /><br />
                <button onClick={this.clickHandler}>Login</button>
            </div>
        )
    }
}

export default Login;