import React, { useEffect, useState } from "react";
import { AboutusService } from "../../services/AboutusService";
import HeaderTr from "../headTr/HeadTr"


// import Container from 'react-bootstrap/Container';
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { Container } from "react-bootstrap";

function AboutUs() {
  const [aboutusData, setAboutusData] = useState([]);

  useEffect(() => {
    (async () => {
      console.log("use effect aboutus");
      const fetchAboutus = await AboutusService.getAllAboutus();
      setAboutusData(fetchAboutus);
    })();
  }, []);

  <Container>
    <Row className="elemnent"></Row>
  </Container>;

  return (
    <>
    <Row>
        <HeaderTr items="Hakkımızda"/>
    </Row>
    
    <Container>
      <Row className="m-5 justify-content-center"> 
        <Col md={8} >
          {aboutusData.map((aboutus) => (
              <Col>
              <Row >
                <h3 >
                  <b>{aboutus.aboutus_title}</b>
                </h3>
              </Row>
              <Row>
                <i> {aboutus.aboutus_content}</i>
              </Row>
              </Col>
          ))}
        </Col>
      </Row>
    </Container>
    </>
  );
}

export default AboutUs;
