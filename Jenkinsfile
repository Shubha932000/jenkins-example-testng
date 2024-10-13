pipeline {
  agent any
  options {
    timeout(time: 1, unit: 'HOURS')
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
      script {
        // Extract the test results summary
        def testResults = getTestResultsSummary('target/surefire-reports/*.xml')

        // Send only the test results part to Splunk
        sendSplunkConsoleLog {
          rawMessage true
          message testResults
        }
      }
    }
  }
}

def getTestResultsSummary(reportPath) {
  // Read and parse the Surefire test report XML files
  def xmlFiles = findFiles(glob: reportPath)
  def testSummary = ""

  xmlFiles.each { file ->
    def testReport = readFile(file.path)
    def parsedReport = new XmlSlurper().parseText(testReport)
    echo parsedReport.toString()

    // Extract relevant test summary details like total tests, failures, errors, etc.
    def testsRun = parsedReport.@tests
    def failures = parsedReport.@failures
    def errors = parsedReport.@errors
    def skipped = parsedReport.@skipped

    testSummary += "Test Report for ${file.path}:\n"
    testSummary += "Total Tests: ${testsRun}\n"
    testSummary += "Failures: ${failures}\n"
    testSummary += "Errors: ${errors}\n"
    testSummary += "Skipped: ${skipped}\n"
    testSummary += "------------------------\n"
  }

  return testSummary
}
