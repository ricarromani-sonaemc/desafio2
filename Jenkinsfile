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
        
        stage("hello-world") {
            steps {
                script {
                    gv.hello-world()
                }

            }
        }
    }   
}