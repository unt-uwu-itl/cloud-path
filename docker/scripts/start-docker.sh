#!/bin/bash
echo "Starting Docker containers for PostgreSQL and RabbitMQ..."

# Navigate to the Docker directory
cd "$(dirname "$0")"/..

# Start Docker containers using Docker Compose
docker-compose up -d

# Check the status of the containers
docker-compose ps

# Initialize the database
././scripts/init-db.sh

echo "Docker containers are up and running."
