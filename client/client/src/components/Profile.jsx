import React, { useState, useEffect } from "react";
import axios from "axios";
import { BASEURL } from "./Api";

function UserProfile() {
  const [userData, setUserData] = useState(null);
  const [error, setError] = useState("");

  const token =
    localStorage.getItem("auth_token") ||
    localStorage.getItem("csrid"); // AWS-safe fallback

  console.log(token);

  useEffect(() => {
    if (!token) {
      setError("No token found. Please sign in.");
      return;
    }

    axios
      .post(BASEURL + "users/getfullname", {
        csrid: token,
      })
      .then((response) => {
        // IMPORTANT: backend likely returns string like "200::NAME"
        const res = response.data;

        if (typeof res === "string" && res.includes("::")) {
          const parts = res.split("::");

          setUserData({
            fullname: parts[1],
            email: "N/A", // backend not providing email in this API
          });
        } else {
          setUserData(res);
        }
      })
      .catch((err) => {
        setError("Failed to fetch user data");
        console.error(err);
      });
  }, [token]);

  if (error) {
    return <div>{error}</div>;
  }

  if (!userData) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <h1>User Profile</h1>
      <p>Full Name: {userData.fullname}</p>
      <p>Email: {userData.email}</p>
    </div>
  );
}

export default UserProfile;