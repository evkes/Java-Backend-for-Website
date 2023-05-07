USE tableboi;

INSERT INTO person (fullname, phone, userType, userLoc)
VALUES
  ('John Smith', '123-456-7890', 'Rider', '123 Main St'),
  ('Jane Doe', '987-654-3210', 'Driver', '456 Elm St'),
  ('Bob Johnson', '555-555-5555', 'Both', '789 Oak St'),
  ('Sarah Lee', '111-222-3333', 'Rider', '321 Maple Ave');

INSERT INTO sched (start_place, end_place, start_time, end_time, day_of_week, person_id)
VALUES
  ('123 Main St', '456 Elm St', '08:00:00', '08:30:00', 'Monday', 1),
  ('456 Elm St', '789 Oak St', '09:00:00', '09:30:00', 'Monday', 2),
  ('789 Oak St', '123 Main St', '10:00:00', '10:30:00', 'Tuesday', 3),
  ('123 Main St', '321 Maple Ave', '11:00:00', '11:30:00', 'Tuesday', 4);

INSERT INTO vehicle (licensePlate, make, model, mpg)
VALUES
  ('ABC123', 'Toyota', 'Camry', 30),
  ('DEF456', 'Honda', 'Civic', 35),
  ('GHI789', 'Ford', 'Mustang', 25);

INSERT INTO driver (personId, vehicleId)
VALUES
  (2, 1),
  (3, 2),
  (4, 3);
