import React from 'react';
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Navigate,
} from 'react-router-dom';
import './App.css';
import LoginForm from './login-form/LoginForm';
import HomeForm from './home/HomeForm';
import ApiProvider from './api/ApiProvider';

function App() {
  return (
    <Router>
      <ApiProvider>
        <div className="App">
          <Routes>
            <Route path="/login" element={<LoginForm />} />
            <Route path="/home" element={<HomeForm />} />
            <Route path="/" element={<Navigate replace to="/login" />} />
          </Routes>
        </div>
      </ApiProvider>
    </Router>
  );
}

export default App;