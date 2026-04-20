import React from "react";
import "./i18n"; // keep only once

import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "./App.css";

import Home1 from "./components/Home1";
import Contact from "./components/Contact";
import AboutUs from "./components/AboutUs";
import Rentals from "./components/Tenants";
import PropertyManager from "./components/PropertyManager";
import Dashboard from "./components/Dashboard";
import HomePage from "./components/HomePage";

import { useNavigate } from "react-router-dom";
import { useTranslation } from "react-i18next";

// Wrapper for navigation (unchanged logic)
function Home1WithNavigate(props) {
  const navigate = useNavigate();
  return <Home1 {...props} navigate={navigate} />;
}

function App() {
  const { i18n } = useTranslation();

  return (
    <Router>
      <div>

        {/* Routes ONLY (important fix) */}
        <Routes>

          {/* Default Home/Login page */}
          <Route path="/" element={<Home1WithNavigate />} />

          <Route path="/home" element={<HomePage />} />
          <Route path="/Rentals" element={<Rentals />} />
          <Route path="/PropertyManager" element={<PropertyManager />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/AboutUs" element={<AboutUs />} />

        </Routes>

      </div>
    </Router>
  );
}

export default App;