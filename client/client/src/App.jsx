import React from "react";
import { HashRouter as Router, Route, Routes } from "react-router-dom";

import "./App.css";
import "./i18n";

import Home1 from "./components/Home1";
import Dashboard from "./components/Dashboard";
import Contact from "./components/Contact";
import AboutUs from "./components/AboutUs";
import PropertyManager from "./components/PropertyManager";
import Rentals from "./components/Tenants";
import ChatbotPage from "./components/ChatbotPage";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home1 />} />
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/AboutUs" element={<AboutUs />} />
        <Route path="/PropertyManager" element={<PropertyManager />} />
        <Route path="/Rentals" element={<Rentals />} />
        <Route path="/chatbot" element={<ChatbotPage />} />
      </Routes>
    </Router>
  );
}

export default App;
