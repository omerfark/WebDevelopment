import React, { useEffect, useState } from "react";
import { EducationService } from "../../services/EducationService";
// import DateWeb from "../dateweb/DateWeb";

// import Container from 'react-bootstrap/Container';
import Row from "react-bootstrap/Row";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import { Container } from "react-bootstrap";
import HeaderTr from "../headTr/HeadTr";
import "./Education.scss";

function Education() {
  const [eduStepData, setEduStepData] = useState([]);

  useEffect(() => {
    (async () => {
      const fetchEduStep = await EducationService.getAllEduStep();
      setEduStepData(fetchEduStep);
    })();
  }, []);

  return (
    <>
      <HeaderTr items="Konular" />
      <Container>
        <Row>
          {eduStepData.map((edustep) => (
            <div className="col-4 mt-5 ">
              <Card
                style={{ width: "19rem" }}
                className="mainpage_card   mx-auto  .card-content "
              >
                <Card.Img
                  variant="top"
                  src={`data:image/png;base64,${edustep.educationstep_image}`}
                  alt="resiim"
                  style={{
                    width: "100%",
                    height: "190px",
                    objectFit: "cover",
                  }}
                />
                <Card.Body style={{ width: "300px", marginBottom: "10px" }}>
                  <Card.Title  title={edustep.educationstep_title}
                    style={{
                      fontSize: "18px",
                      fontWeight: "bold",
                      whiteSpace: "nowrap",
                      overflow: "hidden",
                      textOverflow: "ellipsis",
                    }}
                  >
                    {edustep.educationstep_title}
                  </Card.Title>
                  {/* <Card.Text
                    style={{
                      justifyContent: "space-between",
                      alignItems: "right",
                    }}
                  >
                    <DateWeb date={edustep.education_id.create_date} />
                  </Card.Text> */}
                  <Card.Text>
                    {edustep.educationstep_content.substring(0, 100) + "..."}
                  </Card.Text>
                  <Button
                    href={`/eduContent/get/${edustep.education_id.education_id}`}
                    style={{ marginTop: "10px", textAlign: "center" }}
                  >
                    Go somewhere
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

export default Education;
