pipeline {
  agent any
  stages {
    stage('Run the tests') {
      steps {
        sh './mvnw clean test'
      }
    }
  }
  post {
    always {
      junit 'target/surefire-reports/*.xml'
      script {
          // Assuming you want to log the test results or any other relevant message
          def logMessage = "Test results processed."
          sendSplunkConsoleLog {
            rawMessage true
            message logMessage  // Pass your message here
          }
      }
    }
  }
}
