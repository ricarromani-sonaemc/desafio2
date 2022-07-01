def gv

pipeline {
    agent any

    stages {
        
        stage("init") {
            steps {
                script {
                   gv = load "pipeline/script.groovy" 
                   
                }
            }
        }
        
        stage("hello") {
            steps {
                script {
                    gv.hello()
                }

            }
        }
    }   
}