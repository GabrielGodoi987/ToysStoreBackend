FROM postgres:17-alpine

ENV POSTGRES_PASSWORD=docker
ENV POSTGRES_USER=root
ENV POSTGRES_DB=toysdb

RUN apk add --no-cache shadow && usermod -u 1000 postgres
