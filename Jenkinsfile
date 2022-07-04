def gv
def objYaml

pipeline {
    agent any

    stages {
        
        stage("init") {
            steps {
                script {
                   gv = load "pipeline/script.groovy" 
                   ymlObj = readYaml(file: "yaml-families/family.yaml")
                    
}
                   
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