USE tableboi;

INSERT INTO person (fullname, phone, userType, userLoc)
VALUES
  ('Evan Kessler', '732-320-0158', 'Driver', 'The Reserve At Clemson'),
  ('Addison Hough', '304-579-9156', 'Rider', 'The Reserve At Clemson'),
  ('Ben Ingerslew', '803-659-7983', 'Both', 'University Village'),
  ('Sean Murri', '803-415-5338', 'Rider', 'University Village');

INSERT INTO sched (start_place, end_place, start_time, end_time, day_of_week, person_id)
VALUES
  ('Tillman Hall', 'McAdams Hall', '08:00:00', '08:30:00', 'Monday', 1),
  ('Tillman Hall', 'McAdams Hall', '09:00:00', '09:30:00', 'Monday', 2),
  ('School of Business', 'McAdams Hall', '10:00:00', '10:30:00', 'Tuesday', 3),
  ('School of Business', 'Lee Hall', '11:00:00', '11:30:00', 'Tuesday', 4);

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
