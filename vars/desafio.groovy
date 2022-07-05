def call(body) {
    pipeline {
        agent any
        stages {
            stage('readYaml') {
                steps {
                    ymlObj = readYaml file: "../yaml-families/family.yaml" 
                    echo "${ymlObj}"
                    echo "${ymlObj.getClass()}"
                }
            }
        }
    }
} 
