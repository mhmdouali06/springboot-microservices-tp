pipeline {
  agent any

  tools {
    maven 'M3'
    jdk 'JDK17'
  }

  stages {
    stage('Build') {
      steps {
        git branch: 'main', url: 'https://github.com/mhmdouali06/springboot-microservices-tp.git'
        bat 'mvn clean install -DskipTests'
      }
    }
  }
    
   stages {
          stage("build & SonarQube analysis") {
            agent any
            steps {
              withSonarQubeEnv('My SonarQube Server') {
                bat 'mvn clean package sonar:sonar'
              }
            }
          }
   }
   stage("Quality Gate") {
            steps {
              timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
              }
            }
          }

    stage('Run') {
      steps {
                    bat 'mvn -pl runner-ms spring-boot:run -DskipTests'
      }
    }
    
  
}
