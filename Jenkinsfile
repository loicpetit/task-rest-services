pipeline {
    agent none
    stages {
        stage('Init') {
            agent any
            steps {
                echo 'Init'
            }
        }
        stage('End') {
            agent any
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