import React, { useState, useEffect } from "react";
import {
  MDBFooter,
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBIcon,
} from "mdb-react-ui-kit";
import "./footer.scss";
import "mdbreact/dist/css/mdb.css";
import "@fortawesome/fontawesome-free/css/all.min.css";
import { ContactService } from "../../services/ContactService";
import { AboutusService } from "../../services/AboutusService";
import { SocialmediaService } from "../../services/SocialmediaService";

export default function Footer() {
  const [contactData, setContactData] = useState([]);
  const [aboutusData, setAboutusData] = useState([]);
  const [socialmediaData, setSocialmediaData] = useState([]);

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

  useEffect(() => {
    (async () => {
      try {
        const fetchAboutus = await AboutusService.getAboutus();
        setAboutusData(fetchAboutus);
      } catch (error) {
        console.log("API çağrısı olumsuz: ", error);
      }
    })();
  }, []);

  useEffect(() => {
    (async () => {
      try {
        const fetchSocialmedia = await SocialmediaService.getAllSocialmedia();
        setSocialmediaData(fetchSocialmedia);
      } catch (error) {
        console.log(error);
      }
    })();
  }, []);

  return (   
    <MDBFooter className="footer text-lg-start text-muted position-relative">
        <MDBContainer className="container d-flex justify-content-between align-items-center">
          <MDBCol>
          <MDBRow className="mt-4">
            <MDBCol  className=" mx-auto mb-3">
              <h6 className="text-left text-uppercase fw-bold mb-3 ">
                TÜBİTAK BİLGEM
              </h6>
              <p>{aboutusData.aboutus_content && <p>{aboutusData.aboutus_content.substring(0,369) + "..."}</p>}</p>
              <div>
                {socialmediaData.map((socialmedia, index) => (
                  <a
                    key={`link_${index}`}
                    href={socialmedia.socialmedia_link}
                    className="me-2 text-reset"
                  >
                    <MDBIcon
                      fab
                      icon={socialmedia.socialmedia_name}
                      color="white"
                      className="border border-1 p-2"
                    />
                  </a>
                ))}
              </div>
            </MDBCol>

            <MDBCol  className="MDBCol mx-auto mb-4">
              <h6 className="text-uppercase fw-bold mb-3">BİLGİLER</h6>
              <p>
                <a href="/aboutus/getall" className="text-reset">
                  Hakkımızda
                </a>
              </p>
              <p>
                <a href="/contactpage/get" className="text-reset">
                  İletişim
                </a>
              </p>
              <p>
                <a href="#!" className="text-reset">
                  Kullanım Şartları
                </a>
              </p>
              <p>
                <a href="#!" className="text-reset">
                  Gizlilik Politikası
                </a>
              </p>
            </MDBCol>

            <MDBCol  className="mx-auto mb-md-0 mb-4">
              <h6 className="text-uppercase fw-bold mb-3">İLETİŞİM</h6>

              <p>
                <MDBIcon fas icon="map-marker-alt"  className="me-2" />
                {contactData.contact_address}
              </p>

              <p>
                <MDBIcon icon="envelope" className="me-3" />
                {contactData.contact_email}
              </p>
              <p>
                <MDBIcon fas icon="phone-square"  className="me-3"/>
                {contactData.contact_tel}
              </p>
            </MDBCol>
          </MDBRow>
          <MDBRow style={{ 
          backgroundColor: "rgba(60,60,60, 0.5)"
           }}>
          <p style={{
            margin:"5px",
          }} className="text-center">Tüm hakları TÜBİTAK-BİLGEM'e aittir. © 2023</p>
        </MDBRow>
          </MDBCol>
        </MDBContainer>
       
    </MDBFooter>
  );
}
