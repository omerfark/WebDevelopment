import React, { useState, useEffect } from "react";

import { ContactService } from "../../services/ContactService";
import "./ContactPage.scss";
import { MDBIcon } from "mdb-react-ui-kit";
import HeaderTr from "../headTr/HeadTr";

import Button from "react-bootstrap/Button";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import Row from "react-bootstrap/Row";
import { AboutusService } from "../../services/AboutusService";
import { Container } from "react-bootstrap";

export default function ContactPage() {
  const [contactData, setContactData] = useState([]);
  const [aboutusData, setAboutusData] = useState([]);
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    title: "",
    message: "",
  });

  useEffect(() => {
    (async () => {
      console.log("use effect aboutus");
      const fetchAboutus = await AboutusService.getAboutus();
      setAboutusData(fetchAboutus);
    })();
  }, []);

  useEffect(() => {
    (async () => {
      try {
        const fetchContact = await ContactService.getContactInfo();
        setContactData(fetchContact);
      } catch (error) {
        console.log(error);
      }
    })();
  }, []);

  //Contact form kısmı
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  useEffect(() => {
    (async () => {
      try {
      } catch (error) {
        console.log("post eror contact form", error);
      }
    })();
  },[]);
  
  const handleSubmit = async () => {
    try {
      await ContactService.postContactMessage(formData);
      // İstek başarılı ise gerekli işlemleri yapabilirsiniz.
    } catch (error) {
      console.error("Hata:", error);
      // Hata durumlarında gerekli işlemleri yapabilirsiniz.
    }
  };

  return (
    <>
      <HeaderTr items="İletişim" />
      <Container className="mb-5 mt-5">
        <Row>
          <Col md={4} className="custom-card_info m-5 ">
            <Row className="m-3">
              <h3>
                <b>İletişim Bilgileri</b>
              </h3>
              <i>
                {aboutusData.aboutus_content && (
                  <i>{aboutusData.aboutus_content.substring(0, 367)}</i>
                )}
              </i>
              <i>
                <b>
                  <MDBIcon
                    fas
                    icon="map-marker-alt"
                    className="me-2"
                    id="color"
                  />
                  {" Adres: " + contactData.contact_address}
                </b>
              </i>
              <i>
                <b>
                  <MDBIcon
                    fas
                    icon="phone-square"
                    className="me-3"
                    id="color"
                  />
                  {" Telefon: " + contactData.contact_tel}
                </b>
              </i>
              <i>
                <b>
                  <MDBIcon icon="envelope" className="me-3" id="color" />

                  {" Email: " + contactData.contact_email}
                </b>
              </i>
            </Row>
          </Col>
          <Col className=" m-3 ">
            <Form onSubmit={handleSubmit}>
              <h3 id="left">
                <b>İletişime Geçin</b>
              </h3>
              <i
                className="mb-5"
                style={{
                  display: "block", // Öğeyi bir blok element olarak görüntülemek
                  width: "100%", // Yatayda tüm genişlikte olması için
                  textAlign: "left",
                }}
              >
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut in
                nunc tincidunt, sollicitudin nisl a, egestas magna. Sed molestie
                fermentum commodo. Mauris lobortis lacinia pulvinar. Quisque
                sodales tellus eu erat tincidunt, et rutrum augue imperdiet.
              </i>
              <Row className="mb-4">
                <Form.Group>
                  <Form.Control
                    type="text"
                    name="name"
                    placeholder="Adınız Soyadınız"
                    value={formData.name}
                    onChange={handleChange}
                  />
                </Form.Group>
              </Row>
              <Row className="mb-4">
                <Form.Group>
                  <Form.Control
                    type="email"
                    name="email"
                    placeholder="Email"
                    value={formData.email}
                    onChange={handleChange}
                  />
                </Form.Group>
              </Row>
              <Row className="mb-4">
                <Form.Group>
                  <Form.Control
                    type="text"
                    name="title"
                    placeholder="Konu Başlığı"
                    value={formData.title}
                    onChange={handleChange}
                  />
                </Form.Group>
              </Row>
              <Row className="mb-4">
                <Form.Group>
                  <Form.Control
                    as="textarea"
                    name="message"
                    rows={3}
                    placeholder="Mesajınız"
                    value={formData.message}
                    onChange={handleChange}
                  />
                </Form.Group>
              </Row>
              <Button variant="primary" type="submit">
                Gönder
              </Button>
            </Form>
          </Col>
        </Row>
      </Container>
    </>
  );
}
