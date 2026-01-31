package OnlineVoting;

public class dbms {
	CREATE DATABASE online_voting;
	USE online_voting;

	CREATE TABLE voters (
	    voter_id INT PRIMARY KEY,
	    has_voted BOOLEAN
	);

	CREATE TABLE candidates (
	    candidate_id INT PRIMARY KEY,
	    name VARCHAR(50),
	    votes INT
	);

	INSERT INTO candidates VALUES
	(1,'Candidate A',0),
	(2,'Candidate B',0),
	(3,'Candidate C',0);


}
