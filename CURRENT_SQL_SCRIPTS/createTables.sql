CREATE SCHEMA IF NOT EXISTS tableboi;
use tableboi;

CREATE TABLE person (
  personId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  fullname VARCHAR(255) NOT NULL,
  phone VARCHAR(20) NOT NULL,
  userType ENUM('Rider', 'Driver', 'Both') NOT NULL,
  userLoc VARCHAR(100) NOT NULL
);

CREATE TABLE sched (
  schedId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  start_place VARCHAR(50) NOT NULL,
  end_place VARCHAR(50) NOT NULL,
  start_time TIME NOT NULL,
  end_time TIME NOT NULL,
  day_of_week ENUM('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday') NOT NULL,
  person_id INT NOT NULL,
  CONSTRAINT fk_person_id
    FOREIGN KEY (person_id) REFERENCES person (personId)
    ON DELETE CASCADE
);

CREATE TABLE vehicle (
	vehicleId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    licensePlate VARCHAR(10) NOT NULL,
    make VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    mpg INT NOT NULL
);

CREATE TABLE driver (
  personId INT NOT NULL,
  vehicleId INT NOT NULL,
  PRIMARY KEY (personId),
  FOREIGN KEY (personId) REFERENCES person (personId) ON DELETE CASCADE,
  FOREIGN KEY (vehicleId) REFERENCES vehicle (vehicleId) ON DELETE CASCADE
);