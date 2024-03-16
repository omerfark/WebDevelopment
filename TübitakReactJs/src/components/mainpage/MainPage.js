import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import { EducationService } from "../../services/EducationService";
import { NewsService } from "../../services/NewsService";
import { Container } from "react-bootstrap";
import Card from "react-bootstrap/Card";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import Button from "react-bootstrap/Button";
import DateWeb from "../dateweb/DateWeb";
import Carousel from "react-bootstrap/Carousel";
import "./MainPage.scss";
import slay1 from "../../assets/Mainpage/slayt1.png";
import slay2 from "../../assets/Mainpage/slayt2.png";
import slay3 from "../../assets/Mainpage/slayt3.png";
import { NewsImageService } from "../../services/NewsImageService";

function MainPage() {
  const [educationData, setEducationData] = useState([]);
  const [newsData, setNewsData] = useState([]);

  useEffect(() => {
    (async () => {
      try {
        const fetchEducationData = await EducationService.getMainEducation();
        setEducationData(fetchEducationData);
      } catch (error) {
        console.log(error);
      }
    })();
  }, []);

  useEffect(() => {
    (async () => {
      const fetchNews = await NewsService.getAllNews();
      setNewsData(fetchNews);
    })();
  }, []);

  //For news data
  const getFilterNews = (newsData) => {
    const maxNewsCount = 3; // Son 3 haber
    return newsData.slice(-maxNewsCount);
  };

  //news image Data
  const [allImage, setAllImage] = useState([]);
  useEffect(() => {
    (async () => {
      const fetchAllImage = await NewsImageService.getAllImage();
      setAllImage(fetchAllImage);
    })();
  }, []);

  const [educationImage, seteducationImage] = useState([]);
  useEffect(() => {
    (async () => {
      const fetchEducationImage = await EducationService.getAllEduStep();
      seteducationImage(fetchEducationImage);
    })();
  }, []);

  //education ımage control
  const controlEduImage = new Set();
  return (
    <>
      <Carousel>
        <Carousel.Item>
          <img
            src={slay1}
            alt="slyt1"
            style={{
              height: "800px",
              width: "2000px",
            }}
          />
          <Carousel.Caption className="CarouselCaption">
            <h3>First slide label</h3>
            <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img
            src={slay2}
            alt="slyt1"
            style={{
              height: "800px",
              width: "2000px",
            }}
          />
          <Carousel.Caption className="CarouselCaption">
            <h3>Second slide label</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img
            src={slay3}
            alt="slyt1"
            style={{
              height: "800px",
              width: "2000px",
            }}
          />
          <Carousel.Caption className="CarouselCaption">
            <h3>Third slide label</h3>
            <p>
              Praesent commodo cursus magna, vel scelerisque nisl consectetur.
            </p>
          </Carousel.Caption>
        </Carousel.Item>
      </Carousel>
      <Container>
        <Row className="mt-5 mb-5">
          {educationData.map((education) => (
            <Col className=" mainpage_card ">
              <a href={`/eduContent/get/${education.education_id}`}>
                <Card
                  style={{
                    width: "36rem",
                    height: "19rem",
                  }}
                >
                  <div className="card-image-container">
                    {educationImage.map((educationImage) => {
                      const idControl = education.education_id;
                      const imageIdControl =
                        educationImage.education_id.education_id;
                      if (
                        parseInt(idControl) === imageIdControl &&
                        !controlEduImage.has(
                          educationImage.education_id.education_id
                        )
                      ) {
                        controlEduImage.add(
                          educationImage.education_id.education_id
                        );
                        return (
                          <Card.Img
                            src={`data:image/png;base64,${educationImage.educationstep_image}`}
                            alt="Resim"
                            style={{
                              width: "100%",
                              height: "310px",
                              objectFit: "cover",
                            }}
                          ></Card.Img>
                        );
                      }
                      return null;
                    })}
                    <div className="card-text-overlay pt-4">
                      <Card.Body>
                        <Card.Title>{education.education_name}</Card.Title>
                        <Card.Text style={{ color: "black" }}>
                          {education.education_educator}
                        </Card.Text>
                      </Card.Body>
                    </div>
                  </div>
                </Card>
              </a>
            </Col>
          ))}
        </Row>
      </Container>

      <Container style={{ backgroundColor: "whitesmoke", width: "auto" }}>
        <Row className="mt-5 mb-5 ">
          <h2 className="mt-5">
            <b>Haber İçerikleri</b>
          </h2>
          <text>
            {" "}
            ufak bir yazı yazıyorum. nasıl göründüğünü test etmek amaccıyla
          </text>
          {getFilterNews(newsData).map((news) => (
            <div className="col mainpage_card">
              <Card style={{ width: "21rem" }} className="mainpage_card ">
                {allImage.map((imageControl) => {
                  const idControl = news.news_id;
                  const imageIdControl = imageControl.news_id.news_id;
                  if (parseInt(idControl) === imageIdControl) {
                    return (
                      <Card.Img
                        variant="top"
                        src={`data:image/png;base64,${imageControl.newsimage_link}`}
                        alt="Resim"
                        style={{
                          width: "100%",
                          height: "210px",
                          objectFit: "cover",
                        }}
                      ></Card.Img>
                    );
                  }
                  return null;
                })}
                {/* <Card.Img src={slay1} alt="Resim"></Card.Img> */}
                {/* //şuan görsel tek 1 id den çekiliyor */}
                <Card.Body style={{ width: "330px", marginBottom: "10px" }}>
                  <Card.Title title={news.news_title}
                    style={{
                      fontSize: "18px",
                      fontWeight: "bold",
                      whiteSpace: "nowrap",
                      overflow: "hidden",
                      textOverflow: "ellipsis",
                    }}
                  >
                    {news.news_title}
                  </Card.Title>
                  <Card.Text 
                    style={{
                      justifyContent: "space-between",
                      alignItems: "right",
                      marginTop:"10px"
                    }}
                  >
                    <DateWeb date={news.create_date} />
                  </Card.Text>
                  <Card.Text > 
                    {news.news_content.substring(0, 100) + "..."}
                  </Card.Text>
                  <Button
                    href={`/newsContent/get/${news.news_id}`}
                    variant="primary"
                    style={{ marginTop: "10px", textAlign: "center" }}
                  >
                    Detaya Git...
                  </Button>
                </Card.Body>
              </Card>
            </div>
          ))}
        </Row>
      </Container>
    </>
  );
}

export default MainPage;
