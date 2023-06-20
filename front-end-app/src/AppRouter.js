import React from 'react';
import { Switch, Route, Redirect } from "react-router-dom";
import SignUp from './SignUp';
import DeleteBook from './DeleteBook';
import Main from './MainPage';
import SearchBooks from './SearchBooks';
import BookInfo from './GetAllBooks';
import AdminMainPage from './AdminPage';
import Login from './Login';
import UserMain from './UserPage';
import Links from './links';
import AddBook from './AddBook';
const AppRouter = () => (
    <Switch>
        <Route exact path="/" render={() => <Redirect replace to="links" />} />
        <Route path="/links" component={Links} />
        <Route path="/signup" component={SignUp} />
        <Route path="/login" component={Login} />
        <Route path="/main" component={Main} />
        <Route path="/delete" component={DeleteBook} />
        <Route path="/getbooks" component={BookInfo} />
        <Route path="/admin" component={AdminMainPage} />
        <Route path="/search" component={SearchBooks} />
        <Route path="/usermain" component={UserMain} />
        <Route path="/addbook" component={AddBook} />
    </Switch>
)

export default AppRouter;