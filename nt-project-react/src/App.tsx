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
import { I18nextProvider } from 'react-i18next';
import i18n from './i18n';

function App() {
  return (
    <Router>
      <I18nextProvider i18n={i18n}>
        <ApiProvider>
          <div className="App">
            <Routes>
              <Route path="/login" element={<LoginForm />} />
              <Route path="/home" element={<HomeForm />} />
              <Route path="/" element={<Navigate replace to="/login" />} />
            </Routes>
          </div>
        </ApiProvider>
      </I18nextProvider>
    </Router>
  );
}

export default App;
