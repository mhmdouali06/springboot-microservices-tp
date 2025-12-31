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
        withSonarQubeEnv('sonar') {
            bat 'mvn clean package sonar:sonar'
        }
      }
    }

    stage('Quality Gate') {
        timeout(time: 5, unit: 'MINUTES') {
            waitForQualityGate abortPipeline: true
        }
    }

    stage('Run') {
      steps {
        bat 'mvn -pl runner-ms spring-boot:run -DskipTests'
      }
    }
  }
}
