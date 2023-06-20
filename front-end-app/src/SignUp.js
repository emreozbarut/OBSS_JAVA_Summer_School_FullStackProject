import React from 'react';
import * as BookAPI from './BookAPI';
import { Redirect } from 'react-router-dom';
import { Button, Form, FormGroup, Label, Input } from 'reactstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
class SignUp extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      username: '',
      email: '',
      password: '',
      roleID: 1, redirect: false, confirm: ''
    };
    this.changeHandler = this.changeHandler.bind(this);
    this.clickHandler = this.clickHandler.bind(this);
  }
  setRedirect = () => {

    this.setState({
      redirect: true
    });

  }

  renderRedirect = () => {
    if (this.state.redirect) {
      return <Redirect to='/usermain' />
    }
  }
  clickHandler() {
    if (this.state.username !== '' && this.state.email !== '' && this.state.password !== '' && this.state.confirm !== '') {
      if (this.state.confirm === this.state.password) {
        this.setRedirect();
        BookAPI.insert(this.state);
      } else {
        this.setState({
          redirect: false
        });
        alert('Passwords are not same');
      }
    } else {
      alert('All fields have to be filled...')
    }
  }
  changeHandler(event) {
    this.setState({ [event.target.name]: event.target.value });
  }
  render() {
    return (
      <Form>
        <FormGroup>
          <Label for="username">Username</Label>
          <Input name="username" placeholder="enter a valid username..." onChange={this.changeHandler} value={this.state.username} />
        </FormGroup>
        <FormGroup>
          <Label for="email">Email</Label>
          <Input type="email" name="email" placeholder="enter a valid email..." onChange={this.changeHandler} value={this.state.email} />
        </FormGroup>
        <FormGroup>
          <Label for="password">Password</Label>
          <Input type="password" name="password" placeholder="password..." onChange={this.changeHandler} value={this.state.password} />
        </FormGroup>
        <FormGroup>
          <Label for="confirm">Confirm Password</Label>
          <Input type="password" name="confirm" placeholder="password again..." onChange={this.changeHandler} value={this.state.confirm} />
        </FormGroup>
        {this.renderRedirect()}
        <Button color="primary" onClick={this.clickHandler}>Submit</Button>
      </Form>


    )
  }
}

export default SignUp;