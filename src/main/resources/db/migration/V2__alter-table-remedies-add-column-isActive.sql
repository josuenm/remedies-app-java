ALTER TABLE remedies ADD active tinyint;
UPDATE remedies SET active = 1;