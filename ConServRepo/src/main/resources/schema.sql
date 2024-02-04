CREATE TABLE IF NOT EXISTS springdb.syain (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS springdb.company (
  `compid` int(11) NOT NULL,
  `compname` varchar(255) NOT NULL,
  `compmember` int(11) NOT NULL,
  `compboss` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;