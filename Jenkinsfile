def gv
def objYaml

pipeline {
    agent any

    stages {
        
        /*
        stage("init") {
            steps {
                script {
                   gv = load "pipeline/script.groovy" 
                   
                    
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
        */

        stage("Testing readYaml") {
            steps {
                script {
                    ymlObj = readYaml file: "yaml-families/family.yaml" 
                    echo "${ymlObj}"
                    echo "${ymlObj.getClass()}"
                    /*
                    families = ymlObj[families]
                    families.each { e ->
                        echo "Translating ${e.getAt('family')}"
                    }
                    */
                }

            }
        }

    }
}