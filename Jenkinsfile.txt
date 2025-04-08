pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/errachidy10/Application-salle-de-sport-main1.git'
            }
        }
         stage('Test') {
             steps {
                 bat 'mvn test'
             }
         }
        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Build Docker image') {
            steps {
                bat 'docker build -t application_reservation .'
            }
        }
    }
}
