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
                    reuseNode true /* Sinon crée le jar dans un autre workspace */
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
                echo 'Set up app with docker compose'
            }
        }
        stage('Deliver') {
            steps {
                input 'Push app ?'
                sh 'docker tag portepoisse/task-rest-services:latest registry:5000/portepoisse/task-rest-services:latest'
                sh 'docker push registry:5000/portepoisse/task-rest-services:latest'
                sh 'docker image rm registry:5000/portepoisse/task-rest-services:latest'
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