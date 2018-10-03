pipeline {
    agent any
    stages {
        stage('Init'){
            steps {
                echo 'Init'
            }
        }
    }
    post {
        always {
            deleteDir() /* clean up workspace */
        }
    }
}