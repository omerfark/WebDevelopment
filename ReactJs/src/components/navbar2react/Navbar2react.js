import React, { useState } from "react";
import Navbar from "react-bootstrap/Navbar";
import "./Navbar2react.scss";
import logo from "./tbtklogo.png";
import { Container } from "react-bootstrap";
import Col from "react-bootstrap/Col";

function Navbar2react() {
  const [clicked, setClicked] = useState(false);

  const handleClick = () => {
    setClicked(!clicked);
  };

  const SearchPage = () => {
    const [isSearchOpen, setIsSearchOpen] = useState(false);
  
    const handleToggleSearch = () => {
      setIsSearchOpen(!isSearchOpen);
    };
  
    return (
      <div className={` ${isSearchOpen ? "searchOpen" : ""}`}>
        <input
          type="text"
          placeholder="Search"
          aria-label="Search"
          className={`searchInput ${isSearchOpen ? "inputOpen" : ""}`}
        />
        <button className="searchButton" onClick={handleToggleSearch}>
          <i className={`fas fa-search ${isSearchOpen ? "searchIconOpen" : ""}`}></i>
        </button>
      </div>
    );
  };

  return (
    <>
      <Container>
        <Col>
          <nav>
            <a href="/mainpage">
              <img
                id="imgsrc"
                src={logo}
                alt="logo"
                width={80}
                height={60}
              ></img>
            </a>
            <Navbar.Collapse id="basic-navbar-nav"></Navbar.Collapse>
            <div>
              <ul
                id="navbar"
                className={clicked ? "#navbar active" : "#navbar"}
              >
                <li>
                  <a href="/mainpage" className="active">
                    Anasayfa
                  </a>
                </li>
                <li>
                  <a href="/aboutus/getall">Hakkımızda</a>
                </li>
                <li>
                  <a href="/Education/get">Eğitimler</a>
                </li>
                <li>
                  <a href="/news/getall">Haberler</a>
                </li>
                <li>
                  <a href="/contactpage/get">İletişim</a>
                </li>
                <li></li>
              </ul>
            </div>
            <div id="mobile" onClick={handleClick}>
              <i
                id="bar"
                className={clicked ? "fas fa-times" : "fas fa-bars"}
              ></i>
            </div>
          </nav>
        </Col>
      </Container>
    </>
  );
}

export default Navbar2react;
