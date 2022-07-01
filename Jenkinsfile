def gv

pipeline {
    agent any

    stages {
        
        stage("init") {
            steps {
                script {
                   gv = load "script.groovy" 
                   
                }
            }
        }
        
        stage("Execute hello") {
            steps {
                script {
                    gv.hello()
                }

            }
        }
    }   
}