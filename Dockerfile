FROM postgres:10

WORKDIR ./migration

COPY ./src/main/resources/schema.sql /docker-entrypoint-initdb.d/V1__Schema.sql
COPY ./src/main/resources/data.sql /docker-entrypoint-initdb.d/V2__Data.sql

CMD ["docker-entrypoint.sh", "postgres"]

EXPOSE 5432


