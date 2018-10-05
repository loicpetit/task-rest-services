FROM postgres:10-alpine

COPY initdb/ /docker-entrypoint-initdb.d/

ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=Support2424
ENV POSTGRES_DB=TaskRestServices

EXPOSE 5432
