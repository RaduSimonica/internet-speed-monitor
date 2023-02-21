# syntax=docker/dockerfile:1

FROM maven:3.8.7-amazoncorretto-19
RUN yum -y update && yum -y upgrade
RUN yum install curl
RUN curl -s https://packagecloud.io/install/repositories/ookla/speedtest-cli/script.rpm.sh | bash
RUN yum -y install speedtest
COPY . /internet-speed
WORKDIR /internet-speed