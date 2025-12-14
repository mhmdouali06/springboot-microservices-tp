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

    stage('Run') {
      steps {
        timeout(2) {
                    bat 'mvn -pl runner-ms spring-boot:run -DskipTests'

}
      }
    }
  }
}
