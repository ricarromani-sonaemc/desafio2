def call(body) {
    pipeline {
        agent any
        stages {
            stage('readYaml') {
                steps {
                    script {
                        ymlObj = readYaml file: "aqms-desafio2/vars/family.yaml" 
                        echo "${ymlObj}"
                        echo "${ymlObj.getClass()}"
                    }
                }
            }
        }
    }
} 
