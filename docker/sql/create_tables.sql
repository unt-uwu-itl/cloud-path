-- Table for interfaces
CREATE TABLE IF NOT EXISTS interfaces
(
    id                SERIAL PRIMARY KEY,
    ethernet_type     VARCHAR(20),
    interface_number  VARCHAR(10),
    mac_address       VARCHAR(20),
    name              VARCHAR(50),
    uplink_bandwidth  INT,
    arp_timeout       INTERVAL,
    queue_strategy    VARCHAR(10),
    output_queue_size INT
);

-- Table for mac-address-table
CREATE TABLE IF NOT EXISTS mac_address_table
(
    id          SERIAL PRIMARY KEY,
    vlan        INT,
    mac_address VARCHAR(20),
    type        VARCHAR(10),
    port_number VARCHAR(10),
    port_type   VARCHAR(5)
);