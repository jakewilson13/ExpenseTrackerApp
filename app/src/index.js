//entry point for our application
import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App'
import * as serviceWorker from './serviceWorker';
import 'bootstrap/dist/css/bootstrap.css'

//reactdom renders and recongizes all the changes in the application
ReactDOM.render(
  <React.StrictMode>
    <App/>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();


//          AppNav
//            |
//            V
//   Home.js, Category.js, Expenses.js
//            |
//            V
//          App.js
//            |
//            V
//          index.js
//
