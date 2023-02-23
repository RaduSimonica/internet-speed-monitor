#!/usr/bin/env groovy
pipeline {
    agent any

    stages {
        stage("Clone repository") {
            steps {
                cleanWs()
                sh "git clone --branch master https://github.com/RaduSimonica/internet-speed-monitor.git ."
            }
        }

        stage ("Build & Test") {
            steps {
                sh "mvn install -DskipTests"
            }
        }

        stage("Deploy JAR") {
            steps {
                sh "sudo cp target/*.jar /home/pi/services/internet-speed-monitor.jar"
            }
        }

        stage("Register service") {
            steps {
                sh "sudo cp .service /etc/systemd/system/internet-speed-monitor.service"
                sh "sudo systemctl enable internet-speed-monitor.service"
            }
        }

        stage("Start service") {
            steps {
                sh "sudo systemctl start internet-speed-monitor.service"
            }
        }
    }
}