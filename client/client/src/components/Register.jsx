// import "../css/Register.css";
// import React, { useState, useEffect } from "react";
// import { FaEye, FaEyeSlash } from "react-icons/fa";
// import Footer from "./Footer";
// import countriesAndCitiesData from "../json/countriesAndCities.json";

// const Register = () => {
//   const [fullname, setFullname] = useState("");
//   const [email, setEmail] = useState("");
//   const [phone, setPhone] = useState("");
//   const [selectedCountry, setSelectedCountry] = useState("");
//   const [selectedCity, setSelectedCity] = useState("");
//   const [address, setAddress] = useState("");
//   const [state, setState] = useState("");
//   const [termsAccepted, setTermsAccepted] = useState(false);
//   const [password, setPassword] = useState("");
//   const [confirmPassword, setConfirmPassword] = useState("");

//   const [passwordVisible, setPasswordVisible] = useState(false);
//   const [confirmPasswordVisible, setConfirmPasswordVisible] =
//     useState(false);

//   const [countries, setCountries] = useState([]);
//   const [cities, setCities] = useState([]);

//   useEffect(() => {
//     setCountries(countriesAndCitiesData.countries);
//   }, []);

//   const handleCountryChange = (e) => {
//     const selected = e.target.value;
//     setSelectedCountry(selected);

//     const country = countries.find((c) => c.name === selected);
//     if (country) setCities(country.cities);
//   };

//   const handleSubmit = (e) => {
//     e.preventDefault();

//     if (password !== confirmPassword) {
//       alert("Passwords do not match!");
//       return;
//     }

//     if (!termsAccepted) {
//       alert("Please accept terms and conditions");
//       return;
//     }

//     alert("Registered successfully!");

//     // RESET FORM (AWS UX improvement)
//     setFullname("");
//     setEmail("");
//     setPhone("");
//     setSelectedCountry("");
//     setSelectedCity("");
//     setAddress("");
//     setState("");
//     setPassword("");
//     setConfirmPassword("");
//     setTermsAccepted(false);
//   };

//   return (
//     <div>
//       <div className="login-form">
//         <h2>Register</h2>

//         <form onSubmit={handleSubmit}>
//           <div className="input-field">
//             <label><h3>Full Name</h3></label>
//             <input
//               type="text"
//               value={fullname}
//               onChange={(e) => setFullname(e.target.value)}
//               required
//             />
//           </div>

//           <div className="input-field">
//             <label><h3>Email</h3></label>
//             <input
//               type="email"
//               value={email}
//               onChange={(e) => setEmail(e.target.value)}
//               required
//             />
//           </div>

//           <div className="input-field">
//             <label><h3>Phone</h3></label>
//             <input
//               type="tel"
//               value={phone}
//               onChange={(e) => setPhone(e.target.value)}
//               required
//             />
//           </div>

//           <div className="input-field">
//             <label><h3>Country</h3></label>
//             <select
//               value={selectedCountry}
//               onChange={handleCountryChange}
//               required
//             >
//               <option value="">Select your country</option>
//               {countries.map((c, i) => (
//                 <option key={i} value={c.name}>
//                   {c.name}
//                 </option>
//               ))}
//             </select>
//           </div>

//           <div className="input-field">
//             <label><h3>City</h3></label>
//             <select
//               value={selectedCity}
//               onChange={(e) => setSelectedCity(e.target.value)}
//               required
//               disabled={!selectedCountry}
//             >
//               <option value="">Select your city</option>
//               {cities.map((city, i) => (
//                 <option key={i} value={city}>
//                   {city}
//                 </option>
//               ))}
//             </select>
//           </div>

//           <div className="input-field">
//             <label><h3>Address</h3></label>
//             <input
//               type="text"
//               value={address}
//               onChange={(e) => setAddress(e.target.value)}
//               required
//             />
//           </div>

//           <div className="input-field">
//             <label><h3>State</h3></label>
//             <input
//               type="text"
//               value={state}
//               onChange={(e) => setState(e.target.value)}
//               required
//             />
//           </div>

//           <div className="input-field password-field">
//             <label><h3>Password</h3></label>
//             <span
//               className="eye-icon"
//               onClick={() =>
//                 setPasswordVisible(!passwordVisible)
//               }
//             >
//               {passwordVisible ? <FaEyeSlash /> : <FaEye />}
//             </span>

//             <input
//               type={passwordVisible ? "text" : "password"}
//               value={password}
//               onChange={(e) => setPassword(e.target.value)}
//               required
//             />
//           </div>

//           <div className="input-field password-field">
//             <label><h3>Confirm Password</h3></label>
//             <span
//               className="eye-icon"
//               onClick={() =>
//                 setConfirmPasswordVisible(!confirmPasswordVisible)
//               }
//             >
//               {confirmPasswordVisible ? <FaEyeSlash /> : <FaEye />}
//             </span>

//             <input
//               type={confirmPasswordVisible ? "text" : "password"}
//               value={confirmPassword}
//               onChange={(e) =>
//                 setConfirmPassword(e.target.value)
//               }
//               required
//             />
//           </div>

//           <input
//             type="checkbox"
//             checked={termsAccepted}
//             onChange={() =>
//               setTermsAccepted(!termsAccepted)
//             }
//             required
//           />
//           I agree to the Terms and Conditions

//           <button
//             type="submit"
//             className="login-button"
//             disabled={!termsAccepted}
//           >
//             Register
//           </button>
//         </form>

//         {/* FIX: SPA navigation instead of full reload */}
//         <p className="signup-link">
//           Already have an account?{" "}
//           <a href="/login">Login Here</a>
//         </p>
//       </div>

//       <Footer />
//     </div>
//   );
// };

// export default Register;