CREATE DATABASE IF NOT EXISTS expense_tracker_db;

USE expense_tracker_db;

CREATE TABLE IF NOT EXISTS expense_tracker_db.expense_category (
	category VARCHAR(255) PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS expense_tracker_db.expense (
	expense_id INT,
	expense_amount DECIMAL(10,2) NOT NULL,
	category VARCHAR(255) NOT NULL,
	description VARCHAR(255),
	expense_date DATE NOT NULL,
	CREATEd_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	last_modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	user_id VARCHAR(255) NOT NULL,
	PRIMARY KEY (expense_id),
	FOREIGN KEY (category) REFERENCES expense_tracker_db.expense_category(category)
);

CREATE INDEX expense_date_index ON expense_tracker_db.expense (expense_date);
commit;