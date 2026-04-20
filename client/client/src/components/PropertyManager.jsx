import React, { useState } from "react";
import axios from "axios";
import "./../css/PropertyManager.css";
import Footer from "./Footer";
import { BASEURL } from "./Api";

const PropertyManager = () => {
  const [property, setProperty] = useState({
    title: "",
    price: "",
    type: "",
    location: "",
  });

  const [loading, setLoading] = useState(false);

  const handleChange = (e) => {
    setProperty({ ...property, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    setLoading(true);

    try {
      const res = await axios.post(
        BASEURL + "api/properties",
        property
      );

      alert("Property added successfully!");
      console.log("Response:", res.data);

      // optional reset (no logic change, just UX)
      setProperty({
        title: "",
        price: "",
        type: "",
        location: "",
      });
    } catch (error) {
      console.error("Error adding property:", error);
      alert("Failed to add property. Please try again.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div>
      <div className="property-container">
        <h2>Add Property</h2>

        <form onSubmit={handleSubmit} className="property-form">
          <input
            type="text"
            name="title"
            placeholder="Title"
            value={property.title}
            onChange={handleChange}
            required
          />

          <input
            type="number"
            name="price"
            placeholder="Price"
            value={property.price}
            onChange={handleChange}
            required
          />

          <select
            name="type"
            value={property.type}
            onChange={handleChange}
            required
          >
            <option value="">Select Type</option>
            <option value="Apartment">Apartment</option>
            <option value="House">House</option>
            <option value="Villa">Villa</option>
          </select>

          <input
            type="text"
            name="location"
            placeholder="Location"
            value={property.location}
            onChange={handleChange}
            required
          />

          <button type="submit" className="submit-btn" disabled={loading}>
            {loading ? "Adding..." : "Add Property"}
          </button>
        </form>
      </div>

      <Footer />
    </div>
  );
};

export default PropertyManager;