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

    stage('build & SonarQube analysis') {
      steps {
        bat 'mvn clean package sonar:sonar -Dsonar.token=sqa_ac4ba011da0b9019c4e3be65fae544328fb545af -Dsonar.host.url=http://localhost:9000'
      }
    }

    stage('Quality Gate') {
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
}
