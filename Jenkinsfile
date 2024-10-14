pipeline {
  agent any
  options {
    timeout(time: 1, unit: 'HOURS')
    // sendSplunkConsoleLog() // Uncomment if you want to send logs to Splunk
  }
  stages {
    stage('Compile the project') {
      steps {
        // Compile the project
        sh './mvnw clean compile'
      }
    }
    stage('Run TestRunner class') {
      steps {
        // Run the TestRunner class
        sh './mvnw exec:java -Dexec.mainClass="src.test.java.com.planetpope.testng.TestRunner"'
      }
    }
  }
  post {
    always {
      // Generate and archive test reports
      junit 'target/surefire-reports/*.xml'
    }
  }
}
