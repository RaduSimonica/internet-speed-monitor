#!/usr/bin/env groovy
pipeline {
    agent any

    parameters {
        string(
            name: "serviceName",
            defaultValue: "internet-speed-monitor",
            description: "The name of the service."
        )
        string(
            name: "path",
            defaultValue: "/home/pi/services/internet-speed-monitor.jar",
            description: "Path and file name for the Internet Speed Monitoring service."
        )
    }

    stages {
        stage("Clone repository") {
            steps {
                cleanWs()
                sh "git clone --branch master https://github.com/RaduSimonica/internet-speed-monitor.git"
            }
        }

        stage ("Build & Test") {
            steps {
                sh "mvn install -DskipTests"
            }
        }

        stage("Deploy JAR") {
            steps {
                sh "sudo cp target/*.jar $path"
            }
        }

        stage("Register service") {
            steps {
                sh "sudo sed -i 's+ExecStart=+ExecStart=java -jar $path+g' .service"
                sh "sudo cp .service /etc/systemd/system/$serviceName.service"
            }
        }

        stage("Start service") {
            steps {
                sh "sudo systemctl start serviceName.service"
            }
        }
    }
}