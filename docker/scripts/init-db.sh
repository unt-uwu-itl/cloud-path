#!/bin/bash
echo "Initializing the database..."

# Wait for PostgreSQL to be ready
until docker exec postgres-db pg_isready -U postgres > /dev/null 2>&1; do
    echo "Waiting for PostgreSQL to be ready..."
    sleep 2
done

echo "PostgreSQL is ready. Running database scripts..."

# Run SQL scripts to set up the database and tables
docker exec -i postgres-db psql -U postgres < /home/gelopak/IdeaProjects/cloud-path/docker/sql/create_database.sql
docker exec -i postgres-db psql -U postgres -d cloud-path < /home/gelopak/IdeaProjects/cloud-path/docker/sql/create_tables.sql

echo "Database initialization complete."
