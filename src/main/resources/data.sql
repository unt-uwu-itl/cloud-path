-- Create the table
CREATE TABLE arp_entry
(
    id               BIGINT PRIMARY KEY AUTO_INCREMENT,
    protocol         VARCHAR(50) NOT NULL,
    address          VARCHAR(50) NOT NULL,
    age              VARCHAR(10),
    hardware_address VARCHAR(50) NOT NULL,
    type             VARCHAR(10) NOT NULL,
    interface_name   VARCHAR(50) NOT NULL
);

-- Insert sample data
INSERT INTO arp_entry (protocol, address, age, hardware_address, type, interface_name)
VALUES ('Internet', '172.16.1.5', '-', '00E0.8F51.BE01', 'ARPA', 'Vlan2'),
       ('Internet', '192.168.10.1', '10', '00E0.8F51.CD02', 'ARPA', 'Vlan10'),
       ('Internet', '10.0.0.5', '30', '00E0.8F51.AB03', 'ARPA', 'Vlan20'),
       ('Internet', '172.16.2.10', '15', '00E0.8F51.DC04', 'ARPA', 'Vlan30');
