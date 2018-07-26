import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
//import App from './App';
//import * as BookAPI from './BookAPI';
//import BookInfo from './GetAllBooks';
//import SearchBooks from './SearchBooks';
//import DeleteBook from './DeleteBook';
import AppRouter from './AppRouter';
import {BrowserRouter} from 'react-router-dom';
//import SignUp from './SignUp';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(
    <BrowserRouter>
    <AppRouter/>
    </BrowserRouter>, document.getElementById('root'));
registerServiceWorker();
