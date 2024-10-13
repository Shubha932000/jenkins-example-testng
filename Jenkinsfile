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
      sendSplunkConsoleLog() // Sends console log to Splunk
    }
  }
}
