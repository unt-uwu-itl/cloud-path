#!/bin/bash
echo "Stopping Docker containers..."

# Navigate to the Docker directory
cd "$(dirname "$0")"/..

# Stop Docker containers
docker-compose down

echo "Docker containers have been stopped."
