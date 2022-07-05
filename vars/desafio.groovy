def call(body) {
    pipeline {
        agent any
        stages {
            stage('Hello world') {
                steps {
                    echo "hello"
                }
            }
        }
    }
} 
