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
                sh 'pwd'
                sh 'ls'
                sh 'mvn -DskipTests clean package -f app'
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