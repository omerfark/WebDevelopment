import React, { useState, useEffect } from "react";
import { EducationService } from "../../services/EducationService";
import "./EducationContent.scss";
import HeaderTr from "../headTr/HeadTr";
import { Container, Row, Col, Image } from "react-bootstrap";
import { useParams } from "react-router-dom";

export default function EducationContent() {
  const [educontentData, setEducontentData] = useState([]);
  const [educationData, seteducationData] = useState([]);
  const { id } = useParams();

  useEffect(() => {
    (async () => {
      const fetcEduContent = await EducationService.getAllEduStep();
      setEducontentData(fetcEduContent);
    })();
  }, []);

  useEffect(() => {
    (async () => {
      const fetcEducation = await EducationService.getByIdEducation(id);
      seteducationData(fetcEducation);
    })();
  }, [id]);

  const shownEducationNames = new Set();
  const setEducationId = new Set();

  const SearchPage = () => {
    return (
      <div class="search-bar mt-2 mb-2">
        <input type="text" placeholder="Search" aria-label="Search" />
        <button class="search-button">
          <i class="fas fa-search"></i>
        </button>
      </div>
    );
  };

  const titleHold = new Set();
  return (
    <>
      <HeaderTr items="Konular" />
      <Container className="mt-5">
        <Row>
          <Col md={3}>
            <Row>{SearchPage()}</Row>
            <Row>
              <b
                style={{
                  textAlign: "left",
                  fontSize: "1.5rem",
                }}
              >
                Konular
              </b>
              <hr />
            </Row>
            <Row>
              <ul>
                {educontentData.map((edustepone) => {
                  const educationName = edustepone.education_id.education_name; //sadece education name tutar
                  const educationId = edustepone.education_id.education_id; //sadece education id tutar
                  if (
                    educationName &&
                    !shownEducationNames.has(educationName)
                  ) {
                    shownEducationNames.add(educationName);
                    setEducationId.add(educationId);
                    return (
                      <li>
                        <a href={`/eduContent/get/${edustepone.education_id.education_id}`} ><b>{educationName}</b></a>
                        <ul>
                          {educontentData.map((educontent, index) => {
                            if (
                              educontent.education_id.education_id ===
                              educationId
                            ) {
                              console.log("girdi");
                              return (
                                <li>
                                  <a
                                    href={`/eduContent/get/${educontent.education_id.education_id}`}
                                  >
                                    {educontent.educationstep_title}
                                  </a>
                                </li>
                              );
                            }
                            return null;
                          })}
                        </ul>
                      </li>
                    );
                  }
                  return null;
                })}
              </ul>
            </Row>
          </Col>
          <Col md={8}>
            <Row>
              {educontentData.map((educationtit) => {
                const holdId1 = educationtit.education_id.education_id;
                const newId1 = id;
                if (
                  parseInt(newId1) === holdId1 &&
                  !titleHold.has(educationtit.education_id.education_name)
                ) {
                  titleHold.add(educationtit.education_id.education_name);
                  return (
                    <Row className=" justify-content-left headerBorder">
                      <i>
                        {"Anasayfa" +
                          " / " +
                          "Haberler" +
                          " / " +
                          educationtit.education_id.education_name}
                        {console.log("title geldimi:", titleHold)}
                      </i>
                    </Row>
                  );
                }
                return null;
              })}
            </Row>
            <Row className="mt-5 mb-5">
              {educontentData.map((educationTitle) => {
                const holdId = educationTitle.education_id.education_id;
                const newId = id; // id degeri string şekilde geldiği için integer parse etmem gerekti
                if (parseInt(newId) === holdId) {
                  return (
                    <>
                    <h3
                        style={{
                          textAlign: "center"
                        }}
                      >
                        {" "}
                        <b>{educationTitle.education_id.education_name}</b>
                      </h3>
                      <i>{educationTitle.education_id.education_content}</i>
                      <h3
                        style={{
                          textAlign: "center",
                        }}
                      >
                        {" "}
                        <b>{educationTitle.educationstep_title}</b>
                      </h3>
                      <i>{educationTitle.educationstep_content}</i>
                      <i>
                        <Image
                          src={`data:image/png;base64,${educationTitle.educationstep_image}`}
                          rounded
                          alt="resiim"
                          style={{
                            maxWidth: "100%",
                            height: "auto",
                          }}
                        />
                        {console.log(educationTitle.educationstep_image)}
                      </i>
                    </>
                  );
                }
                return null;
              })}
            </Row>
          </Col>
        </Row>
      </Container>
    </>
  );
}
