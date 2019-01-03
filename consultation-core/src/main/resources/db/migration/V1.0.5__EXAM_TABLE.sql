-- EXAM
CREATE TABLE `EXAMS` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_AT` datetime NOT NULL,
  `CREATED_BY` varchar(50) NOT NULL,
  `ENTITY_STATUS` varchar(15) NOT NULL,
  `UPDATED_AT` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(50) DEFAULT NULL,
  `UUID` varchar(50) NOT NULL,
  `MEDICAL_SERVICE_TYPE_ID` bigint(20) NOT NULL,
  `HEALTH_FACILITY_ID` bigint(20) NOT NULL,
  `EXAM_DATE` date NOT NULL,
  `EXAM_TIME` time DEFAULT NULL,
  `PATIENT_UUID` varchar(50) NOT NULL,
  `EXAM_STATUS` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_EXAMS_HEALTH_FACILITY_ID` (`HEALTH_FACILITY_ID`),
  KEY `FK_EXAMS_MEDICAL_SERVICE_TYPE_ID` (`MEDICAL_SERVICE_TYPE_ID`),
  CONSTRAINT `FK_EXAMS_MEDICAL_SERVICE_TYPE_ID` FOREIGN KEY (`MEDICAL_SERVICE_TYPE_ID`) REFERENCES `MEDICAL_SERVICE_TYPES` (`ID`),
  CONSTRAINT `FK_EXAMS_HEALTH_FACILITY_ID` FOREIGN KEY (`HEALTH_FACILITY_ID`) REFERENCES `HEALTH_FACILITIES` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8