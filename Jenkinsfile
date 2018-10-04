pipeline {
    agent any
    stages {
        stage('Init') {
            steps {
                echo 'Init'
            }
        }
        stage('Package') {
            agent {
                docker {
                    image 'maven:3.5.4-alpine'
                    args '--volume maven:/root/.m2'
                }
            }
            steps {
                sh 'mvn clean package -f app'
                junit 'app/target/surefire-reports/*.xml'
            }
        }
        stage('Image') {
            steps {
                sh 'docker build -t portepoisse/task-rest-services:latest app'
            }
        }
        stage('Integration') {
            steps {
                sh 'docker tag portepoisse/task-rest-services:latest portepoisse/task-rest-services:integration'
            }
        }
        stage('End') {
            steps {
                input 'Close ?'
            }
        }
    }
    post {
        always {
            deleteDir() /* clean up workspace */
        }
    }
}