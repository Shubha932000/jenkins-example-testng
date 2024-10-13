pipeline {
  agent any
  options {
          timeout(time: 1, unit: 'HOURS')
          sendSplunkConsoleLog()
  }
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
    }
  }
}
